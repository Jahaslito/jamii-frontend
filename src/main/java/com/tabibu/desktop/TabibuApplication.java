package com.tabibu.desktop;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.text.Normalizer;

public class TabibuApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane=new StackPane();

        Scene scene=new Scene(pane,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String args){
        launch(args);
    }
}
