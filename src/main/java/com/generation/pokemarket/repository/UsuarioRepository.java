package com.generation.pokemarket.repository;

import com.generation.pokemarket.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository indica a Spring que esta interfaz es un repositorio
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //JpaRepository hereda de PagingAndSorting y de CrudRepository, interfaces que tienen métodos para hacer el crud

    //Jpa nos proporciona métodos para trabajar con los atributos de las entidades
    Usuario findByNombre(String nombre);

    Usuario findByCorreo(String correo);

    //Query me permite indicar una consulta con JPQL (usando las entidades y atributos como referencia)
    //Param me permite indicar un parámetro a recibirse como un campo dinámico para la query (:nombreDelParametro)
    @Query("SELECT u FROM Usuario u WHERE u.apellido = :apellidoUsuario AND u.nombre = :nombreUsuario")
    Usuario encontrarPorApellidoNombre(@Param("apellidoUsuario") String apellidoUsuario,
                                             @Param("nombreUsuario") String nombreUsuario);


    @Query(value = "SELECT * FROM usuarios u WHERE u.nombre LIKE %:patron%", nativeQuery = true)
    List<Usuario> encontrarPorPatronNombre(@Param("patron") String patron);



}
