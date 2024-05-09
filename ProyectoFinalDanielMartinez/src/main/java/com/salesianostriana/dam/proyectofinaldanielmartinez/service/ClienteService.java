package com.salesianostriana.dam.proyectofinaldanielmartinez.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.repository.ClienteRepository;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.base.BaseServiceImpl;

@Service
public class ClienteService 
	extends BaseServiceImpl<Cliente, Long, ClienteRepository>{

}
