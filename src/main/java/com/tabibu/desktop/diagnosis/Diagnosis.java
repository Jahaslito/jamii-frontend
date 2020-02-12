package com.tabibu.desktop.model;

import java.sql.Date;

public class Diagnosis {
    private int id;
    private int healthCareProviderId;
    private int patientAge;
    private Date diagnosisDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealthCareProviderId() {
        return healthCareProviderId;
    }

    public void setHealthCareProviderId(int healthCareProviderId) {
        this.healthCareProviderId = healthCareProviderId;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }
}
