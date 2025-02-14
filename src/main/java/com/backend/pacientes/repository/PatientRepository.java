package com.backend.pacientes.repository;

import com.backend.pacientes.model.PatientModel;
import com.backend.pacientes.dto.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {

    // Consulta personalizada para obtener los datos en formato DTO
    @Query("SELECT new com.backend.pacientes.dto.PatientDTO(p.id, p.rut, p.primerNombre, p.segundoNombre, p.apellidoPaterno, p.apellidoMaterno) FROM PatientModel p")
    List<PatientDTO> findAllPatientsAsDTO();

    @Query("SELECT p FROM PatientModel p WHERE p.assignedBed IS NULL") // Usa el nombre correcto de la entidad
    List<PatientDTO> findAvailablePatients();

}
