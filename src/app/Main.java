package app;





import com.sun.prism.paint.Color;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.util.Duration;


import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class Main extends Application{
    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Scene scene = logInScene();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Scene logInScene(){
        Pane root = new Pane();
        Button createAccountButton = new Button("sign in");
        createAccountButton.relocate(400,400);

        createAccountButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                stage.setScene(CreateAccountScene());
            }
        });
        root.getChildren().add(createAccountButton);


        File imageFile = new File("back.jpg");
        Image image = new Image(imageFile.toURI().toString());

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);

        root.setBackground(background);
        return new Scene(root,800,800);
    }
    protected Scene CreateAccountScene() {
        VBox root = new VBox();
        Label userLabel = new Label("Insert the username:");

        userLabel.setTextFill(Paint.valueOf("#79CEE3"));
        Label passLabel = new Label("Insert the password:");

        passLabel.setTextFill(Paint.valueOf("#79CEE3"));
        final TextField userField = new TextField();

        final PasswordField passField = new PasswordField();


        Button signinButton = new Button("sign in");
        signinButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                System.out.println("Account for user " + userField.getText() + " was created succesfully");
                stage.setScene(first());
            }
        });
        root.getChildren().addAll(userLabel,userField,passLabel,passField,signinButton);
        File imageFile = new File("back.jpg");
        Image image = new Image(imageFile.toURI().toString());

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);
        root.setBackground(background);
        return new Scene(root,800,800);
    }




    public Scene first(){
        Button btn = new Button();
        btn.setText("File");

        final StackPane root = new StackPane();
        AnchorPane editorRoot = new AnchorPane();
        editorRoot.getChildren().add(btn);
        root.getChildren().add(editorRoot);



        HBox fileRoot = new HBox();
        VBox menu = new VBox();
        menu.setStyle("-fx-background-color: grey;");
        menu.setFillWidth(true);
        Button backBtn = new Button("back");
        backBtn.setPrefWidth(150);
        backBtn.getStyleClass().add("custom-menu-button");
        backBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                FadeTransition hideFileRootTransition = new FadeTransition(Duration.millis(500), fileRoot);
                hideFileRootTransition.setFromValue(1.0);
                hideFileRootTransition.setToValue(0.0);

                FadeTransition showEditorRootTransition = new FadeTransition(Duration.millis(500), editorRoot);
                showEditorRootTransition.setFromValue(0.0);
                showEditorRootTransition.setToValue(1.0);

                showEditorRootTransition.play();
                hideFileRootTransition.play();
                root.getChildren().remove(fileRoot);
            }
        });
        Button infoBtn = new Button("Medical centres");
        infoBtn.setPrefWidth(150);
        infoBtn.getStyleClass().add("custom-menu-button");
        Button newBtn = new Button("Map");
        newBtn.setPrefWidth(150);
        newBtn.getStyleClass().add("custom-menu-button");
        Button openBtn = new Button("Laboratories");
        openBtn.setPrefWidth(150);
        openBtn.getStyleClass().add("custom-menu-button");
        Button news= new Button("world health news");
        openBtn.setPrefWidth(150);
        news.getStyleClass().add("custom-menu-button");
        menu.getChildren().addAll(backBtn,infoBtn, newBtn, openBtn);
        VBox.setVgrow(infoBtn, Priority.ALWAYS);
        fileRoot.getChildren().add(menu);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().add(fileRoot);
                FadeTransition hideEditorRootTransition = new FadeTransition(Duration.millis(500), editorRoot);
                hideEditorRootTransition.setFromValue(1.0);
                hideEditorRootTransition.setToValue(0.0);

                FadeTransition showFileRootTransition = new FadeTransition(Duration.millis(500), fileRoot);
                showFileRootTransition.setFromValue(0.0);
                showFileRootTransition.setToValue(1.0);
                hideEditorRootTransition.play();
                showFileRootTransition.play();
            }
        });
        return new Scene(root,800,800);

    }





























    public static void main(String[] args) {
        launch(args);
    }

}