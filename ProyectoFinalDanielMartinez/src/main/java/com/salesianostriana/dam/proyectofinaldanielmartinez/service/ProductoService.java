package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.base.BaseServiceImpl;

@Service
public class ProductoService 
	extends BaseServiceImpl<Producto, Long, ProductoRepository>{
	
	public List<Producto> seleccionarProductosAleatorios(int n) {
        List<Producto> productos = findAll();
        List<Producto> productosAleatorios = new ArrayList<>();
        Random rand = new Random();
        int totalProductos = productos.size();
        for (int i = 0; i < n; i++) {
            int randomIndex = rand.nextInt(totalProductos);
            productosAleatorios.add(productos.get(randomIndex));
        }
        return productosAleatorios;
    }

}
