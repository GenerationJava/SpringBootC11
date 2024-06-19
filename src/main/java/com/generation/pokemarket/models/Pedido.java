package com.generation.pokemarket.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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

    @JsonFormat(pattern = "dd.MM.YYYY")
    @CreationTimestamp()
    private LocalDateTime fechaPedido;
}
