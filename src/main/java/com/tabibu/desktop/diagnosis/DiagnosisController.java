package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diseases.IDiseaseController;

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
