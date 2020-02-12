package com.tabibu.desktop.death;

import io.reactivex.Single;

import java.util.List;

public interface IDeathRepository {
    Single<List<Death>> getAllDeaths();
}
