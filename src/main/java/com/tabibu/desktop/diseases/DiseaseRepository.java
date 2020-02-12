package com.tabibu.desktop.repository;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.model.Disease;
import io.reactivex.Single;

import java.util.List;

public class DiseaseRepository implements IDiseaseRepository{
    TabibuApiService apiService= TabibuApplication.getApiService();
    @Override
    public Single<List<Disease>> getAllDiseases() {
        return apiService.getAllDiseases();
    }
}
