package com.backend.pacientes.repository;

import com.backend.pacientes.model.HospitalizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepository extends JpaRepository<HospitalizationModel, Long> {
    // Método para obtener todas las hospitalizaciones de un paciente específico
    List<HospitalizationModel> findByPacienteId(Long pacienteId);
    
    // 🔹 Agregar este método correctamente:
    List<HospitalizationModel> findByPacienteIdAndFechaAltaIsNull(Long pacienteId);
}
