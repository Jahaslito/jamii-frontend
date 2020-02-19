package com.tabibu.desktop.providers;

public class HealthCareProviderController implements IHealthCareProviderController {
    private IHealthCareProviderView healthCareProviderView;
    private IProviderRepository providerRepository;

    public HealthCareProviderController(IProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public void getAllProviders() {
        healthCareProviderView.showLoadingUI();
        providerRepository.getAllProviders()
                .doOnError(error -> healthCareProviderView.showErrorMessage(error.getMessage()))
                .doAfterTerminate(() -> healthCareProviderView.hideLoadingUI())
                .subscribe(healthCareProviders -> {
            healthCareProviderView.displayHealthCareProviders(healthCareProviders);
        });
    }

    public void setView(IHealthCareProviderView view) {
        this.healthCareProviderView = view;
    }
}
