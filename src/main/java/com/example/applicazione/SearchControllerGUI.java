package com.example.applicazione;

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

    }

    @FXML
    void menuButtonClicked(ActionEvent event) throws IOException {
        //System.out.println("... showing menu ...");
        Stage stage = (Stage)menu.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("homeGUI.fxml"));
        primaryStage.setTitle("DIVERSWORLD");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

    @FXML
    void yourProfile(ActionEvent event) {

    }

}

