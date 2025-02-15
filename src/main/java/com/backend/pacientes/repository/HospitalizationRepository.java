package com.backend.pacientes.repository;

import com.backend.pacientes.model.HospitalizationModel;
import com.backend.pacientes.model.PatientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepository extends JpaRepository<HospitalizationModel, Long> {
    List<HospitalizationModel> findByPaciente(PatientModel paciente);


}

