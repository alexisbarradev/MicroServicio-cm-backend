package com.backend.pacientes.service;

import com.backend.pacientes.model.BedModel;
import com.backend.pacientes.model.PatientModel;
import com.backend.pacientes.repository.BedRepository;
import com.backend.pacientes.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private PatientRepository patientRepository;

    // ✅ Obtener todas las camas, tanto ocupadas como disponibles
    public List<BedModel> getAllBeds() {
        return bedRepository.findAll(); // Asegurarse de que `BedRepository` tiene `findAll()`
    }

    // ✅ Obtener solo las camas disponibles
    public List<BedModel> getAvailableBeds() {
        return bedRepository.findByOcupadaFalse();
    }

    // ✅ Asignar una cama a un paciente
    public String assignBed(Long camaId, Long pacienteId) {
        Optional<BedModel> optionalBed = bedRepository.findById(camaId);
        Optional<PatientModel> optionalPatient = patientRepository.findById(pacienteId);

        if (optionalBed.isEmpty()) {
            return "Error: La cama no fue encontrada.";
        }

        if (optionalPatient.isEmpty()) {
            return "Error: El paciente no fue encontrado.";
        }

        BedModel bed = optionalBed.get();
        PatientModel patient = optionalPatient.get();

        if (bed.isOcupada()) {
            return "Error: La cama ya está ocupada.";
        }

        // Asignar paciente a la cama
        bed.setPaciente(patient);
        bed.setOcupada(true);
        bedRepository.save(bed);

        return "✅ Cama asignada correctamente.";
    }
}
