package com.generation.pokemarket.models;

import jakarta.persistence.*;

import java.util.List;

//Entity indica que va a ser una entidad a representarse en la BBDD
@Entity
//Table me permite cambiar el nombre a la tabla
@Table(name = "metodos_pago")
public class MetodoPago {

    //Id indica que esta columna es la llave primaria
    @Id
    //GeneratedValue indica que estrategia de generación del valor va a adoptar
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Column permite cambiar el nombre de la columna y añadirle restricciones
    @Column(name = "metodo")
    private String nombreMetodo;

    //ManyToOne indica que muchos métodos de pago pueden pertenecer a un usuario, creo la variable Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //OneToMany para indicar que un metodo de pago está asociado a varios pedidos
    @OneToMany(mappedBy = "metodoPagoPedido")
    private List<MetodoPago> pedidosMetodo;


    //Constructores
    public MetodoPago() {
    }

    public MetodoPago(long id, String nombreMetodo) {
        this.id = id;
        this.nombreMetodo = nombreMetodo;
    }

    //Getter & Setter
    public long getId() {
        return id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }


}
