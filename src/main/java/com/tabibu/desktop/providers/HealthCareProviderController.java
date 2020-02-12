package com.tabibu.desktop.providers;

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
