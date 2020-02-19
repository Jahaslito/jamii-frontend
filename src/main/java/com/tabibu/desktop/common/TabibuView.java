package com.tabibu.desktop.common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;

public abstract class TabibuView extends Parent {
    private Alert alert = new Alert(Alert.AlertType.NONE);
    private ProgressIndicator progressIndicator = new ProgressIndicator();

    protected void showLoadingDialog() {
        this.getChildren().forEach(child-> {
            child.setOpacity(0);
        });
        this.getChildren().add(progressIndicator);
    }

    protected void hideLoadingDialog() {
        this.getChildren().remove(progressIndicator);
        this.getChildren().forEach(child-> {
            child.setOpacity(100);
        });
    }

    protected void showErrorDialog(String message) {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Tabibu Healthcare");
        alert.setHeaderText("Oops! An error occurred");
        alert.setContentText(message);
        alert.show();
    }

    protected void showInfoDialog(String title, String message) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Tabibu Healthcare");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.show();
    }
}
