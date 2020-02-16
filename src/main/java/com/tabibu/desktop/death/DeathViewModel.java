package com.tabibu.desktop.death;

public class DeathViewModel {
    private int corpseAge;
    private String diseaseName;
    private String providerName;
    private String deathDate;

    public DeathViewModel(int corpseAge, String diseaseName, String providerName, String deathDate) {
        this.corpseAge = corpseAge;
        this.diseaseName = diseaseName;
        this.providerName = providerName;
        this.deathDate = deathDate;
    }

    public int getCorpseAge() {
        return corpseAge;
    }

    public void setCorpseAge(int corpseAge) {
        this.corpseAge = corpseAge;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }
}
