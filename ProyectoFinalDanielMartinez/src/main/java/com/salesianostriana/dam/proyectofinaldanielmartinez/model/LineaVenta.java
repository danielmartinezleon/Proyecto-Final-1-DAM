package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class LineaVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	//private double pvp;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_producto"))
	private Producto producto;
	
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_linea_venta"))
	private Venta venta;
	
	public double getTotalLinea() {
		return producto.getPrecio() * cantidad;
	}

}
