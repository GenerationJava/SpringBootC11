package com.generation.pokemarket.security;

import com.generation.pokemarket.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Configuration idica a Spring que esta clase contiene métodos y configuraciones para todo el proyecto
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;

    //Los Bean son instancias u objetos que son administrados por el núcleo de spring
    //Método para encriptar las contraseñas
    @Bean
    public static PasswordEncoder passwordEncoder() {
        //Retornamos una instancia del PasswordEncoder para ser manejada dentro del núcleo del proyecto
        return new BCryptPasswordEncoder();
    }

    //Método que retorna la cadena de filtros de seguridad
    //Acá definimos rutas a las que damos permiso y rutas a las que prohibimos
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Al objeto HttpSecurity le indico qué protocolos y qué peticiones se van a permitir
        //Primero, indicamos qué protocolos de seguridad vamos a dejar activos o desactivar (CSRF) que funciona con formularios web
        http.csrf(csrf -> csrf.disable())
                //Luego, definimos qué peticiones van a tener alguna regla
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/usuario/**").permitAll()
                        .requestMatchers("/api/productos/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //Método que retorna el objeto encargado de otorgar autenticación al usuario que se logea
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

}





