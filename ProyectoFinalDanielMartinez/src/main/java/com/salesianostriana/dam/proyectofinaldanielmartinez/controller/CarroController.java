package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Venta;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ClienteService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.VentaService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarroController {

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/user/agregar/{id}")
    public String agregarAlCarrito(@AuthenticationPrincipal Cliente logeado, @PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClienteActual(logeado);
        if (cliente != null) {
            ventaService.agregarProductoAlCarrito(cliente, id);
        }
        return "redirect:/user/carro";
    }

    @GetMapping("/user/carro")
    public String verCarrito(@AuthenticationPrincipal Cliente logeado, Model model) {
        Cliente cliente = clienteService.obtenerClienteActual(logeado);
        if (cliente != null) {
            Venta carrito = ventaService.obtenerCarritoDelCliente(cliente);
            model.addAttribute("carrito", carrito);
        }
        return "/user/carro";
    }

	
}
