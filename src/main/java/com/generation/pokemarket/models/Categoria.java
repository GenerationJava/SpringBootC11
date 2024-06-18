package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias")
//Anotación para generar constructor vacío
@NoArgsConstructor
//Anotación para constructor lleno
@AllArgsConstructor
//Anotaciones para generar Getter y Setter
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;



}
