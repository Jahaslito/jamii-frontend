package com.tabibu.desktop.providers;

import io.reactivex.Single;

import java.util.List;

public interface IProviderRepository {
    Single<List<HealthCareProvider>> getAllProviders();

    Single<HealthCareProvider> getProvider(HealthCareProvider id);
}
