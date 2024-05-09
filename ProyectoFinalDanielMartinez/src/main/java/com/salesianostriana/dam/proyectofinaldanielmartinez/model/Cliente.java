package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("C")
public class Cliente extends Usuario{

	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Venta> ventas = new ArrayList<>();
	
	
	public Cliente(Long id, String username, String nombre, String apellidos, String email, String password,
			String direccion) {
		super(id, username, nombre, apellidos, email, password, direccion);
	}

	
	
}
