package com.tabibu.desktop.death;

import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;

public class Death {
    private int id;
    private int corpseAge;
    private HealthCareProvider healthCareProvider;
    private Disease disease;
    private String deathDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorpseAge() {
        return corpseAge;
    }

    public void setCorpseAge(int corpseAge) {
        this.corpseAge = corpseAge;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public HealthCareProvider getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(HealthCareProvider healthCareProvider) {
        this.healthCareProvider = healthCareProvider;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }
}
