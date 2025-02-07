package com.backend.pacientes.service;

import  com.backend.pacientes.repository.PatientRepository;
import  com.backend.pacientes.model.PatientModel;
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

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
