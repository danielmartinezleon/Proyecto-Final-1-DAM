package com.salesianostriana.dam.proyectofinaldanielmartinez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	@Query("select distinct p from Producto p where p.categoria.id = 1")
	List<Producto> productosMelee(List<Producto> cat);
	
	@Query("select distinct p from Producto p where p.categoria.id = 2")
	List<Producto> productosDistancia(List<Producto> cat);
	
	@Query("select distinct p from Producto p where p.categoria.id = 3")
	List<Producto> productosCuero(List<Producto> cat);
	
	@Query("select distinct p from Producto p where p.categoria.id = 4")
	List<Producto> productosMetal(List<Producto> cat);
}
