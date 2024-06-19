package com.generation.pokemarket.controller;

import com.generation.pokemarket.dto.UsuarioDTO;
import com.generation.pokemarket.models.Producto;
import com.generation.pokemarket.models.Usuario;
import com.generation.pokemarket.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController se usa para indicar que sigue el patrón REST, estado representacional en formato JSON
@RestController
//Indicar ruta base para las peticiones a la api
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public List<Usuario> getListaUsuarios() {
        return usuarioService.obtenerListaDeUsuarios();
    }

    //Método a ejecutarse al momento de ingresar a la ruta
    @GetMapping("/")
    public String getUsuarioById() {
        Usuario usuarioSolicitado = usuarioService.obtenerUsuarioPorId(1L);
        return "Hola soy " + usuarioSolicitado.getNombre() ;
    }

    @GetMapping("/{nombre}")
    public String getUsuarioByNombre(@PathVariable String nombre) {
        Usuario usuarioSolicitado = usuarioService.obtenerUsuarioPorNombre(nombre);
        return "Hola soy "
                + usuarioSolicitado.getNombre()
                + " "
                + usuarioSolicitado.getApellido();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardarUsuario(@RequestBody @Valid UsuarioDTO nuevoUsuario, BindingResult result){
        //System.out.println(nuevoUsuario.getNombreUsuario());
        //System.out.println(nuevoUsuario.getCorreoUsuario());
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
        }
        //Usuario usuarioGuardado = usuarioService.guardarNuevoUsuario(nuevousuario);

        return new ResponseEntity<>(usuarioService.guardarNuevoUsuario(nuevoUsuario), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{correo}")
    public ResponseEntity<?> editarUsuarioPorCorreo(@PathVariable String correo,
                                                    @RequestBody @Valid UsuarioDTO usuarioParaEditar,
                                                    BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifica los campos antes de editar", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(usuarioService.editarUsuarioPorCorreo(usuarioParaEditar, correo),
                HttpStatus.OK);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarPorId(@RequestParam Long id) {
        //LLamamos al service y al método de borrar por Id
        usuarioService.borrarUsuarioPorId(id);
        //Retornamos un string en el cuerpo de la respuesta
        return new ResponseEntity<>("Usuario borrado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorApellidoNombre(@RequestParam String apellido,
                                                     @RequestParam String nombre) {
        return new ResponseEntity<>(usuarioService.
                buscarUsuarioPorApellidoNombre(apellido, nombre),
                HttpStatus.OK);
    }

    @GetMapping("/patron")
    public ResponseEntity<?> buscarPorPatron(@RequestParam String patron) {
        return new ResponseEntity<>(usuarioService.buscarUsuariosPorPatron(patron),
                HttpStatus.OK);
    }




}
