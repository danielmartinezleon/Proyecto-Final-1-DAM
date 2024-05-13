package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	
	private double importeTotal;
	
	private double gastosEnvio;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente_venta"))
	private Cliente cliente;
	
	@OneToMany(mappedBy = "venta")
	private List<LineaVenta> lineas;
}
