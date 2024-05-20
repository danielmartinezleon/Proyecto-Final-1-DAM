package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Admin;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.repository.AdminRepository;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.base.BaseServiceImpl;

@Service
public class AdminService 
	extends BaseServiceImpl<Admin, Long, AdminRepository>{
    
	@Autowired
	private ProductoService productoService;
	
	public void aplicarDescuento(Long productoId, double cantidad) {
	    Producto producto = productoService.findById(productoId)
	            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

	    if (!producto.isDescuento()) {
	        
	        double descuento = (producto.getPrecio() * cantidad) / 100;
	        producto.setPrecio(producto.getPrecio() - descuento);
	        producto.setNombre(producto.getNombre() + " DESCUENTO");
	        producto.setDescuento(true);
	    } else {
	     
	        String nombreOriginal = producto.getNombre().replace(" DESCUENTO", "");
	        double precioOriginal = producto.getPrecio() / (1 - (cantidad / 100));
	        
	        producto.setNombre(nombreOriginal);
	        producto.setPrecio(precioOriginal);
	        producto.setDescuento(false);
	    }
	    productoService.save(producto);
	}

	
	public void ponerLiquidacion() {
	    List<Producto> catalogo = productoService.findAll();
	    
	    for (Producto producto : catalogo) {
	        if (producto.isDescuento()) {
	            
	            producto.setNombre(producto.getNombre().replace(" LIQUIDACIÓN", ""));
	            producto.setPrecio(producto.getPrecio() * 2);
	            producto.setDescuento(false);
	        } else if (producto.getStock() < 10) {
	            
	            producto.setNombre(producto.getNombre() + " LIQUIDACIÓN");
	            producto.setPrecio(producto.getPrecio() / 2);
	            producto.setDescuento(true);
	        }
	        productoService.edit(producto);
	    }
	}



}