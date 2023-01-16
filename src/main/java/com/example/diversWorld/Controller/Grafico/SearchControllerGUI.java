package com.example.diversWorld.Controller.Grafico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchControllerGUI {

    @FXML
    private Button go;

    @FXML
    private Button menu;

    @FXML
    private Button user;

    @FXML
    void go(ActionEvent event) {
        // devo pensare
    }

    @FXML
    void menuButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage)menu.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("homeGUI.fxml"));
        primaryStage.setTitle("DIVERSWORLD");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

    @FXML
    void yourProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage)user.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("youGUI.fxml"));
        primaryStage.setTitle("About You!");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

}

