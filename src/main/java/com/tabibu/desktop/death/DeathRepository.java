package com.tabibu.desktop.death;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.data.TabibuApiService;
import io.reactivex.Single;

import java.util.List;

public class DeathRepository implements IDeathRepository {
    TabibuApiService apiServicee= TabibuApplication.getApiService();
    @Override
    public Single<List<Death>> getAllDeaths() {
        return apiServicee.getAllDeaths();
    }
}
