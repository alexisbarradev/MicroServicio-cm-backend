package com.backend.pacientes.controller;

import com.backend.pacientes.model.BedModel;
import com.backend.pacientes.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/camas")
@CrossOrigin(origins = "http://localhost:4200") // Permitir acceso desde Angular
public class BedController {

    @Autowired
    private BedService bedService;

    // ✅ Obtener todas las camas disponibles e incluir ocupadas
    @GetMapping("/disponibles")
    public ResponseEntity<List<BedModel>> getAllBeds() {
        List<BedModel> beds = bedService.getAllBeds()
                .stream()
                .sorted((b1, b2) -> Integer.compare(b1.getNumeroCama(), b2.getNumeroCama()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(beds);
    }

    // ✅ Asignar cama a un paciente con JSON en la respuesta
    @PutMapping("/asignar/{camaId}/{pacienteId}")
    public ResponseEntity<Map<String, String>> assignBed(@PathVariable Long camaId, @PathVariable Long pacienteId) {
        Map<String, String> response = new HashMap<>();
        try {
            String result = bedService.assignBed(camaId, pacienteId);

            response.put("message", result);

            if (result.contains("Error")) {
                return ResponseEntity.badRequest().body(response);
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error interno en la asignación de la cama.");
            response.put("error", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}

