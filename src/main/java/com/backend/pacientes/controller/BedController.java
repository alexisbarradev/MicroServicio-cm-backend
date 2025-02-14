package com.backend.pacientes.controller;

import com.backend.pacientes.model.BedModel;
import com.backend.pacientes.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/camas")
@CrossOrigin(origins = "http://localhost:4200") // Permitir acceso desde Angular
public class BedController {

    @Autowired
    private BedService bedService;

    // ✅ Modificación: Formatear la respuesta con números
    @GetMapping("/disponibles")
    public List<String> getAvailableBeds() {
        List<BedModel> beds = bedService.getAvailableBeds();
        List<String> formattedBeds = new ArrayList<>();

        for (BedModel bed : beds) {
            formattedBeds.add("Cama " + bed.getNumeroCama() + " - Sala: " + bed.getSala());
        }
        return formattedBeds;
    }

    // Endpoint para asignar una cama a un paciente
    @PostMapping("/asignar/{camaId}/{pacienteId}")
    public ResponseEntity<String> assignBed(@PathVariable Long camaId, @PathVariable Long pacienteId) {
        String response = bedService.assignBed(camaId, pacienteId);
        return ResponseEntity.ok(response);
    }
}
