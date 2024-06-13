package com.generation.pokemarket.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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

    //ManyToMany crea una tabla relacional o tabla intermedia
    @ManyToMany()
    //JoinTable para indicar los datos de la tabla
    @JoinTable(name = "productos_pedido",
    //La columna que lleva la llave foránea de la tabla actual (productos)
    joinColumns = @JoinColumn(name = "producto_id"),
    //La columna inversa que lleva la llave foránea de la otra tabla (pedidos)
    inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Pedido> productoPedidos;

}
