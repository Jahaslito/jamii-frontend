package com.tabibu.desktop.death;

import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;

import java.util.List;

public interface IDeathRepository {
    Single<List<Death>> getAllDeaths();
    Call<DeathViewModel> createPost(@Body DeathViewModel death);
}
