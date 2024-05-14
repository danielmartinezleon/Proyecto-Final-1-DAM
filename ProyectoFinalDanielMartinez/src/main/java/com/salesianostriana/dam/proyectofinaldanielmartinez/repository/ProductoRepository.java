package com.salesianostriana.dam.proyectofinaldanielmartinez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	/*
	@Query("select distinct p from Producto p where p.precio < 200")
	List<Producto> productosMenosDeDoscientos(List<Producto> catalogo);
	*/
}
