package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diagnosis.Diagnosis;
import io.reactivex.Single;

import java.util.List;

public interface  IDiagnosisRepository {
    Single<List<Diagnosis>> getAllDiagnosis(int providerId);
}
