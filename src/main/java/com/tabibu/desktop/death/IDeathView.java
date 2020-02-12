package com.tabibu.desktop.view;

import com.tabibu.desktop.model.Death;
import io.reactivex.Single;

import java.util.List;

public interface IDeathView {
    void displayDeath(Single<List<Death>> deaths);
}
