package com.tabibu.desktop.repository;

import com.tabibu.desktop.TabibuApplication;
import com.tabibu.desktop.model.Death;
import io.reactivex.Single;

import java.util.List;

public class DeathRepository implements IDeathRepository {
    TabibuApiService apiServicee= TabibuApplication.getApiService();
    @Override
    public Single<List<Death>> getAllDeaths() {
        return apiServicee.getAllDeaths();
    }
}
