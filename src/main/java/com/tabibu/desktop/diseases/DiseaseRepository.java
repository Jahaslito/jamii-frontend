package com.tabibu.desktop.diseases;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import io.reactivex.Single;

import java.util.List;

public class DiseaseRepository implements IDiseaseRepository {
    TabibuApiService apiService= TabibuApplication.getApiService();
    @Override
    public Single<List<Disease>> getAllDiseases() {
        return apiService.getAllDiseases();
    }

    @Override
    public Single<Disease> getDisease(int id) {
        return apiService.getDisease(id);
    }
}
