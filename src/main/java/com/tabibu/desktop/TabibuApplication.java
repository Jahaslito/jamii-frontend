package com.tabibu.desktop;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.view.controls.ToolbarItem;
import com.tabibu.desktop.data.TabibuApiService;
import com.tabibu.desktop.death.*;
import com.tabibu.desktop.diagnosis.*;
import com.tabibu.desktop.diseases.*;
import com.tabibu.desktop.providers.*;
import com.tabibu.desktop.report.*;
import com.tabibu.desktop.util.Constants;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
        Scene workbenchScene = new Scene(workbench);

        primaryStage.setScene(workbenchScene);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(launcherIcon);
        primaryStage.setTitle("Tabibu Healthcare");
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

    private void initWorkbench() {
        // Navigation Drawer
        MenuItem providersMenu = new MenuItem("Healthcare Providers", new MaterialDesignIconView(MaterialDesignIcon.HOSPITAL));
        MenuItem diseaseMenu = new MenuItem("Disease Records", new FontAwesomeIconView(FontAwesomeIcon.BUG));
        MenuItem deathMenu = new MenuItem("Death Records", new FontAwesomeIconView(FontAwesomeIcon.USER_TIMES));
        MenuItem diagnosesMenu = new MenuItem("Diagnosis Records", new MaterialDesignIconView(MaterialDesignIcon.THERMOMETER));

        // WorkbenchFX
        this.workbench =
                Workbench.builder(
                        new HealthCareProviderModule(providerView),
                        new DiseaseModule(diseaseView),
                        new DeathModule(deathView),
                        new DiagnosisModule(diagnosisView),
                        new DiseasesFrequencyView(reportsView),
                        new DiseasesTrendView(reportsView),
                        new DiseasesDeathTollView(reportsView)
                )
                        .toolbarLeft(new ToolbarItem("Tabibu Healthcare"))
                        .navigationDrawerItems(providersMenu, diseaseMenu, deathMenu, diagnosesMenu)
                        .build();
        workbench.getStylesheets().add(this.getClass().getResource("/theme.css").toExternalForm());

        // TODO: Open approriate modules
        deathMenu.setOnAction(event -> workbench.showConfirmationDialog("Reset settings",
                "Are you sure you want to reset all your settings?", null));
        diseaseMenu.setOnAction(event -> workbench.hideNavigationDrawer());
        providersMenu.setOnAction(event -> workbench.hideNavigationDrawer());
    }

    public static void main(String args) {
        launch(args);
    }

    public static TabibuApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.TABIBU_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(TabibuApiService.class);
    }
}
