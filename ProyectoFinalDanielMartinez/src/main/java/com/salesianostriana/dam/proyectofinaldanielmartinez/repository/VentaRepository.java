package com.salesianostriana.dam.proyectofinaldanielmartinez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	boolean existsByClienteAndLineas_Producto(Cliente cliente, Producto producto);

}
