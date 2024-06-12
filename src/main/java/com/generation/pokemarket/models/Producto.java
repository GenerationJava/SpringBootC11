package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
//Anotación para generar constructor vacío
@NoArgsConstructor
//Anotación para constructor lleno
@AllArgsConstructor
//Anotaciones para generar Getter y Setter
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombreProducto;

    @Column(name = "stock")
    private Integer stockProducto;

    @Column(name = "precio")
    private Double precioProducto;

    //Anotación para indicar que este campo va a registrar la fecha de creación de el objeto
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

}
