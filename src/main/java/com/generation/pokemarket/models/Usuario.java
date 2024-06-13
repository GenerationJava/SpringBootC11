package com.generation.pokemarket.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaCreacion;

    //Represento la relación desde la otra entidad
    @OneToOne(mappedBy = "usuarioId")
    private Perfil perfilUsuario;

    //Constructores
    public Usuario(long id, String nombre, String apellido, String correo, String password, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario() {
    }

    //Getter y Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
