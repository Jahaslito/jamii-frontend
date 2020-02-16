package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diseases.IDiseaseController;

public class DiagnosisController implements IDiagnosisController {
    private IDiagnosisView diagnosisView;
    private IDiagnosisRepository diagnosisRepository;
    public DiagnosisController(IDiagnosisRepository diagnosisRepository){this.diagnosisRepository=diagnosisRepository;}

    @Override
    public void getAllDiagnosis() {
        diagnosisView.displayAllDiagnosis(diagnosisRepository.getAllDiagnosis(1));
    }
    public void setView(IDiagnosisView view){
        this.diagnosisView=view;
    }
}
