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

    // Obtener todas las hospitalizaciones
    @GetMapping
    public List<HospitalizationModel> getAllHospitalizations() {
        return hospitalizationService.getAllHospitalizations();
    }

    // Obtener hospitalización por ID
    @GetMapping("/{id}")
    public ResponseEntity<HospitalizationModel> getHospitalizationById(@PathVariable Long id) {
        return hospitalizationService.getHospitalizationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva hospitalización
    @PostMapping
    public HospitalizationModel createHospitalization(@RequestBody HospitalizationModel hospitalization) {
        return hospitalizationService.saveHospitalization(hospitalization);
    }

    // Obtener hospitalizaciones de un paciente específico
    @GetMapping("/paciente/{pacienteId}")
    public List<HospitalizationModel> getHospitalizationsByPatientId(@PathVariable Long pacienteId) {
        return hospitalizationService.getHospitalizationsByPatientId(pacienteId);
    }

    // Obtener hospitalizaciones activas de un paciente (sin fecha de alta)
    @GetMapping("/paciente/{pacienteId}/activas")
    public List<HospitalizationModel> getActiveHospitalizations(@PathVariable Long pacienteId) {
        return hospitalizationService.getActiveHospitalizationsByPatientId(pacienteId);
    }

    // Actualizar una hospitalización (ejemplo: agregar fecha de alta)
    @PutMapping("/{id}")
    public ResponseEntity<HospitalizationModel> updateHospitalization(@PathVariable Long id, @RequestBody HospitalizationModel hospitalizationDetails) {
        return hospitalizationService.getHospitalizationById(id)
                .map(existingHospitalization -> {
                    existingHospitalization.setFechaIngreso(hospitalizationDetails.getFechaIngreso());
                    existingHospitalization.setFechaAlta(hospitalizationDetails.getFechaAlta());
                    existingHospitalization.setMotivoIngreso(hospitalizationDetails.getMotivoIngreso());
                    existingHospitalization.setDiagnostico(hospitalizationDetails.getDiagnostico());
                    existingHospitalization.setSala(hospitalizationDetails.getSala());
                    existingHospitalization.setCama(hospitalizationDetails.getCama());

                    return ResponseEntity.ok(hospitalizationService.saveHospitalization(existingHospitalization));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Dar de alta a un paciente (solo actualiza fecha de alta)
    @PatchMapping("/{id}/alta")
    public ResponseEntity<HospitalizationModel> dischargePatient(@PathVariable Long id, @RequestBody HospitalizationModel hospitalizationUpdate) {
        HospitalizationModel updatedHospitalization = hospitalizationService.dischargePatient(id, hospitalizationUpdate);
        return updatedHospitalization != null ? ResponseEntity.ok(updatedHospitalization) : ResponseEntity.notFound().build();
    }

    // Eliminar una hospitalización
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHospitalization(@PathVariable Long id) {
        if (hospitalizationService.getHospitalizationById(id).isPresent()) {
            hospitalizationService.deleteHospitalization(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
