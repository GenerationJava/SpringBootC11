package com.generation.pokemarket.dto;

import com.generation.pokemarket.models.ERol;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//DTO de usuario es un objeto o representación del objeto usuario, con la finalidad de transferir los datos importantes
public class UsuarioDTO {

    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @NotNull(message = "Este campo debe llenarse")//NotNull
    @Size(min = 2, max = 20)
    private String nombreUsuario;

    @NotBlank
    @Size(min = 2, max = 20, message = "El nombre debe tener una longitud entre 2 a 20 caracteres")
    private String apellidoUsuario;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
    flags = Pattern.Flag.CASE_INSENSITIVE)//Solución al . y a otros caracteres especiales att:Benja
    private String correoUsuario;

    @NotBlank
    private String password;

    private ERol nombreRol;
}
