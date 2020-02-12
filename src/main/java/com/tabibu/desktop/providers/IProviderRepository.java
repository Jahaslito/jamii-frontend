package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;

import java.util.List;

public interface IProviderRepository {
    Single<List<HealthCareProvider>> getAllProviders();
}
