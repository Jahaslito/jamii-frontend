package com.tabibu.desktop.data;

import com.tabibu.desktop.death.Death;
import com.tabibu.desktop.diagnosis.Diagnosis;
import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.http.*;

import java.util.List;

public interface TabibuApiService {
    @GET("providers")
    Single<List<HealthCareProvider>> getAllProviders();

    @GET("providers/{id}")
    Single<HealthCareProvider> getProvider(@Path("id") HealthCareProvider id);

    @POST("provider")
    void addProvider(@Body HealthCareProvider provider);

    @GET("diseases")
    Single<List<Disease>> getAllDiseases();

    @GET("diseases/{id}")
    Single<Disease> getDisease(@Path("id") Disease id);

    @GET("deaths")
    Single<List<Death>> getAllDeaths();

    @GET("diagnosis")
    Single<List<Diagnosis>> getAllDiagnosis(@Query("healthCareProviderId") int providerId);




}
