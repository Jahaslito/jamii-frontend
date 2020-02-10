package com.tabibu.desktop.view;

import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;

import java.util.List;

public interface IHealthCareProviderView {
    void displayHealthCareProviders(Single<List<HealthCareProvider>> providers);
}
