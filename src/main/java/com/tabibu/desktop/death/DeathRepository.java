package com.tabibu.desktop.death;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;

import java.util.List;

public class DeathRepository implements IDeathRepository {
    TabibuApiService apiServicee= TabibuApplication.getApiService();
    @Override
    public Single<List<Death>> getAllDeaths() {
        return apiServicee.getAllDeaths();
    }
    public Call<DeathViewModel> createPost(@Body DeathViewModel death){return apiServicee.createPost(death);}
}
