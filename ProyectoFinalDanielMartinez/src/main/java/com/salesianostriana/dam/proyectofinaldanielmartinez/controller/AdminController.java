package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Admin;
import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Producto;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.AdminService;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.ProductoService;

import org.springframework.ui.Model;

@Controller
public class AdminController {

	@Autowired
    private ProductoService productoService;
	
	@Autowired
	private AdminService adminService;
	
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
    
    @GetMapping("/admin/productos/melee")
    public String listarMeleeAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/meleeadmin";
    }
    
    @RequestMapping("/admin/productos/melee/{id}")
    public String cargarProductoMelee(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
            Producto producto = optionalProducto.get();
            System.out.println(producto);
            model.addAttribute("producto", producto);
            return "/admin/productoadmin";
    }
    
    @RequestMapping("/admin/productos/distancia/{id}")
    public String cargarProductoDistancia(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
        Producto producto = optionalProducto.get();
        System.out.println(producto);
        model.addAttribute("producto", producto);
        return "/admin/productoadmin";
    }
    
    @GetMapping("/admin/productos/distancia")
    public String listarDistanciaAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/distanciaadmin";
    }
    
    @PostMapping("/admin/productos/melee/guardarProducto")
    public String guardarMelee(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos/melee";
    }

   
    @PostMapping("/admin/productos/melee/eliminarProducto/{id}")
    public String eliminarMelee(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos/melee";
    }
    
    
    @GetMapping("/admin/productos/melee/editar/{id}")
	public String mostrarFormularioMelee(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/editmelee";
		
	}
    
    @PostMapping("/admin/productos/melee/editar/submit")
    public String procesarMelee(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos/melee";
    }

    @PostMapping("/admin/productos/distancia/guardarProducto")
    public String guardarDistancia(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos/distancia";
    }

   
    @PostMapping("/admin/productos/distancia/eliminarProducto/{id}")
    public String eliminarDistancia(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos/distancia";
    }
    
    
    @GetMapping("/admin/productos/distancia/editar/{id}")
	public String mostrarFormularioDistancia(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/editdistancia";
		
	}
    
    @PostMapping("/admin/productos/distancia/editar/submit")
    public String procesarDistancia(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos/distancia";
    }
    
    @GetMapping("/admin/productos/cuero")
    public String listarCueroAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/cueroadmin";
    }

    @RequestMapping("/admin/productos/cuero/{id}")
    public String cargarProductoCuero(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
            Producto producto = optionalProducto.get();
            System.out.println(producto);
            model.addAttribute("producto", producto);
            return "/admin/productoadmin";
    }

    @PostMapping("/admin/productos/cuero/guardarProducto")
    public String guardarCuero(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos/cuero";
    }

    @PostMapping("/admin/productos/cuero/eliminarProducto/{id}")
    public String eliminarCuero(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos/cuero";
    }

    @GetMapping("/admin/productos/cuero/editar/{id}")
	public String mostrarFormularioCuero(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/editcuero";
		
	}
    
    @PostMapping("/admin/productos/cuero/editar/submit")
    public String procesarCuero(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos/cuero";
    }
    
    @GetMapping("/admin/productos/metal")
    public String listarMetalAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/metaladmin";
    }

    @RequestMapping("/admin/productos/metal/{id}")
    public String cargarProductoMetal(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
            Producto producto = optionalProducto.get();
            System.out.println(producto);
            model.addAttribute("producto", producto);
            return "/admin/productoadmin";
    }

    @PostMapping("/admin/productos/metal/guardarProducto")
    public String guardarMetal(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos/metal";
    }

    @PostMapping("/admin/productos/metal/eliminarProducto/{id}")
    public String eliminarMetal(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos/metal";
    }

    @GetMapping("/admin/productos/metal/editar/{id}")
	public String mostrarFormularioMetal(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/editmetal";
		
	}
    
    @PostMapping("/admin/productos/metal/editar/submit")
    public String procesarMetal(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos/metal";
    }
    
    @GetMapping("/admin/productos/otros")
    public String listarOtrosAdmin(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "/admin/otrosadmin";
    }

    @RequestMapping("/admin/productos/otros/{id}")
    public String cargarProductoOtros(@PathVariable("id") Long id, Model model) {
        Optional<Producto> optionalProducto = productoService.findById(id);
            Producto producto = optionalProducto.get();
            System.out.println(producto);
            model.addAttribute("producto", producto);
            return "/admin/productoadmin";
    }

    @PostMapping("/admin/productos/otros/guardarProducto")
    public String guardarOtros(@ModelAttribute Producto producto) {
    	productoService.save(producto);
        return "redirect:/admin/productos/otros";
    }

    @PostMapping("/admin/productos/otros/eliminarProducto/{id}")
    public String eliminarOtros(@PathVariable("id") Long id) {
        productoService.deleteById(id);
        return "redirect:/admin/productos/otros";
    }

    @GetMapping("/admin/productos/otros/editar/{id}")
	public String mostrarFormularioOtros(@PathVariable("id") long id, Model model) {
		Optional<Producto> prod = productoService.findById(id);
		
		Producto editar = prod.get();
		model.addAttribute("productoEdit", editar);
		
		return "/admin/editotros";
		
	}
    
    @PostMapping("/admin/productos/otros/editar/submit")
    public String procesarOtros(@ModelAttribute("productoEdit") Producto p) {
    	productoService.edit(p);
    	return "redirect:/admin/productos/otros";
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
        Admin updatedAdmin = adminService.edit(admin);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth = new UsernamePasswordAuthenticationToken(updatedAdmin, auth.getCredentials(), auth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/admin/profile";
    }
}
