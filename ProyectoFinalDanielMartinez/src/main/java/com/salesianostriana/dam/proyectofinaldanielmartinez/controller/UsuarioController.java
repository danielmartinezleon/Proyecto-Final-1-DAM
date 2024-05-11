package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;

@Controller
public class UsuarioController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/user")
	public String indexuser(Model model) {
		List<Producto> productos = productoService.seleccionarProductosAleatorios(4);
		model.addAttribute("productos", productos);
		return "/user/indexuser";
	}
	
	@GetMapping("/user/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "/user/meleeuser";
    }
	
	@RequestMapping("/user/producto/{id}")
    public String cargarProducto(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
        Producto producto = optionalProducto.get();
        System.out.println(producto);
        model.addAttribute("producto", producto);
        return "/user/productouser";
    }
	
	@GetMapping("/user/cuero")
	public String cuerouser() {
		return "/user/cuerouser";
		
	}
	
	@GetMapping("/user/armadura1")
	public String armadura1user() {
		return "/user/armadura1user";
		
	}
}
