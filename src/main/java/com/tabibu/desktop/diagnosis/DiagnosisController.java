package com.tabibu.desktop.controller;

import com.tabibu.desktop.model.Diagnosis;
import com.tabibu.desktop.repository.IDiagnosisRepository;
import com.tabibu.desktop.view.IDiagnosisView;
import com.tabibu.desktop.view.IDiseaseView;

public class DiagnosisController implements IDiseaseController {
    private IDiagnosisView diagnosisView;
    private IDiagnosisRepository diagnosisRepository;
    public DiagnosisController(IDiagnosisRepository diagnosisRepository){this.diagnosisRepository=diagnosisRepository;}

    @Override
    public void getAllDiseases() {
        diagnosisView.displayAllDiagnosis(diagnosisRepository.getAllDiagnosis());

    }
    public void setDiagnosisView(IDiagnosisView view){
        this.diagnosisView=view;
    }
}
