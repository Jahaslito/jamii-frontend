package com.tabibu.desktop.providers;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import io.reactivex.Single;

import java.util.List;

public class HealthCareProviderRepository implements IProviderRepository {

    private TabibuApiService apiService = TabibuApplication.getApiService();
    @Override
    public Single<List<HealthCareProvider>> getAllProviders() {
        return apiService.getAllProviders();
    }

    @Override
    public Single<HealthCareProvider> getProvider(HealthCareProvider id) {
        return apiService.getProvider(id);
    }
}
