package com.backend.pacientes.repository;

import com.backend.pacientes.model.BedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BedRepository extends JpaRepository<BedModel, Long> {

    // Buscar camas disponibles
    List<BedModel> findByOcupadaFalse();
}
