package com.tabibu.desktop.diseases;

import com.tabibu.desktop.diseases.Disease;
import io.reactivex.Single;

import java.util.List;

public interface IDiseaseView {
    void displayAllDeaths(Single<List<Disease>> diseases);
}
