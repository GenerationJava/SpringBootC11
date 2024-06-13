package com.generation.pokemarket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fotoPerfil;

    //Relación 1:1 se crea mediante la anotación OneToOne
    @OneToOne
    //JoinColumn indica cuál es la llave foránea en la tabla actual
    @JoinColumn(name = "usuario_id")
    //Creo un campo o atributo usando la otra entidad como tipo de dato
    private Usuario usuarioId;

}
