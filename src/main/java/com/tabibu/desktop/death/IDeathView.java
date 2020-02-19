package com.tabibu.desktop.death;

import com.tabibu.desktop.common.BaseView;

import java.util.List;

public interface IDeathView extends BaseView {
    void displayDeaths(List<DeathViewModel> deaths);
}
