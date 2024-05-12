package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@DiscriminatorValue("USER")
public class Cliente extends Usuario{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
