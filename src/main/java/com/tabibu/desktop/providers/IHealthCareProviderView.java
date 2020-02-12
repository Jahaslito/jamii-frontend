package com.tabibu.desktop.providers;

import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;

import java.util.List;

public interface IHealthCareProviderView {
    void displayHealthCareProviders(Single<List<HealthCareProvider>> providers);
}
