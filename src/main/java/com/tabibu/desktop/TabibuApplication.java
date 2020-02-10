package com.tabibu.desktop;

import com.tabibu.desktop.controller.HealthCareProviderController;
import com.tabibu.desktop.controller.IHealthCareProviderController;
import com.tabibu.desktop.controller.TabibuController;
import com.tabibu.desktop.repository.HealthCareProviderRepository;
import com.tabibu.desktop.repository.IProviderRepository;
import com.tabibu.desktop.view.HealthCareProviderView;
import com.tabibu.desktop.view.IHealthCareProviderView;
import com.tabibu.desktop.view.TabibuLayout1;
import com.tabibu.desktop.view.TabibuStage;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;


public class TabibuApplication extends Application {
    TabibuStage stage ;
    public void start(Stage primaryStage) throws Exception {
        IProviderRepository providerRepository = new HealthCareProviderRepository();
        HealthCareProviderController providerController = new HealthCareProviderController(providerRepository);
        HealthCareProviderView providerView = new HealthCareProviderView();
        providerView.setController(providerController);
        providerController.setView(providerView);

        providerView.loadData();

        Scene scene = new Scene(providerView);
        stage = new TabibuStage();
        stage.setupstage(scene);
    }

    public static void main(String args) {
        launch(args);
    }
}
