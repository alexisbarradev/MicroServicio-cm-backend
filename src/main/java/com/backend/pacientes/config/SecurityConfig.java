package com.backend.pacientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // 🔹 Desactiva CSRF si es necesario
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/pacientes/**", "/api/camas/**").permitAll()  // 🔥 Permitir acceso a ambos endpoints
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
