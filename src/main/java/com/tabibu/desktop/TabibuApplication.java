package com.tabibu.desktop;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.view.controls.ToolbarItem;
import com.tabibu.desktop.controller.HealthCareProviderController;
import com.tabibu.desktop.repository.HealthCareProviderRepository;
import com.tabibu.desktop.repository.IProviderRepository;
import com.tabibu.desktop.repository.TabibuApiService;
import com.tabibu.desktop.view.CustomWorkBench;
import com.tabibu.desktop.view.HealthCareProviderView;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import javafx.stage.Stage;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.awt.*;


public class TabibuApplication extends Application {
Stage stage ;
    private Workbench workbench;

    public void start(Stage primaryStage) throws Exception {
        IProviderRepository providerRepository = new HealthCareProviderRepository();
        HealthCareProviderController providerController = new HealthCareProviderController(providerRepository);
        HealthCareProviderView providerView = new HealthCareProviderView();
        providerView.setController(providerController);
        providerController.setView(providerView);

        providerView.loadData();




        Form loginForm = Form.of(
                Group.of(
                        Field.ofStringType("model.usernameProperty()")
                                .label("Username"),
                        Field.ofStringType("model.passwordProperty()")
                                .label("Password")
                                .required("This field can’t be empty")
                )
        ).title("Login");
        providerView.getChildren().add(new FormRenderer(loginForm));
        Scene scene = new Scene(providerView);
        stage = new Stage();
        stage.setScene(scene);
        Workbench customWorkbench = Workbench.builder(
                new CustomWorkBench()

        )
                .modulesPerPage(6)
                .build();

        Scene myScene = new Scene(customWorkbench);
        primaryStage.setScene(myScene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(450);
        primaryStage.show();
    }
    private Workbench initWorkbench() {
        // Navigation Drawer
        MenuItem item1 = new MenuItem("Complaints", new MaterialDesignIconView(MaterialDesignIcon.BOMB));
        MenuItem item2 = new MenuItem("Printing", new MaterialDesignIconView(MaterialDesignIcon.PRINTER));
        MenuItem item3 = new MenuItem("Settings", new MaterialDesignIconView(MaterialDesignIcon.SETTINGS));

        ToolbarItem showDialogButton = new ToolbarItem("Reset",
                new MaterialDesignIconView(MaterialDesignIcon.SETTINGS));

        // WorkbenchFX
        workbench =
                Workbench.builder(
                 new CustomWorkBench()
                )
                        .toolbarLeft(new ToolbarItem("WorkbenchFX"))
                        .toolbarRight(showDialogButton)
                        .navigationDrawerItems(item1, item2, item3)
                        .build();

        showDialogButton.setOnClick(event -> workbench.showConfirmationDialog("Reset settings",
                "Are you sure you want to reset all your settings?", null));

        item1.setOnAction(event -> workbench.hideNavigationDrawer());
        item2.setOnAction(event -> workbench.hideNavigationDrawer());
        item3.setOnAction(event -> workbench.hideNavigationDrawer());

        // This sets the custom style. Comment this out to have a look at the default styles.
        workbench.getStylesheets().add(ExtendedDemo.class.getResource("customTheme.css").toExternalForm());
        //workbench.getStylesheets().add(ExtendedDemo.class.getResource("darkTheme.css").toExternalForm());

        return workbench;
    }

    private void initNightMode() {
        // initially set stylesheet
        setNightMode(preferences.isNightMode());

        // change stylesheet depending on whether nightmode is on or not
        preferences.nightModeProperty().addListener(
                (observable, oldValue, newValue) -> setNightMode(newValue)
        );
    }

    private void setNightMode(boolean on) {
        String customTheme = CustomWorkBench.class.getResource("customTheme.css").toExternalForm();
        String darkTheme = CustomWorkBench.class.getResource("darkTheme.css").toExternalForm();
        ObservableList<String> stylesheets = workbench.getStylesheets();
        if (on) {
            stylesheets.remove(customTheme);
            stylesheets.add(darkTheme);
        } else {
            stylesheets.remove(darkTheme);
            stylesheets.add(customTheme);
        }
    }
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

