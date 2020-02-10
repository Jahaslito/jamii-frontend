package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.HealthCareProvider;

import java.util.List;

public interface IProviderRepository {
    List<HealthCareProvider> getAllProviders();
}
