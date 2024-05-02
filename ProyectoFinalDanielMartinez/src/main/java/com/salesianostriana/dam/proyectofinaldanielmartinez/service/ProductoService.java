package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.base.BaseServiceImpl;

@Service
public class ProductoService 
	extends BaseServiceImpl<Producto, Long, ProductoRepository>{

}
