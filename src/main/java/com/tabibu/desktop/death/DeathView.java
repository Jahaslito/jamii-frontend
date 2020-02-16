package com.tabibu.desktop.death;

import com.tabibu.desktop.providers.HealthCareProvider;
import com.tabibu.desktop.util.TableBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.List;

public class DeathView extends VBox implements IDeathView{

    private IDeathController controller;
    private ObservableList<DeathViewModel> deathList = FXCollections.observableArrayList();


    public DeathView() {
        initDataTable();
        addDeath();
    }

    public void setController(IDeathController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDeaths();


    }
    public void addDeath(){
        TextField corpseAge=new TextField("age");
        TextField providername=new TextField("helathcare provider");
        TextField causeOfDeath=new TextField("cause of field");
        DatePicker date=new DatePicker();
        int age=45;
        Button add=new Button("add");
        add.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                controller.addDeath(age,causeOfDeath.getText(),providername.getText(),date.getPromptText());
                System.out.println("added");

            }
        });

        this.getChildren().addAll(corpseAge,causeOfDeath,providername,date,add);






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
