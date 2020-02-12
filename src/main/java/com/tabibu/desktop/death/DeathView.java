package com.tabibu.desktop.death;

import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.sql.Date;
import java.util.List;

public class DeathView extends VBox implements IDeathView{

    private IDeathController controller;
    private ObservableList<DeathViewModel> deathList = FXCollections.observableArrayList();
    private TableView deathsTable = new TableView();

    public DeathView() {
        initDataTable();
    }

    public void setController(IDeathController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDeaths();
    }

    @Override
    public void displayDeaths(List<DeathViewModel> deaths) {
       deathList.addAll(deaths);
    }

    public void initDataTable(){
        deathsTable.setEditable(true);
        deathsTable.setMinWidth(1000);
        deathsTable.setMinHeight(500);

        TableColumn age = new TableColumn("Corpse Age");
        TableColumn date = new TableColumn("Death Date");
        TableColumn diseaseId =new TableColumn("Disease");
        TableColumn healthCareProviderId =new TableColumn("Health Care Provider");

        age.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider,Integer>("corpseAge")
        );
        date.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, Date>("deathDate")
        );
        diseaseId.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider,String>("diseaseName")
        );
        healthCareProviderId.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider,String>("providerName")
        );
        deathsTable.getColumns().addAll(age, date,diseaseId,healthCareProviderId);
        deathsTable.setItems(deathList);



        this.getChildren().add(deathsTable);
    }
}
