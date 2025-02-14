package com.backend.pacientes.config;

import com.backend.pacientes.model.BedModel;
import com.backend.pacientes.repository.BedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeBeds(BedRepository bedRepository) {
        return args -> {
            long existingBeds = bedRepository.count();
            int totalCamasNecesarias = 10;

            if (existingBeds < totalCamasNecesarias) {
                for (int i = (int) existingBeds + 1; i <= totalCamasNecesarias; i++) {
                    BedModel bed = new BedModel("Sala 1", i);
                    bedRepository.save(bed);
                }
                System.out.println("📌 Se agregaron " + (totalCamasNecesarias - existingBeds) + " camas nuevas.");
            } else {
                System.out.println("📌 La base de datos ya tiene " + existingBeds + " camas. No se agregaron nuevas camas.");
            }
        };
    }
}
