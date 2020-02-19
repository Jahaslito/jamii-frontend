package com.tabibu.desktop.death;

import com.tabibu.desktop.util.TableBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

public class DeathView extends VBox implements IDeathView{

    private IDeathController controller;
    private ObservableList<DeathViewModel> deathList = FXCollections.observableArrayList();


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

    public void initDataTable() {
        TableView deathsTable = TableBuilder.createTable()
                .withColumns(List.of(
                        new TableColumn("Corpse Age"),
                        new TableColumn("Death Date"),
                        new TableColumn("Health Care Provider"),
                        new TableColumn("Disease")
                )).withProperties(List.of(
                        new PropertyValueFactory<Death, Integer>("corpseAge"),
                        new PropertyValueFactory<Death, String>("deathDate"),
                        new PropertyValueFactory<Death, String>("providerName"),
                        new PropertyValueFactory<Death, String>("diseaseName")
                )).withData(deathList).build();

        this.getChildren().add(deathsTable);
    }
}
