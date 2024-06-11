package com.generation.pokemarket.controller;

import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController se usa para indicar que sigue el patrón REST, estado representacional en formato JSON
@RestController
//Indicar ruta base para las peticiones a la api
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Método a ejecutarse al momento de ingresar a la ruta
    @GetMapping("/")
    public String getUsuarioById() {
        Usuario usuarioSolicitado = usuarioService.obtenerUsuarioPorId(1L);
        return "Hola soy " + usuarioSolicitado.getNombre() ;
    }



}
