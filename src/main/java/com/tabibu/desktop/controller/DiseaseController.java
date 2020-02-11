package com.tabibu.desktop.controller;

import com.tabibu.desktop.repository.IDiseaseRepository;
import com.tabibu.desktop.view.IDiseaseView;

public class DiseaseController  implements IDeathController {
    IDiseaseRepository diseaserepository;
    IDiseaseView diseaseView;
    DiseaseController(IDiseaseRepository diseaserepository){
        this.diseaserepository=diseaserepository;
    }
    @Override
    public void getAllDeaths() {
        diseaseView.displayAllDeaths(diseaserepository.getAllDiseases());

    }
    public void setDiseaseView(IDiseaseView view){this.diseaseView=view;}
}
