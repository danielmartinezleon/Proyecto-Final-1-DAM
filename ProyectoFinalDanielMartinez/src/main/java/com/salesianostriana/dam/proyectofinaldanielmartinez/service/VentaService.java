package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.LineaVenta;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Venta;
import com.salesianostriana.dam.proyectofinaldanielmartinez.repository.VentaRepository;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.base.BaseServiceImpl;

@Service
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository> {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoService productoService;
    
    private Map<Long, Boolean> codigoUsadoMap = new HashMap<>();

    public List<Venta> findByCliente(Cliente cliente) {
        return ventaRepository.buscarClienteYCerrada(cliente);
    }

    public void agregarProductoAlCarrito(Cliente cliente, Long productoId) {
        Venta venta = obtenerCarritoDelCliente(cliente);
        Producto producto = productoService.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Optional<LineaVenta> lineaVentaOpt = venta.getLineas().stream()
                .filter(linea -> linea.getProducto().getId().equals(productoId))
                .findFirst();

        if (lineaVentaOpt.isPresent()) {
            LineaVenta lineaVenta = lineaVentaOpt.get();
            lineaVenta.setCantidad(lineaVenta.getCantidad() + 1);
        } else {
            LineaVenta nuevaLinea = new LineaVenta();
            nuevaLinea.setProducto(producto);
            nuevaLinea.setCantidad(1);
            nuevaLinea.setVenta(venta);
            venta.addLineaVenta(nuevaLinea);
        }

        venta.setImporteTotal(calcularTotal(venta));
        ventaRepository.save(venta);
    }


    public Venta obtenerCarritoDelCliente(Cliente cliente) {
        List<Venta> ventasAbiertas = ventaRepository.buscarVentasAbiertasPorCliente(cliente);
        
        return ventasAbiertas.stream()
                .findFirst()
                .orElseGet(() -> {
                    Venta carritoNuevo = new Venta();
                    carritoNuevo.setCliente(cliente);
                    carritoNuevo.setAbierta(true);
                    carritoNuevo.setFecha(LocalDate.now());
                    carritoNuevo.setGastosEnvio(14.99);
                    return ventaRepository.save(carritoNuevo);
                });
    }

    private double calcularTotal(Venta venta) {
        return venta.getLineas()
                .stream()
                .mapToDouble(LineaVenta::getTotalLinea)
                .sum();
    }
    
    public void finalizarVenta(Cliente cliente) {
        Venta venta = obtenerCarritoDelCliente(cliente);
        venta.setAbierta(false);
        if(venta.getImporteTotal() < 500) {
        	venta.setImporteTotal(venta.getImporteTotal()+venta.getGastosEnvio());
        }else {
        	venta.setGastosEnvio(0.00);
        }
        
        ventaRepository.save(venta);
    }
    
    public void aplicarCodigo(Cliente cliente, String codigo) {
        Venta venta = obtenerCarritoDelCliente(cliente);
        double descuento = 0.0;
        
        if ("DESCUENTO15".equals(codigo) && !codigoUsadoMap.getOrDefault(cliente.getId(), false)) {
            descuento = (venta.getImporteTotal() * 15) / 100;
            venta.setImporteTotal(venta.getImporteTotal() - descuento);
            codigoUsadoMap.put(cliente.getId(), true);
            ventaRepository.save(venta);
        }else if ("DESCUENTO30".equals(codigo) && !codigoUsadoMap.getOrDefault(cliente.getId(), false)) {
            descuento = (venta.getImporteTotal() * 30) / 100;
            venta.setImporteTotal(venta.getImporteTotal() - descuento);
            codigoUsadoMap.put(cliente.getId(), true);
            ventaRepository.save(venta);
        }
    }

    
    public void eliminarProductoDelCarrito(Cliente cliente, Long productoId) {
        Venta venta = obtenerCarritoDelCliente(cliente);
        
        Optional<LineaVenta> lineaVentaOpt = venta.getLineas().stream()
                .filter(linea -> linea.getProducto().getId().equals(productoId))
                .findFirst();
        
        if (lineaVentaOpt.isPresent()) {
            LineaVenta lineaVenta = lineaVentaOpt.get();
            
            venta.getLineas().remove(lineaVenta);
            
            venta.setImporteTotal(calcularTotal(venta));
            ventaRepository.save(venta);
        }
    }
    
    public List<Venta> findByClienteAndCerrada(Cliente cliente) {
        return ventaRepository.buscarClienteYCerrada(cliente);
    }
}
