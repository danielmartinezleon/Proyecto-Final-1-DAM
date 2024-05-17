package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class LineaVentaPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long idVenta;
}
