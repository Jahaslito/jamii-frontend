package com.tabibu.desktop.model;

import java.util.ArrayList;

public class TabibuDatabase {
    ArrayList<Death> death;
    ArrayList<Diagnosis> diagnoses;
    ArrayList<disease_diagnosis>disease_diagnoses;
    ArrayList<HealthCareProvider> healthCareProviders;
    ArrayList<Disease> diseases;
 public TabibuDatabase(){
     //retrieve the data from the database and storeit in the above arrays
 }

    public ArrayList<Death> getDeath() {
        return death;
    }

    public void setDeath(Death dead) {
       death.add(dead);
    }

    public ArrayList<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Diagnosis diagnosis) {

       diagnoses.add(diagnosis);
    }

    public ArrayList<disease_diagnosis> getDisease_diagnoses() {
        return disease_diagnoses;
    }

    public void setDisease_diagnoses(disease_diagnosis dd) {
      disease_diagnoses.add(dd);
    }

    public ArrayList<HealthCareProvider> getHealthCareProviders() {
        return healthCareProviders;
    }

    public void setHealthCareProviders(HealthCareProvider hcp) {
       healthCareProviders.add(hcp);
    }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Disease disease) {
  diseases.add(disease);
    }
}
