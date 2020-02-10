package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.IHealthCareProviderController;
import com.tabibu.desktop.model.HealthCareProvider;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.util.List;

public class HealthCareProviderView extends StackPane implements IHealthCareProviderView {

    private IHealthCareProviderController controller;

    @Override
    public void displayHealthCareProviders(List<HealthCareProvider> providers) {
        for(HealthCareProvider provider: providers) {
            Label mLabel = new Label();
            mLabel.setText(provider.getName());
            this.getChildren().add(mLabel);
        }
    }

    public void setController(IHealthCareProviderController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllProviders();
    }
}
