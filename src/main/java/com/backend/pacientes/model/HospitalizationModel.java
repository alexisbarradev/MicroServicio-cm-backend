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

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private PatientModel paciente;

    @Column(name = "FECHA_INGRESO", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "FECHA_ALTA")
    private LocalDate fechaAlta;

    @Column(name = "MOTIVO_INGRESO", nullable = false, length = 500)
    private String motivoIngreso;

    @Column(name = "DIAGNOSTICO", length = 500)
    private String diagnostico;

    @Column(name = "SALA", length = 50)
    private String sala;

    @Column(name = "CAMA", length = 20)
    private String cama;

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

    public PatientModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PatientModel paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }
}
