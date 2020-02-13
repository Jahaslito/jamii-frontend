package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diseases.Disease;
import com.tabibu.desktop.providers.HealthCareProvider;
import io.reactivex.Single;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

public class DiagnosisView extends VBox implements IDiagnosisView {

    private IDiagnosisController controller;
    private ObservableList<Diagnosis> diagnosisList = FXCollections.observableArrayList();
    private TableView diagnosesTable = new TableView();

    public DiagnosisView() {
        initDataTable();
    }

    public void setController(IDiagnosisController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDiagnosis();
    }

    @Override
    public void displayAllDiagnosis(Single<List<Diagnosis>> diagnosis) {
        diagnosis.subscribe
                (diagnosis1 -> {
                    diagnosisList.addAll(diagnosis1);
                });
    }

    public void initDataTable(){
        diagnosesTable.setEditable(true);
        diagnosesTable.setMinWidth(1000);
        diagnosesTable.setMinHeight(500);

        TableColumn diagnosisId = new TableColumn("Name");
        TableColumn providerId = new TableColumn("id");
        TableColumn diseaseDescription = new TableColumn("Description");


        diagnosisId.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider, String>("Name")
        );
        diseaseDescription.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider,String>("Description")
        );
        providerId.setCellValueFactory(
                new PropertyValueFactory<HealthCareProvider,Integer>("id")
        );

        diagnosesTable.getColumns().addAll(diagnosisId, diseaseDescription);
        diagnosesTable.setItems(diagnosisList);



        this.getChildren().add(diagnosesTable);
    }

}
