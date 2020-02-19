package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.common.BaseRepository;
import io.reactivex.Single;

import java.util.List;

public class DiagnosisRepository implements BaseRepository<Diagnosis>, IDiagnosisRepository {
    @Override
    public Single<List<Diagnosis>> getAllDiagnosis() {
        return apiService.getAllDiagnosis();
    }
}
