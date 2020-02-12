package com.tabibu.desktop.diagnosis;

import com.tabibu.desktop.diagnosis.IDiagnosisController;
import com.tabibu.desktop.diagnosis.Diagnosis;
import com.tabibu.desktop.diagnosis.IDiagnosisView;
import io.reactivex.Single;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class DiagnosisView extends VBox implements IDiagnosisView {
    IDiagnosisController controller;
    @Override
    public void displayAllDiagnosis(Single<List<Diagnosis>> diagnoses) {
        ListView list=new ListView();
        diagnoses.subscribe(diagnosis1-> {
            diagnosis1.forEach(diagnosis-> {
                list.getItems().add(diagnosis.getDiagnosisDate());



            });
        });
        this.getChildren().add(list);

    }
    public void setController(IDiagnosisController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDiagnosis();
    }


}
