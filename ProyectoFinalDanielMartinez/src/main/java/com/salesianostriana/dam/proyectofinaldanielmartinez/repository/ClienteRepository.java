package com.salesianostriana.dam.proyectofinaldanielmartinez.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
