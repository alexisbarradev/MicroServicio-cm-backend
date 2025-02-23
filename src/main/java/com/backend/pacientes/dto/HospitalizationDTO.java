package com.backend.pacientes.dto;

public class HospitalizationDTO {
    private Long idHospitalizacion;
    private Long pacienteId;
    private Long camaId;
    private String sala;
    
    // 📌 Agregamos señales vitales
    private int heartRate;       // Frecuencia cardíaca
    private int bloodPressure;   // Presión arterial
    private double temperature;  // Temperatura corporal

    // Constructor actualizado con señales vitales
    public HospitalizationDTO(Long idHospitalizacion, Long pacienteId, Long camaId, String sala,
                              int heartRate, int bloodPressure, double temperature) {
        this.idHospitalizacion = idHospitalizacion;
        this.pacienteId = pacienteId;
        this.camaId = camaId;
        this.sala = sala;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
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

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
