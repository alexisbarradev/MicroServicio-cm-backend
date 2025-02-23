package com.backend.pacientes.service;

import com.backend.pacientes.dto.HospitalizationDTO;
import com.backend.pacientes.repository.HospitalizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationDTOService {

private final HospitalizationRepository hospitalizationRepository;

public HospitalizationDTOService(HospitalizationRepository hospitalizationRepository) {
    this.hospitalizationRepository = hospitalizationRepository;
}

/**
* Obtiene la lista de hospitalizaciones en formato DTO.
* Lista de HospitalizationDTO.
*/
public List<HospitalizationDTO> obtenerHospitalizacionesDTO() {
    return hospitalizationRepository.findAllHospitalizationsAsDTO();
    }
}