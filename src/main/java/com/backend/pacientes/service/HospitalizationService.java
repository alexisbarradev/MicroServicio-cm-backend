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

    // ✅ Obtener todas las hospitalizaciones
    public List<HospitalizationModel> getAllHospitalizations() {
        return hospitalizationRepository.findAll();
    }

    // ✅ Obtener una hospitalización por su ID
    public Optional<HospitalizationModel> getHospitalizationById(Long id) {
        return hospitalizationRepository.findById(id);
    }

    // ✅ Guardar una nueva hospitalización
    public HospitalizationModel saveHospitalization(HospitalizationModel hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

  

    // ✅ Eliminar una hospitalización por ID
    public void deleteHospitalization(Long id) {
        hospitalizationRepository.deleteById(id);
    }
}
