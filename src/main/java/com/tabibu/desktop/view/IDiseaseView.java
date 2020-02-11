package com.tabibu.desktop.view;

import com.tabibu.desktop.model.Disease;
import io.reactivex.Single;

import java.util.List;

public interface IDiseaseView {
    void displayAllDeaths(Single<List<Disease>> diseases);
}
