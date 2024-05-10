package com.salesianostriana.dam.proyectofinaldanielmartinez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinaldanielmartinez.model.Cliente;
import com.salesianostriana.dam.proyectofinaldanielmartinez.service.UsuarioService;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

    @PostMapping("/registro/submit")
    public String registroSubmit(@ModelAttribute("cliente") Cliente clienteForm) {
    	usuarioService.save(clienteForm);
        
        return "redirect:/";
    }
}
