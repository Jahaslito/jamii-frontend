package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.Death;
import com.tabibu.desktop.diagnosis.Diagnosis;
import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.http.GET;

import java.util.List;

public interface TabibuApiService {
    @GET("providers")
    Single<List<HealthCareProvider>> getAllProviders();
    @GET("diseases")
    Single<List<Disease>> getAllDiseases();
    @GET("deaths")
    Single<List<Death>> getAllDeaths();
    @GET("diagnosis")
    Single<List<Diagnosis>> getAllDiagnosis();

}
