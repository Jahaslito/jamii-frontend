package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.diseases.IDiseaseController;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiagnosisController implements IDiagnosisController {
    private IDiagnosisView diagnosisView;
    private IDiagnosisRepository diagnosisRepository;

    public DiagnosisController(IDiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public void getAllDiagnosis() {
        diagnosisRepository.getAllDiagnosis().subscribe(diagnosisList -> {
            diagnosisView.displayAllDiagnosis(
                    diagnosisList.stream().map(diagnosis -> {
                        DiagnosisViewModel diagnosisViewModel = new DiagnosisViewModel();
                        diagnosisViewModel.setHealthCareProvider(diagnosis.getHealthCareProvider().getName());
                        diagnosisViewModel.setDiagnosisDate(diagnosis.getDiagnosisDate());
                        diagnosisViewModel.setPatientAge(diagnosis.getPatientAge());
                        diagnosisViewModel.setDiseases(diagnosis.getDiseases()
                                .stream().map(Disease::getName).collect(Collectors.joining(", ")));
                        return diagnosisViewModel;
                    }).collect(Collectors.toList()));
        });
    }

    public void setView(IDiagnosisView view) {
        this.diagnosisView = view;
    }
}
