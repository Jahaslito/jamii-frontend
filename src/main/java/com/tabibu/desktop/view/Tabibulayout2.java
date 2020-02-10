package com.tabibu.desktop.view;

import com.tabibu.desktop.controller.TabibuController;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Tabibulayout2 extends StackPane {
    private TabibuController tabibucontroller ;
    private TabibuStage stage;

    private Button hi;
    public Tabibulayout2(TabibuController tabibucontroller,TabibuStage stage){
        this.tabibucontroller=tabibucontroller;
        this.stage=stage;
    }
    public  void setuplayout(){
        hi=new Button("done");
        this.getChildren().add(hi);
    }
    public void setlisteners (Scene scene) {

        hi.setOnAction(new EventHandler() {
            @Override
            public void handle(javafx.event.Event event) {

                stage.setScene(scene);
            }


        });
    }

}
