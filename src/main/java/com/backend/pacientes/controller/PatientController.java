package com.backend.pacientes.controller;

import  com.backend.pacientes.model.PatientModel;
import  com.backend.pacientes.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pacientes")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientModel> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PatientModel createPatient(@RequestBody PatientModel patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable Long id, @RequestBody PatientModel patientDetails) {
        return patientService.getPatientById(id)
                .map(existingPatient -> {
                    existingPatient.setApellidoPaterno(patientDetails.getApellidoPaterno());
                    existingPatient.setApellidoMaterno(patientDetails.getApellidoMaterno());
                    existingPatient.setPrimerNombre(patientDetails.getPrimerNombre());
                    existingPatient.setSegundoNombre(patientDetails.getSegundoNombre());
                    existingPatient.setRut(patientDetails.getRut());
                    existingPatient.setEdad(patientDetails.getEdad());
                    existingPatient.setTelefono(patientDetails.getTelefono());
                    existingPatient.setEmail(patientDetails.getEmail());
                    existingPatient.setFechaNacimiento(patientDetails.getFechaNacimiento());
                    existingPatient.setGenero(patientDetails.getGenero());
                    existingPatient.setDireccion(patientDetails.getDireccion());
                    existingPatient.setComuna(patientDetails.getComuna());
                    existingPatient.setRegion(patientDetails.getRegion());
                    existingPatient.setSala(patientDetails.getSala());
                    existingPatient.setCama(patientDetails.getCama());
                    existingPatient.setFechaRegistro(patientDetails.getFechaRegistro());

                    return ResponseEntity.ok(patientService.savePatient(existingPatient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientService.getPatientById(id).isPresent()) {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

