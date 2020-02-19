package com.tabibu.desktop.providers;

import io.reactivex.Single;

import java.util.List;

public interface IHealthCareProviderView {
    void displayHealthCareProviders(Single<List<HealthCareProvider>> providers);
}
