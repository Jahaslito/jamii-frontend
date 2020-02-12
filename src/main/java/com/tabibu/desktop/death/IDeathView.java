package com.tabibu.desktop.death;

import com.tabibu.desktop.death.Death;
import io.reactivex.Single;

import java.util.List;

public interface IDeathView {
    void displayDeaths(List<DeathViewModel> deaths);
}
