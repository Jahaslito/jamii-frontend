package com.tabibu.desktop.death;

import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;

public class Death {
    private int id;
    private int corpseAge;
    private String deathDate;
    private Disease disease;
    private HealthCareProvider healthCareProvider;

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

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
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
}
