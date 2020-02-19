package com.tabibu.desktop.data;

import com.tabibu.desktop.death.Death;
import com.tabibu.desktop.death.DeathViewModel;
import com.tabibu.desktop.diagnosis.Diagnosis;
import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;
import com.tabibu.desktop.report.ReportViewModel;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.*;

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

    @GET("reports")
    Single<ReportViewModel> getReport(@Query("year") int year, @Query("diseaseId") Integer diseaseId);
}
