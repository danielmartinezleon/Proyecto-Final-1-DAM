package com.salesianostriana.dam.proyectofinaldanielmartinez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	@Query("select count(l) from LineaVenta l where l.venta = ?1")
	int contarLineasVenta(Venta venta);
	
	@Query("select v from Venta v where v.abierta = true")
	List<Venta> buscarVentasAbiertas();
	
	@Query("select v from Venta v where v.abierta = false")
	List<Venta> buscarVentasCerradas();

	@Query("select v from Venta v where v.cliente = ?1 and v.abierta = false")
	List<Venta> buscarClienteYCerrada(Cliente cliente);
	
	@Query("SELECT v FROM Venta v WHERE v.cliente = :cliente AND v.abierta = true")
    List<Venta> buscarVentasAbiertasPorCliente(Cliente cliente);
	
	List<Venta> findByClienteAndAbiertaTrue(Cliente cliente);
}
