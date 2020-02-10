package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.HealthCareProvider;

import java.util.List;

public class HealthCareProviderRepository implements IProviderRepository {

    @Override
    public List<HealthCareProvider> getAllProviders() {
        return List.of(new HealthCareProvider("Bliss"),
                new HealthCareProvider("KNH"),
                new HealthCareProvider("Nairobi Hospital"));
    }
}
