package com.tabibu.desktop.providers;

import com.tabibu.desktop.common.BaseView;

import java.util.List;

public interface IHealthCareProviderView extends BaseView {
    void displayHealthCareProviders(List<HealthCareProvider> providers);
}
