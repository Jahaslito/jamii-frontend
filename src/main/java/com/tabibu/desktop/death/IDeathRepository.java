package com.tabibu.desktop.repository;

import com.tabibu.desktop.model.Death;
import io.reactivex.Single;

import java.util.List;

public interface IDeathRepository {
    Single<List<Death>> getAllDeaths();
}
