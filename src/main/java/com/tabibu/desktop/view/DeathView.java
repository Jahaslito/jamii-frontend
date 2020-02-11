package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.IDeathController;
import com.tabibu.desktop.controller.IHealthCareProviderController;
import com.tabibu.desktop.model.Death;
import com.tabibu.desktop.model.HealthCareProvider;
import io.reactivex.Single;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.List;

public class DeathView extends VBox implements IDeathView{
    private IDeathController controller;

    public void setController(IDeathController controller) {
        this.controller = controller;
    }

    public void loadData() {
        this.controller.getAllDeaths();
    }

    @Override
    public void displayDeath(Single<List<Death>> deaths) {
        ListView list=new ListView();
       deaths.subscribe(deaths1-> {
            deaths1.forEach(death -> {
                list.getItems().add(death.getCorpse_age());



            });
        });
        this.getChildren().add(list);
    }
}
