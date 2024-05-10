package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("A")
public class Admin extends Usuario{

	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private List<Venta> ventas = new ArrayList<>();

	public Admin(Long id, String username, String nombre, String apellidos, String email, String password,
			String direccion) {
		super(id, username, nombre, apellidos, email, password, direccion);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_ADMIN";
		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

		
}
