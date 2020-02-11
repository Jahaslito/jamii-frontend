package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.Diagnosis;
import io.reactivex.Single;

import java.util.List;

public interface  IDiagnosisRepository {
    Single<List<Diagnosis>> getAllDiagnosis();
}
