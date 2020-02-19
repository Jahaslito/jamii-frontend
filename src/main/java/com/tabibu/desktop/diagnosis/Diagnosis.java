package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;

import java.util.List;

public class Diagnosis {
    private int id;
    private HealthCareProvider healthCareProvider;
    private int patientAge;
    private String diagnosisDate;
    private List<Disease> diseases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HealthCareProvider getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(HealthCareProvider healthCareProvider) {
        this.healthCareProvider = healthCareProvider;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
}
