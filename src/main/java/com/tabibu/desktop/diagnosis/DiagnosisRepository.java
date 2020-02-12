package com.tabibu.desktop.repository;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.model.Diagnosis;
import io.reactivex.Single;

import java.util.List;

public class DiagnosisRepository implements IDiagnosisRepository {
    TabibuApiService apiService= TabibuApplication.getApiService();
    @Override
    public Single<List<Diagnosis>> getAllDiagnosis() {
        return apiService.getAllDiagnosis();
    }
}
