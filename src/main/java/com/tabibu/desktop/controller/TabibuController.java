package com.tabibu.desktop.controller;

import com.tabibu.desktop.model.TabibuDatabase;
import com.tabibu.desktop.view.TabibuLayout1;
import com.tabibu.desktop.view.TabibuStage;
import com.tabibu.desktop.view.Tabibulayout2;
import javafx.scene.Scene;

public class TabibuController {
private TabibuDatabase database;
private Scene scene,scene2;
private TabibuLayout1 layout;
private Tabibulayout2 tabibulayout2;
private TabibuStage stage;

    public TabibuController(){
        database=new TabibuDatabase();


    }


    public TabibuDatabase getDatabase() {
        return database;
    }
}
