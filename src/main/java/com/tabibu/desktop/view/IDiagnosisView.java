package com.tabibu.desktop.view;

import com.tabibu.desktop.model.Diagnosis;
import io.reactivex.Single;

import java.util.List;

public interface IDiagnosisView {
    void displayAllDiagnosis(Single<List<Diagnosis>> diagnosis);
}
