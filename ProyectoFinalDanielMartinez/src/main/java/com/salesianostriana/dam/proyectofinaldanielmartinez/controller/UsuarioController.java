package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Admin;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ClienteService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
    private HttpSession httpSession;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
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
	
	@GetMapping("/user/profile")
    public String userProfile(Model model, @AuthenticationPrincipal Cliente cliente) {
        model.addAttribute("usuario", cliente);
    	return "/user/perfiluser";
    }
    
    @PostMapping("/user/profileEdit/submit")
    public String userEditProfile(@ModelAttribute("usuario") Cliente cliente) {
    	cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
    	Cliente clienteEdit = clienteService.edit(cliente);
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth = new UsernamePasswordAuthenticationToken(clienteEdit, auth.getCredentials(), auth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    	return "redirect:/user/profile";
    	
    }
}

