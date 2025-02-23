package com.backend.pacientes.service;

import com.backend.pacientes.dto.HospitalizationDTO;
import com.backend.pacientes.dto.VitalSignsDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class VitalSignsService {

    private final HospitalizationDTOService hospitalizationDTOService;
    private final KafkaTemplate<String, VitalSignsDTO> kafkaTemplate;
    private final Random random = new Random();
    private static final String TOPIC = "senales_vitales";

    public VitalSignsService(HospitalizationDTOService hospitalizationDTOService, KafkaTemplate<String, VitalSignsDTO> kafkaTemplate) {
        this.hospitalizationDTOService = hospitalizationDTOService;
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Obtiene las hospitalizaciones, genera señales vitales y las publica en Kafka.
     */
    public void generarYPublicarSenalesVitales() {
        List<HospitalizationDTO> hospitalizaciones = hospitalizationDTOService.obtenerHospitalizacionesDTO();

        List<VitalSignsDTO> senalesVitales = hospitalizaciones.stream().map(hospitalizacion -> {
            VitalSignsDTO vitalSigns = new VitalSignsDTO(
                    hospitalizacion.getIdHospitalizacion(),
                    hospitalizacion.getPacienteId(),
                    hospitalizacion.getCamaId(),
                    hospitalizacion.getSala(),
                    generarFrecuenciaCardiaca(),
                    generarPresionArterial(),
                    generarTemperaturaCorporal()
            );
            // Enviar cada señal vital generada a Kafka
            kafkaTemplate.send(TOPIC, vitalSigns);
            return vitalSigns;
        }).collect(Collectors.toList());
    }

    // Métodos para generar valores simulados de señales vitales
    private int generarFrecuenciaCardiaca() {
        return random.nextInt(40) + 60; // Rango normal: 60-100 bpm
    }

    private String generarPresionArterial() {
        int sistolica = random.nextInt(50) + 90; // 90-140 mmHg
        int diastolica = random.nextInt(30) + 60; // 60-90 mmHg
        return sistolica + "/" + diastolica;
    }

    private double generarTemperaturaCorporal() {
        return Math.round((random.nextDouble() * 2 + 36) * 10.0) / 10.0; // Rango: 36.0 - 38.0 °C
    }
}
