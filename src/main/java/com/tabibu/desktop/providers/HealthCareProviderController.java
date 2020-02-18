package com.tabibu.desktop.providers;

import io.reactivex.Single;

public class HealthCareProviderController implements IHealthCareProviderController {
    private IHealthCareProviderView healthCareProviderView;
    private IProviderRepository providerRepository;

    public HealthCareProviderController(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public void getAllProviders() {

        healthCareProviderView.displayHealthCareProviders(providerRepository.getAllProviders());
    }

    public void setView(IHealthCareProviderView view) {
        this.healthCareProviderView = view;
    }
}
