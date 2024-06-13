package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
//Anotación para generar constructor vacío
@NoArgsConstructor
//Anotación para constructor lleno
@AllArgsConstructor
//Anotaciones para generar Getter y Setter
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "metodo_id")
    private MetodoPago metodoPagoPedido;

    private Double montoPedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioPedido;

}
