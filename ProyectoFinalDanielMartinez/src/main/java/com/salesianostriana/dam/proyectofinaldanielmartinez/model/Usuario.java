package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String direccion;
	
	public Usuario(String nombre, String apellidos, String email, String password, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.direccion = direccion;
	}
	
	
	
	
	
}