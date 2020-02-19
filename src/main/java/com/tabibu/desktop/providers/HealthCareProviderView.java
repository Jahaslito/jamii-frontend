package com.tabibu.desktop.providers;

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
    private ObservableList<HealthCareProvider> providerList = FXCollections.observableArrayList();
    private TableView providersTable = new TableView();

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
                    providerList.addAll(healthCareProviders);
                });
    }

    public void initDataTable() {
        providersTable.setEditable(true);
        providersTable.setMinWidth(1000);
        providersTable.setMinHeight(500);

        TableColumn providerName = new TableColumn("Name");
        TableColumn providerPhone = new TableColumn("Phone");
        TableColumn providerEmail = new TableColumn("Email");
        TableColumn providerLocation = new TableColumn("Location");

        providerName.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, Integer>("Name")
        );
        providerPhone.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Phone")
        );
        providerEmail.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Email")
        );
        providerLocation.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Location")
        );
        providersTable.getColumns().addAll(providerName, providerPhone, providerEmail, providerLocation);
        providersTable.setItems(providerList);


        this.getChildren().add(providersTable);
    }
}
