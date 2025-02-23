package com.backend.pacientes;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PacientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(PacientesApplication.class, args);
    }
}
