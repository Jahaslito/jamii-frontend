package com.tabibu.desktop.repository;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class HealthCareProviderRepository implements IProviderRepository {

    private TabibuApiService apiService = TabibuApplication.getApiService();
    @Override
    public Single<List<HealthCareProvider>> getAllProviders() {
        return apiService.getAllProviders();
    }
}
