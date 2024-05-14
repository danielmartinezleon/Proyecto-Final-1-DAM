package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Admin;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class AdminController {

	@Autowired
    private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private HttpSession httpSession;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    public AdminController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/admin")
	public String indexadmin(Model model) {
    	List<Producto> productos = productoService.seleccionarProductosAleatorios(4);
		model.addAttribute("productos", productos);
		return "/admin/indexadmin";
	}
    
    @GetMapping("/admin/perfil")
	public String perfiladmin() {
		return "/admin/perfiladmin";
	}
    
    @GetMapping("/admin/productos")
    public String listarProductosAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/meleeadmin";
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
    
    
    @GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/formularioprod";
		
	}
    
    @PostMapping("/editar/submit")
    public String procesarFormulario(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos";
    }

    @GetMapping("/admin/cuero")
	public String cueroadmin() {
		return "/admin/cueroadmin";
		
	}
    
    @GetMapping("/admin/profile")
    public String adminProfile(Model model, @AuthenticationPrincipal Admin admin) {
        
        model.addAttribute("admin", admin);
    	return "/admin/perfiladmin";
    }
    
    @PostMapping("/admin/profileEdit/submit")
    public String adminEditProfile(@ModelAttribute("admin") Admin admin) {
    	admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		usuarioService.edit(admin);
		httpSession.invalidate();
    	return "redirect:/login";
    	
    }
}
