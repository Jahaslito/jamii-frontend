package com.tabibu.desktop.providers;

import com.tabibu.desktop.data.BaseRepository;
import io.reactivex.Single;

import java.util.List;

public class HealthCareProviderRepository implements BaseRepository<HealthCareProvider>, IProviderRepository {
    @Override
    public Single<List<HealthCareProvider>> getAllProviders() {
        return apiService.getAllProviders();
    }
}
