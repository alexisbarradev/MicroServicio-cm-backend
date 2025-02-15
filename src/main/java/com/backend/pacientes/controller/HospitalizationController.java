package com.backend.pacientes.controller;

import com.backend.pacientes.model.HospitalizationModel;
import com.backend.pacientes.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/hospitalizaciones")
public class HospitalizationController {

    @Autowired
    private HospitalizationService hospitalizationService;

    // ✅ Obtener todas las hospitalizaciones
    @GetMapping
    public List<HospitalizationModel> getAllHospitalizations() {
        return hospitalizationService.getAllHospitalizations();
    }

    // ✅ Obtener hospitalización por ID
    @GetMapping("/{id}")
    public ResponseEntity<HospitalizationModel> getHospitalizationById(@PathVariable Long id) {
        return hospitalizationService.getHospitalizationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Crear una nueva hospitalización
    @PostMapping
    public ResponseEntity<HospitalizationModel> createHospitalization(@RequestBody HospitalizationModel hospitalization) {
        if (hospitalization.getPaciente() == null || hospitalization.getCama() == null || hospitalization.getFechaIngreso() == null) {
            return ResponseEntity.badRequest().build(); // Evitar datos incompletos
        }
        HospitalizationModel savedHospitalization = hospitalizationService.saveHospitalization(hospitalization);
        return ResponseEntity.ok(savedHospitalization);
    }

    

    // ✅ Eliminar una hospitalización
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospitalization(@PathVariable Long id) {
        if (hospitalizationService.getHospitalizationById(id).isPresent()) {
            hospitalizationService.deleteHospitalization(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
