package com.generation.pokemarket.security;

import com.generation.pokemarket.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Esta clase UserDetailsImpl, necesita implementar la interfaz UserDetails para generar un objeto para autenticación
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    //Atributos
    private String username;

    private String password;

    private String correo;

    //Atributo de lista de autoridades o roles, cada una extiende de la clase GrantedAuthority
    private Collection<? extends GrantedAuthority> authorities;

    //Builder para el objeto UserDetailsImpl, a partir del cual va a construir un usuario para autenticación
    public static UserDetailsImpl build(UsuarioDTO usuarioDTO) {
        //Primero creamos una lista de Authorities, vacía
        List<GrantedAuthority> authorities = new ArrayList<>();
        //Agregamos a las authorities, una nueva instancia de la clase SimpleGrantedAuthority y obtenemos el nombre del rol que viene el DTO
        authorities.add(new SimpleGrantedAuthority(usuarioDTO.getNombreRol().name()));

        return new UserDetailsImpl(
                usuarioDTO.getNombreUsuario(),
                usuarioDTO.getPassword(),
                usuarioDTO.getCorreoUsuario(),
                authorities);

    }

    //Getter del atributo authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getCorreo() {
        return correo;
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
