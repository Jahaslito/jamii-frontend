package com.tabibu.desktop.diseases;

import com.tabibu.desktop.common.BaseRepository;
import io.reactivex.Single;

import java.util.List;

public class DiseaseRepository implements BaseRepository<Disease>, IDiseaseRepository {
    @Override
    public Single<List<Disease>> getAllDiseases() {
        return apiService.getAllDiseases();
    }
}
