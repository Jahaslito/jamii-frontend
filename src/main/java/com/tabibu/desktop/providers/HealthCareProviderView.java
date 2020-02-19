package com.tabibu.desktop.providers;

import com.tabibu.desktop.common.TabibuView;
import com.tabibu.desktop.diagnosis.DiagnosisViewModel;
import com.tabibu.desktop.util.TableBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class HealthCareProviderView extends TabibuView implements IHealthCareProviderView {

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
    public void displayHealthCareProviders(List<HealthCareProvider> providers) {
        providersList.addAll(providers);
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

    @Override
    public void showLoadingUI() {
        super.showLoadingDialog();
    }

    @Override
    public void hideLoadingUI() {
        super.hideLoadingDialog();
    }

    @Override
    public void showErrorMessage(String message) {
        super.showErrorDialog(message);
    }
}
