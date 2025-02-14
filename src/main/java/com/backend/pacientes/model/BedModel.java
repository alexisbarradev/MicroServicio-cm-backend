package com.backend.pacientes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CAMAS")
public class BedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAMA_ID")
    private Long id;

    @Column(name = "SALA", nullable = false, length = 50)
    private String sala;

    @Column(name = "NUMERO_CAMA", nullable = false)
    private int numeroCama;

    @Column(name = "OCUPADA", nullable = false)
    private boolean ocupada = false;

    @OneToOne
    @JoinColumn(name = "PACIENTE_ID", referencedColumnName = "PACIENTE_ID", unique = true, nullable = true)
    private PatientModel paciente;

    public BedModel() {
    }

    public BedModel(String sala, int numeroCama) {
        this.sala = sala;
        this.numeroCama = numeroCama;
        this.ocupada = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getNumeroCama() {
        return numeroCama;
    }

    public void setNumeroCama(int numeroCama) {
        this.numeroCama = numeroCama;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public PatientModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PatientModel paciente) {
        this.paciente = paciente;
    }
}
