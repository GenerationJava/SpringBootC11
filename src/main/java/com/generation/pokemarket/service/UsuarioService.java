package com.generation.pokemarket.service;

import com.generation.pokemarket.dto.UsuarioDTO;
import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.repository.RolRepository;
import com.generation.pokemarket.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service al igual que Repository, son implementaciones de la anotación Component
@Service
public class UsuarioService {

    //Inyección de dependencia del repository
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.getReferenceById(id);
    }

    public Usuario obtenerUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public List<Usuario> obtenerListaDeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public UsuarioDTO guardarNuevoUsuario(UsuarioDTO nuevoUsuario) {
        //Mediante el método builder() que funciona como el constructor, construyo la entidad Usuario para guardarlo en la BBDD
        //Obtenemos cada valor para cada campo a través de los campos con los que viene el DTO
        Usuario usuarioParaGuardar = Usuario.builder()
                .nombre(nuevoUsuario.getNombreUsuario())
                .apellido(nuevoUsuario.getApellidoUsuario())
                .correo(nuevoUsuario.getCorreoUsuario())
                .password(nuevoUsuario.getPassword())
                .build();
        //Seteo el rol, consultándolo al repository y tomando en cuenta el rol que viene indicado en el DTO
        usuarioParaGuardar.setRolUsuario(rolRepository.findRolByNombreRol(nuevoUsuario.getNombreRol()));
        //Guardo el nuevo Usuario a través del repository
        usuarioRepository.save(usuarioParaGuardar);

        return nuevoUsuario;
    }

    @Transactional
    public UsuarioDTO editarUsuarioPorCorreo(UsuarioDTO usuarioEditado, String correo) {
        //Buscamos al usuario a través del correo
        Usuario usuarioActualizar = usuarioRepository.findByCorreo(correo);
        //Seteamos los campos tomando en cuenta lo que viene en el DTO
        usuarioActualizar.setNombre(usuarioEditado.getNombreUsuario());
        usuarioActualizar.setApellido(usuarioEditado.getApellidoUsuario());
        usuarioActualizar.setCorreo(usuarioEditado.getCorreoUsuario());
        //Para setear el rol, llamamos al método en rol repository y buscamos el rol por nombre
        usuarioActualizar.setRolUsuario(rolRepository.findRolByNombreRol(usuarioEditado.getNombreRol()));
        //Finalmente, guardamos los cambios con el metodo save en usuarioRepository
        usuarioRepository.save(usuarioActualizar);
        return usuarioEditado;
    }
}
