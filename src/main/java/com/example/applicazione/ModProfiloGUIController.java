package com.example.applicazione;

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
    private TextField BDate;

    @FXML
    private TextField Lastname;

    @FXML
    private TextField Name;

    @FXML
    private TextField Username;

    @FXML
    private TextField email;

    @FXML
    private TextField licNumb;

    @FXML
    private Button menu;

    @FXML
    private Button modPic;

    @FXML
    private TextField pass;

    @FXML
    private Button save;

    @FXML
    private Button search;

    @FXML
    void menuButtonClicked(ActionEvent event) throws IOException {
        System.out.println("... showing menu ...");
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

    }

    @FXML
    void modEmail(ActionEvent event) {

    }

    @FXML
    void modLast(ActionEvent event) {

    }

    @FXML
    void modLicNumb(ActionEvent event) {

    }

    @FXML
    void modName(ActionEvent event) {

    }

    @FXML
    void modPass(ActionEvent event) {

    }

    @FXML
    void modPic(ActionEvent event) {

    }

    @FXML
    void modUsername(ActionEvent event) {

    }

    @FXML
    void saveModifiche(ActionEvent event) {

    }

    @FXML
    void searchButtonClicked(ActionEvent event) {

    }

}
