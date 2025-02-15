package com.backend.pacientes.service;

import com.backend.pacientes.model.PatientModel;
import com.backend.pacientes.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<PatientModel> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public PatientModel savePatient(PatientModel patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        PatientModel patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente con ID " + id + " no encontrado"));

        

        patientRepository.delete(patient);
    }
}
