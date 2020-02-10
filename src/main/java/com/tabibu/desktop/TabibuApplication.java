package com.tabibu.desktop;

import com.tabibu.desktop.controller.HealthCareProviderController;
import com.tabibu.desktop.repository.HealthCareProviderRepository;
import com.tabibu.desktop.repository.IProviderRepository;
import com.tabibu.desktop.repository.TabibuApiService;
import com.tabibu.desktop.view.HealthCareProviderView;
import com.tabibu.desktop.view.TabibuStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


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

    public static TabibuApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://0d840305.ngrok.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(TabibuApiService.class);
    }
}
