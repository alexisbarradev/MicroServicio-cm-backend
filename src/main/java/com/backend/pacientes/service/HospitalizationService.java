package com.backend.pacientes.service;

import com.backend.pacientes.model.HospitalizationModel;
import com.backend.pacientes.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    // Obtener todas las hospitalizaciones
    public List<HospitalizationModel> getAllHospitalizations() {
        return hospitalizationRepository.findAll();
    }

    // Obtener una hospitalización por su ID
    public Optional<HospitalizationModel> getHospitalizationById(Long id) {
        return hospitalizationRepository.findById(id);
    }

    // Guardar una nueva hospitalización o actualizar una existente
    public HospitalizationModel saveHospitalization(HospitalizationModel hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    // Obtener todas las hospitalizaciones de un paciente específico
    public List<HospitalizationModel> getHospitalizationsByPatientId(Long patientId) {
        return hospitalizationRepository.findByPacienteId(patientId);
    }

    // Obtener solo las hospitalizaciones activas (pacientes aún hospitalizados)
    public List<HospitalizationModel> getActiveHospitalizationsByPatientId(Long patientId) {
        return hospitalizationRepository.findByPacienteIdAndFechaAltaIsNull(patientId);
    }

    // Dar de alta a un paciente (actualizar la fecha de alta)
    public HospitalizationModel dischargePatient(Long id, HospitalizationModel hospitalizationUpdate) {
        Optional<HospitalizationModel> optionalHospitalization = hospitalizationRepository.findById(id);
        if (optionalHospitalization.isPresent()) {
            HospitalizationModel hospitalization = optionalHospitalization.get();
            hospitalization.setFechaAlta(hospitalizationUpdate.getFechaAlta());
            return hospitalizationRepository.save(hospitalization);
        }
        return null; // O puedes lanzar una excepción personalizada
    }

    // Eliminar una hospitalización por ID
    public void deleteHospitalization(Long id) {
        hospitalizationRepository.deleteById(id);
    }
}
