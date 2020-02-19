package com.tabibu.desktop.diseases;

public class DiseaseController implements IDiseaseController {
    private IDiseaseRepository diseaseRepository;
    private IDiseaseView diseaseView;

    public DiseaseController(IDiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public void getAllDiseases() {
        diseaseView.displayAllDiseases(diseaseRepository.getAllDiseases());

    }

    public void setView(IDiseaseView view) {
        this.diseaseView = view;
    }
}
