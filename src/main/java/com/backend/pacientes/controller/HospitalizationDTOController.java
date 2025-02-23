package com.backend.pacientes.controller;

import com.backend.pacientes.dto.HospitalizationDTO;
import com.backend.pacientes.service.HospitalizationDTOService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalizations")
public class HospitalizationDTOController {

    private final HospitalizationDTOService hospitalizationDTOService;

    public HospitalizationDTOController(HospitalizationDTOService hospitalizationDTOService) {
        this.hospitalizationDTOService = hospitalizationDTOService;
    }

    /**
     * Obtiene la lista de hospitalizaciones en formato DTO.
     * @return Lista de HospitalizationDTO.
     */
    @GetMapping("/dto")
    public List<HospitalizationDTO> obtenerHospitalizacionesDTO() {
        return hospitalizationDTOService.obtenerHospitalizacionesDTO();
    }
}
