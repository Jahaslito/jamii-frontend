package com.tabibu.desktop.diseases;

import com.tabibu.desktop.death.IDeathController;

public class DiseaseController implements IDiseaseController {
    IDiseaseRepository diseaserepository;
    IDiseaseView diseaseView;

    public DiseaseController(IDiseaseRepository diseaserepository) {
        this.diseaserepository = diseaserepository;
    }

    @Override
    public void getAllDiseases() {
        diseaseView.displayAllDiseases(diseaserepository.getAllDiseases());

    }

    public void setView(IDiseaseView view) {
        this.diseaseView = view;
    }
}
