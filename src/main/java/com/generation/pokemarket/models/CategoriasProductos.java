package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categorias_productos")
@Data
@NoArgsConstructor
public class CategoriasProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto product;




}
