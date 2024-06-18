package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Mapea un tipo enumerado(enum) a una columna de la base de datos para la tabla rol
    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private ERol nombreRol;

}
