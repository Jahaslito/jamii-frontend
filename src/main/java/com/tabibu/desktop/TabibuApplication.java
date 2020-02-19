package com.tabibu.desktop;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.model.WorkbenchModule;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
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
    private WorkbenchModule healthCareProviderModule, diseaseModule, deathModule,
            diagnosisModule, diseasesFrequencyView, diseasesTrendView, diseasesDeathTollView;

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
        MenuItem providersMenu = new MenuItem("Healthcare Providers", new MaterialDesignIconView(MaterialDesignIcon.HOSPITAL));
        MenuItem diseaseMenu = new MenuItem("Disease Records", new FontAwesomeIconView(FontAwesomeIcon.BUG));
        MenuItem deathMenu = new MenuItem("Death Records", new FontAwesomeIconView(FontAwesomeIcon.USER_TIMES));
        MenuItem diagnosesMenu = new MenuItem("Diagnosis Records", new MaterialDesignIconView(MaterialDesignIcon.THERMOMETER));
        Menu analyticsMenu = new Menu("Analytics & DataViz", new FontAwesomeIconView(FontAwesomeIcon.AREA_CHART));
        MenuItem diseaseFrequencyMenu = new MenuItem("Disease Frequency Analysis", new FontAwesomeIconView(FontAwesomeIcon.PIE_CHART));
        MenuItem diseaseTrendMenu = new MenuItem("Disease Trend Analysis", new FontAwesomeIconView(FontAwesomeIcon.LINE_CHART));
        MenuItem diseaseTollMenu = new MenuItem("Disease Death Toll Analysis", new FontAwesomeIconView(FontAwesomeIcon.HEARTBEAT));
        analyticsMenu.getItems().addAll(diseaseFrequencyMenu, diseaseTrendMenu, diseaseTollMenu);

        this.healthCareProviderModule = new HealthCareProviderModule(providerView);
        this.diseaseModule = new DiseaseModule(diseaseView);
        this.deathModule = new DeathModule(deathView);
        this.diagnosisModule = new DiagnosisModule(diagnosisView);
        this.diseasesFrequencyView = new DiseasesFrequencyView(reportsView);
        this.diseasesTrendView = new DiseasesTrendView(reportsView);
        this.diseasesDeathTollView = new DiseasesDeathTollView(reportsView);

        this.workbench =
                Workbench.builder(
                        this.healthCareProviderModule,
                        this.diseaseModule,
                        this.deathModule,
                        this.diagnosisModule,
                        this.diseasesFrequencyView,
                        this.diseasesTrendView,
                        this.diseasesDeathTollView
                )
                        .toolbarLeft(new ToolbarItem("Tabibu Healthcare"))
                        .navigationDrawerItems(providersMenu, diseaseMenu, deathMenu, diagnosesMenu, analyticsMenu)
                        .build();
        workbench.getStylesheets().add(this.getClass().getResource("/theme.css").toExternalForm());

        providersMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.healthCareProviderModule);
            workbench.hideNavigationDrawer();
        });
        diseaseMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.diseaseModule);
            workbench.hideNavigationDrawer();
        });
        deathMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.deathModule);
            workbench.hideNavigationDrawer();
        });
        diagnosesMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.diagnosisModule);
            workbench.hideNavigationDrawer();
        });
        diseaseFrequencyMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.diseasesFrequencyView);
            workbench.hideNavigationDrawer();
        });
        diseaseTrendMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.diseasesTrendView);
            workbench.hideNavigationDrawer();
        });
        diseaseTollMenu.setOnAction(actionEvent -> {
            workbench.openModule(this.diseasesDeathTollView);
            workbench.hideNavigationDrawer();
        });
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
