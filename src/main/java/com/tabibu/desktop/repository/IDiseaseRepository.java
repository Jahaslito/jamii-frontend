package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.Disease;
import io.reactivex.Single;

import java.util.List;

public interface IDiseaseRepository {
    Single<List<Disease>> getAllDiseases();
}
