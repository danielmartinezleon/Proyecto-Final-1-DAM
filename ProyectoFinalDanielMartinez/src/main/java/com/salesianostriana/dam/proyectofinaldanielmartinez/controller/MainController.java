package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/melee")
	public String melee() {
		return "melee";
		
	}
	
	@GetMapping("/producto")
	public String producto() {
		return "producto";
		
	}
}
