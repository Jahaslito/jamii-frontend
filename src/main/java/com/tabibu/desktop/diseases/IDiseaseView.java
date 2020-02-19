package com.tabibu.desktop.diseases;

import io.reactivex.Single;

import java.util.List;

public interface IDiseaseView {
    void displayAllDiseases(Single<List<Disease>> diseases);
}
