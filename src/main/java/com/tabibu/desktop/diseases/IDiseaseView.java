package com.tabibu.desktop.diseases;

import com.tabibu.desktop.common.BaseView;
import io.reactivex.Single;

import java.util.List;

public interface IDiseaseView extends BaseView {
    void displayAllDiseases(Single<List<Disease>> diseases);
}
