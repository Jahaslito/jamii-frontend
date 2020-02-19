package com.tabibu.desktop.diseases;

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

public class DiseaseView extends Group implements IDiseaseView {

    private IDiseaseController controller;
    private ObservableList<Disease> diseasesList = FXCollections.observableArrayList();

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
                    diseasesList.addAll(disease);
                });
    }

    public void initDataTable() {
        TableView diseasesTable = TableBuilder.createTable()
                .withColumns(List.of(
                        new TableColumn("Name"),
                        new TableColumn("Description")
                )).withProperties(List.of(
                        new PropertyValueFactory<DiagnosisViewModel, Integer>("name"),
                        new PropertyValueFactory<DiagnosisViewModel, String>("description")
                )).withData(diseasesList).build();
        this.getChildren().add(diseasesTable);
    }
}
