package com.generation.pokemarket.service;

import com.generation.pokemarket.dto.UsuarioDTO;
import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.repository.UsuarioRepository;
import com.generation.pokemarket.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        //Construimos el DTO a partir del cual vamos a generar el usuario autenticado
        UsuarioDTO usuarioAutenticar = UsuarioDTO.builder()
                .correoUsuario(usuario.getCorreo())
                .nombreUsuario(usuario.getNombre())
                .password(usuario.getPassword())
                .nombreRol(usuario.getRolUsuario().getNombreRol())
                .build();

        return UserDetailsImpl.build(usuarioAutenticar);
    }
}
