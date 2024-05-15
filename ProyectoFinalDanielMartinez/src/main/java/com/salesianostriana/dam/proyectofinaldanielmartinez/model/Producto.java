package com.salesianostriana.dam.proyectofinaldanielmartinez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    
    private String descripcion;
    
    private int stock;
    
    private double precio;
    
    private String imagen;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
