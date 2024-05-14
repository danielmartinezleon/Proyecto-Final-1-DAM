package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@DiscriminatorValue("USER")
public class Cliente extends Usuario{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
