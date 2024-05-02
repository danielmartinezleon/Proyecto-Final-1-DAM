package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Venta {

	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate fecha;
	
	private double importeTotal;
	
	private double gastosEnvio;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente_venta"))
	private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_admin_venta"))
	private Admin admin;
}
