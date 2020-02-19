package com.tabibu.desktop.death;

import com.tabibu.desktop.data.BaseRepository;
import io.reactivex.Single;

import java.util.List;

public class DeathRepository implements BaseRepository<Death>, IDeathRepository {
    @Override
    public Single<List<Death>> getAllDeaths() {
        return apiService.getAllDeaths();
    }
}
