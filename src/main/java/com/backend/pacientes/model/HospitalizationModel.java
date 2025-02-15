package com.backend.pacientes.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "HOSPITALIZACIONES")
public class HospitalizationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOSPITALIZACION_ID")
    private Long id;


    
    @Column(name = "PACIENTE_ID", nullable = true)
    private Long paciente;




    @Column(name = "FECHA_INGRESO", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "MOTIVO_INGRESO", nullable = false, length = 500)
    private String motivoIngreso;

    @Column(name = "SALA", length = 50)
    private String sala;

    @Column(name = "CAMA_ID", nullable = true)
    private Long cama;


    // Constructor vacío
    public HospitalizationModel() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Long getCama() {
        return cama;
    }
    
    public void setCama(Long cama) {
        this.cama = cama;
    }
    
}
