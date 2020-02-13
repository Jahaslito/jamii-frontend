package com.tabibu.desktop.diseases;

import io.reactivex.Single;

import java.util.List;

public interface IDiseaseRepository {
    Single<List<Disease>> getAllDiseases();

    Single<Disease> getDisease(Disease id);
}
