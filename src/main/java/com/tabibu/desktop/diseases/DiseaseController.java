package com.tabibu.desktop.diseases;

import com.tabibu.desktop.death.IDeathController;

public class DiseaseController implements IDeathController {
    IDiseaseRepository diseaserepository;
    IDiseaseView diseaseView;

    DiseaseController(IDiseaseRepository diseaserepository) {
        this.diseaserepository = diseaserepository;
    }

    @Override
    public void getAllDeaths() {
        diseaseView.displayAllDeaths(diseaserepository.getAllDiseases());

    }

    public void setDiseaseView(IDiseaseView view) {
        this.diseaseView = view;
    }
}
