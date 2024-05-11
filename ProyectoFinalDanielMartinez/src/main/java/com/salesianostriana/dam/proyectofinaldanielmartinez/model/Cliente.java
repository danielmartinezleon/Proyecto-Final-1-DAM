package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Cliente extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_registro;

	public Cliente(Long id, String username, String password, String nombre, String apellidos, String direccion, String email, LocalDate fecha_registro) {
		super(id, username, password);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.fecha_registro = fecha_registro;
	}

	
	

	
}
