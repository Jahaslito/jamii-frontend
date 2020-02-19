package com.tabibu.desktop.diagnosis;

public class DiagnosisViewModel {
    private String healthCareProvider;
    private int patientAge;
    private String diagnosisDate;
    private String diseases;

    public String getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(String healthCareProvider) {
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

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
}
