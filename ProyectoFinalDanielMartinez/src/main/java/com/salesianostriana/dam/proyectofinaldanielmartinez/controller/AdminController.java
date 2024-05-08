package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;

import org.springframework.ui.Model;

@Controller
public class AdminController {

	@Autowired
    private ProductoService productoService;

    public AdminController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/admin")
	public String indexadmin() {
		return "indexadmin";
	}
    
    @GetMapping("/admin/perfil")
	public String perfiladmin() {
		return "perfiladmin";
	}
    
    @GetMapping("/admin/productos")
    public String listarProductosAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "meleeadmin";
    }
    
    @PostMapping("/admin/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos";
    }

   
    @PostMapping("/admin/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos";
    }
    
    @PostMapping("/admin/editarProducto/{id}")
    public String editarProducto(@PathVariable("id") Long id, @ModelAttribute Producto producto) {
        Optional<Producto> optionalProducto = productoService.findById(id);
        
        producto = optionalProducto.get();
        productoService.edit(producto);
        
        return "redirect:/admin/productos";
    }

}
