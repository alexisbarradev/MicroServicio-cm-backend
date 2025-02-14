package com.backend.pacientes.service;

import com.backend.pacientes.dto.PatientDTO;
import com.backend.pacientes.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDTOService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDTO> getAllPatientsAsDTO() {
        return patientRepository.findAllPatientsAsDTO();
    }

    public List<PatientDTO> getAvailablePatients() {
        return patientRepository.findAvailablePatients(); // Necesitas definir esto en el Repository
    }
    
}
