package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.http.GET;

import java.util.List;

public interface TabibuApiService {
    @GET("providers")
    Single<List<HealthCareProvider>> getAllProviders();
}
