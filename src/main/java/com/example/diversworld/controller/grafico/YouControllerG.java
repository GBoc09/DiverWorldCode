package com.example.diversworld.controller.grafico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class YouControllerG {

    @FXML
    private Button bag;

    @FXML
    private Button menu;

    @FXML
    private Button search;

    @FXML
    private Button settings;
    @FXML
    private Button logOut;

    @FXML
    void logout(ActionEvent event) {
        // thinking about
    }

    @FXML
    void bagButtonClicked(ActionEvent event) {
        // devo pensare ancora a come svolgerlo
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
    void modifyProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage)search.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("modifyProfilo.fxml"));
        primaryStage.setTitle("Modify");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

    @FXML
    void searchButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage)search.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("searchGUI.fxml"));
        primaryStage.setTitle("Research page");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

}
