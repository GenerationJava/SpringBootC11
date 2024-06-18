package com.generation.pokemarket.repository;

import com.generation.pokemarket.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository indica a Spring que esta interfaz es un repositorio
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //JpaRepository hereda de PagingAndSorting y de CrudRepository, interfaces que tienen métodos para hacer el crud

    Usuario findByNombre(String nombre);

    Usuario findByCorreo(String correo);

}
