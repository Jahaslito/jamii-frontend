package com.tabibu.desktop.death;

public class Death {
    private int id;
    private int corpseAge;
    private String deathDate;
    private int diseaseId;
    private int healthCareProviderId;

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

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public int getHealthCareProviderId() {
        return healthCareProviderId;
    }

    public void setHealthCareProviderId(int healthCareProviderId) {
        this.healthCareProviderId = healthCareProviderId;
    }
}
