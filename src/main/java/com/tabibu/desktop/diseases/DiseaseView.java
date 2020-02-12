package com.tabibu.desktop.diseases;

import io.reactivex.Single;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class DiseaseView  extends VBox implements IDiseaseView {
    IDiseaseController controller;
    public void setController(IDiseaseController controller){this.controller=controller;}
    public void loadData() {
        this.controller.getAllDiseases();
    }

    @Override
    public void displayAllDeaths(Single<List<Disease>> diseases) {
        ListView list=new ListView();
        diseases.subscribe(disease1-> {
            disease1.forEach(disease -> {
                list.getItems().add(disease.getName());



            });
        });
        this.getChildren().add(list);

    }
}
