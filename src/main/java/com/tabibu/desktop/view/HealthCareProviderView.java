package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.IHealthCareProviderController;
import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.List;

public class HealthCareProviderView extends StackPane implements IHealthCareProviderView {

    private IHealthCareProviderController controller;

    public void setController(IHealthCareProviderController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllProviders();
    }

    @Override
    public void displayHealthCareProviders(Single<List<HealthCareProvider>> providers) {
        providers.subscribe(healthCareProviders -> {
            healthCareProviders.forEach(healthCareProvider -> {
                Label mLabel = new Label();
                mLabel.setText(healthCareProvider.getName());
                mLabel.setMaxWidth(180);
                mLabel.setWrapText(true);
                this.getChildren().add(mLabel);
            });
        });
    }
}
