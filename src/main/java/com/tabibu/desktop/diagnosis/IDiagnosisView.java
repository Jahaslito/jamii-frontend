package com.tabibu.desktop.diagnosis;

import io.reactivex.Single;

import java.util.List;

public interface IDiagnosisView {
    void displayAllDiagnosis(List<DiagnosisViewModel> diagnoses);
}
