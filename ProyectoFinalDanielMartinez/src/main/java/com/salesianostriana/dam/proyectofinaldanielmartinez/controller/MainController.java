package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;


@Controller
public class MainController {

	@Autowired
	private ProductoService productoService;
	
	
	public MainController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Producto> productos = productoService.seleccionarProductosAleatorios(4);
		model.addAttribute("productos", productos);
        return "index";
	}
	
	
	
	@GetMapping("/melee")
    public String listarProductosAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "melee";
    }
	
	@GetMapping("/producto")
	public String producto() {
		return "producto";
		
	}
	
	
	@GetMapping("/cuero")
	public String cuero() {
		return "cuero";
		
	}
	
		
	@GetMapping("/armadura1")
	public String armadura1() {
		return "armadura1";
		
	}
	
	
	
}
