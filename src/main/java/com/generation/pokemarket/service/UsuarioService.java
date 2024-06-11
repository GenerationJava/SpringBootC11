package com.generation.pokemarket.service;

import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service al igual que Repository, son implementaciones de la anotación Component
@Service
public class UsuarioService {

    //Inyección de dependencia del repository
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.getReferenceById(id);
    }

}
