package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.IDeathController;
import com.tabibu.desktop.controller.IDiagnosisController;
import com.tabibu.desktop.model.Death;
import com.tabibu.desktop.model.Diagnosis;
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
                list.getItems().add(diagnosis.getDiagnosis_date());



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
