package com.tabibu.desktop.model;

import java.sql.Date;

public class Diagnosis {
    private int id;
    private int healthcare_provider_id;
    private int patient_age;
    private Date diagnosis_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealthcare_provider_id() {
        return healthcare_provider_id;
    }

    public void setHealthcare_provider_id(int healthcare_provider_id) {
        this.healthcare_provider_id = healthcare_provider_id;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public Date getDiagnosis_date() {
        return diagnosis_date;
    }

    public void setDiagnosis_date(Date diagnosis_date) {
        this.diagnosis_date = diagnosis_date;
    }
}
