package com.backend.pacientes.dto;


public class VitalSignsDTO {
    private Long idHospitalizacion;
    private Long pacienteId;
    private Long camaId;
    private String sala;
    private int frecuenciaCardiaca;
    private String presionArterial;
    private double temperaturaCorporal;

    public VitalSignsDTO(Long idHospitalizacion, Long pacienteId, Long camaId, String sala,
                         int frecuenciaCardiaca, String presionArterial, double temperaturaCorporal) {
        this.idHospitalizacion = idHospitalizacion;
        this.pacienteId = pacienteId;
        this.camaId = camaId;
        this.sala = sala;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionArterial = presionArterial;
        this.temperaturaCorporal = temperaturaCorporal;
    }

    // Getters y Setters
    public Long getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(Long idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getCamaId() {
        return camaId;
    }

    public void setCamaId(Long camaId) {
        this.camaId = camaId;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }
}
