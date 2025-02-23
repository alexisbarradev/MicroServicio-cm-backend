package com.backend.pacientes.controller;

import com.backend.pacientes.service.VitalSignsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vital-signs")
public class VitalSignsController {

    private final VitalSignsService vitalSignsService;

    public VitalSignsController(VitalSignsService vitalSignsService) {
        this.vitalSignsService = vitalSignsService;
    }

    /**
     * Publica las señales vitales en Kafka.
     * @return Mensaje de confirmación.
     */
    @PostMapping("/publicar")
    public String publicarSeñalesVitales() {
        vitalSignsService.generarYPublicarSenalesVitales();
        return "Señales vitales enviadas a Kafka exitosamente";
    }
}
