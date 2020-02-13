package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import io.reactivex.Single;

import java.util.List;

public class DiagnosisRepository implements IDiagnosisRepository {
    TabibuApiService apiService= TabibuApplication.getApiService();

    @Override
    public Single<List<Diagnosis>> getAllDiagnosis(int providerId) {
        return apiService.getAllDiagnosis(providerId);
    }
}
