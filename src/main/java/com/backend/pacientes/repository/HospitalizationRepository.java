package com.backend.pacientes.repository;

import com.backend.pacientes.model.HospitalizationModel;
import com.backend.pacientes.dto.HospitalizationDTO;
import com.backend.pacientes.model.PatientModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepository extends JpaRepository<HospitalizationModel, Long> {

    // Método existente
    List<HospitalizationModel> findByPaciente(PatientModel paciente);

    // Método corregido para incluir señales vitales
    @Query("SELECT new com.backend.pacientes.dto.HospitalizationDTO(h.id, h.paciente, h.cama, h.sala, " +
       "0, 0, 0) " +
       "FROM HospitalizationModel h WHERE h.paciente IS NOT NULL")
List<HospitalizationDTO> findAllHospitalizationsAsDTO();

}


