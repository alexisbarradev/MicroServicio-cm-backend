package com.backend.pacientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()) // Habilita CORS con configuración por defecto
            .csrf(csrf -> csrf.disable()) // Deshabilita CSRF para APIs REST
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/pacientes").permitAll() // Permite acceso público a /api/pacientes
                .anyRequest().authenticated() // Requiere autenticación para otras rutas
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())); // Habilita OAuth2 con JWT

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("https://login.microsoftonline.com/145f8758-681d-4413-9137-2973073f86e2/discovery/v2.0/keys").build();
    }
}