package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "melee";
    }
    
    @RequestMapping("/producto/{id}")
    public String cargarProducto(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
        Producto producto = optionalProducto.get();
        System.out.println(producto);
        model.addAttribute("producto", producto);
        return "producto";
    }
    
    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos";
    }
   
    @PostMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos";
    }


}