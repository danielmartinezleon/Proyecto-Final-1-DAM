package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import java.time.LocalDate;
import java.util.List;
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
                    carritoNuevo.setGastosEnvio(0.0);
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
        ventaRepository.save(venta);
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
}
