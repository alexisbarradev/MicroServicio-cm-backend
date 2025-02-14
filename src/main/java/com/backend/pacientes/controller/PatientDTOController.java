package com.backend.pacientes.controller;

import com.backend.pacientes.dto.PatientDTO;
import com.backend.pacientes.service.PatientDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Asegura que el frontend pueda acceder
@RestController
@RequestMapping("/api/pacientes")
public class PatientDTOController {
    @Autowired
    private PatientDTOService patientDTOService;

    @GetMapping("/listado")
    public ResponseEntity<List<PatientDTO>> getAllPatientsAsDTO() {
        return ResponseEntity.ok(patientDTOService.getAllPatientsAsDTO());
    }

    @GetMapping("/listado/available") // ✅ Asegura que esta ruta existe
    public ResponseEntity<List<PatientDTO>> getAvailablePatients() {
        List<PatientDTO> availablePatients = patientDTOService.getAvailablePatients();
        return ResponseEntity.ok(availablePatients);
    }
}

