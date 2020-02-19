package com.tabibu.desktop.providers;

import com.tabibu.desktop.diagnosis.DiagnosisViewModel;
import com.tabibu.desktop.util.TableBuilder;
import io.reactivex.Single;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class HealthCareProviderView extends Group implements IHealthCareProviderView {

    private IHealthCareProviderController controller;
    private ObservableList<HealthCareProvider> providersList = FXCollections.observableArrayList();

    public HealthCareProviderView() {
        initDataTable();
    }

    public void setController(IHealthCareProviderController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllProviders();
    }

    @Override
    public void displayHealthCareProviders(Single<List<HealthCareProvider>> providers) {
        providers.subscribe
                (healthCareProviders -> {
                    providersList.addAll(healthCareProviders);
                });
    }

    public void initDataTable() {
        TableView providersTable = TableBuilder.createTable()
                .withColumns(List.of(
                        new TableColumn("Name"),
                        new TableColumn("Phone"),
                        new TableColumn("Email"),
                        new TableColumn("Location")
                )).withProperties(List.of(
                        new PropertyValueFactory<DiagnosisViewModel, Integer>("name"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("email"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("phone"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("location")
                )).withData(providersList).build();
        this.getChildren().add(providersTable);
    }
}
