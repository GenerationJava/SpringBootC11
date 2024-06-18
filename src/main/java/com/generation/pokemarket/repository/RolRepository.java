package com.generation.pokemarket.repository;

import com.generation.pokemarket.models.ERol;
import com.generation.pokemarket.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findRolByNombreRol(ERol nombreRol);
}
