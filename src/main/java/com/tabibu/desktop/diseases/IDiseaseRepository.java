package com.tabibu.desktop.diseases;

import com.tabibu.desktop.diseases.Disease;
import io.reactivex.Single;

import java.util.List;

public interface IDiseaseRepository {
    Single<List<Disease>> getAllDiseases();

    Single<Disease> getDisease(int id);
}
