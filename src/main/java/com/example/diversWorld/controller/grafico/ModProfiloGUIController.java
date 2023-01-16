package com.example.diversWorld.controller.grafico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModProfiloGUIController {

    @FXML
    private TextField bDate;

    @FXML
    private TextField lastname;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField licNumb;

    @FXML
    private Button menu;

    @FXML
    private TextField pass;

    @FXML
    private Button save;

    @FXML
    private Button search;

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
    void modBDate(ActionEvent event) {
        // think about
    }

    @FXML
    void modEmail(ActionEvent event) {
        // think about
    }

    @FXML
    void modLast(ActionEvent event) {
        // think about
    }

    @FXML
    void modLicNumb(ActionEvent event) {
        // think about
    }

    @FXML
    void modName(ActionEvent event) {
        // think about
    }

    @FXML
    void modPass(ActionEvent event) {
        // think about
    }


    @FXML
    void saveModifiche(ActionEvent event) {
        //think about
    }

    @FXML
    void searchButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage)search.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("searchGUI.fxml"));
        primaryStage.setTitle("DIVERSWORLD");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

}
