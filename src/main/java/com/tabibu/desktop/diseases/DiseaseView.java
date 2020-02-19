package com.tabibu.desktop.diseases;

import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class DiseaseView extends Group implements IDiseaseView {

    private IDiseaseController controller;
    private ObservableList<Disease> diseaseList = FXCollections.observableArrayList();
    private TableView diseaseTable = new TableView();

    public DiseaseView() {
        initDataTable();
    }

    public void setController(IDiseaseController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDiseases();
    }

    @Override
    public void displayAllDiseases(Single<List<Disease>> diseases) {
        diseases.subscribe
                (disease -> {
                    diseaseList.addAll(disease);
                });
    }

    public void initDataTable() {
        diseaseTable.setEditable(true);
        diseaseTable.setMinWidth(1000);
        diseaseTable.setMinHeight(500);

        TableColumn diseaseName = new TableColumn("Name");
        TableColumn diseaseId = new TableColumn("id");
        TableColumn diseaseDescription = new TableColumn("Description");


        diseaseName.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Name")
        );
        diseaseDescription.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Description")
        );
        diseaseId.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, Integer>("id")
        );

        diseaseTable.getColumns().addAll(diseaseName, diseaseDescription);
        diseaseTable.setItems(diseaseList);


        this.getChildren().add(diseaseTable);
    }
}
