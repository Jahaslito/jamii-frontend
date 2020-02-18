package com.tabibu.desktop;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.view.controls.ToolbarItem;
import com.tabibu.desktop.data.TabibuApiService;
import com.tabibu.desktop.death.*;
import com.tabibu.desktop.diagnosis.*;
import com.tabibu.desktop.diseases.*;
import com.tabibu.desktop.providers.*;
import com.tabibu.desktop.report.*;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class TabibuApplication extends Application {
    private Workbench workbench;
    private HealthCareProviderView providerView;
    private DeathView deathView;
    private DiseaseView diseaseView;
    private DiagnosisView diagnosisView;
    private ReportsView reportsView;

    public void start(Stage primaryStage) throws Exception {
        initMvc();
        initWorkbench();

        Image launcherIcon = new Image("/logo.png");
        Scene myScene = new Scene(workbench);

        primaryStage.setScene(myScene);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(launcherIcon);
        primaryStage.show();
    }

    private void initMvc() {
        IProviderRepository providerRepository = new HealthCareProviderRepository();
        HealthCareProviderController providerController = new HealthCareProviderController(providerRepository);
        providerView = new HealthCareProviderView();
        providerView.setController(providerController);
        providerController.setView(providerView);
        providerView.loadData();

        IDeathRepository deathRepository = new DeathRepository();
        DeathController deathController = new DeathController(deathRepository);
        deathView = new DeathView();
        deathView.setController(deathController);
        deathController.setView(deathView);
        deathView.loadData();

        IDiseaseRepository diseaseRepository = new DiseaseRepository();
        DiseaseController diseaseController = new DiseaseController(diseaseRepository);
        diseaseView = new DiseaseView();
        diseaseView.setController(diseaseController);
        diseaseController.setView(diseaseView);
        diseaseView.loadData();

        IDiagnosisRepository diagnosisRepository = new DiagnosisRepository();
        DiagnosisController diagnosisController = new DiagnosisController(diagnosisRepository);
        diagnosisView = new DiagnosisView();
        diagnosisView.setController(diagnosisController);
        diagnosisController.setView(diagnosisView);
        diagnosisView.loadData();

        IReportRepository reportRepository = new ReportRepository();
        ReportsController reportsController = new ReportsController(reportRepository);
        reportsView = new ReportsView();
        reportsView.setController(reportsController);
        reportsController.setView(reportsView);
        reportsView.loadData();
    }

    private Workbench initWorkbench() {
        // Navigation Drawer
        MenuItem item1 = new MenuItem("Death records", new MaterialDesignIconView(MaterialDesignIcon.EMOTICON_DEAD));
        MenuItem item2 = new MenuItem("Disease records", new MaterialDesignIconView(MaterialDesignIcon.PRINTER));
        MenuItem item3 = new MenuItem("health care providers", new MaterialDesignIconView(MaterialDesignIcon.HOSPITAL));
        MenuItem item4 = new MenuItem("Diagnoses", new MaterialDesignIconView(MaterialDesignIcon.BELL));

        // WorkbenchFX
        workbench =
                Workbench.builder(
                        new ProviderModule(providerView),
                        new DiseaseModule(diseaseView),
                        new DeathModule(deathView),
                        new DiagnosisModule(diagnosisView),
                        new ReportModule(reportsView)
                )
                        .toolbarLeft(new ToolbarItem("Tabibu Healthcare"))
                        .navigationDrawerItems(item1, item2, item3, item4)
                        .build();

        item1.setOnAction(event -> workbench.showConfirmationDialog("Reset settings",
                "Are you sure you want to reset all your settings?", null));
        item2.setOnAction(event -> workbench.hideNavigationDrawer());
        item3.setOnAction(event -> workbench.hideNavigationDrawer());
        workbench.getStylesheets().add(this.getClass().getResource("/theme.css").toExternalForm());

        return workbench;
    }

    public static void main(String args) {
        launch(args);
    }

    public static TabibuApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-54-169-6-222.ap-southeast-1.compute.amazonaws.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(TabibuApiService.class);
    }
}
