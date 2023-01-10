package com.example.DiversWorld.Controller.Grafico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RentControllerGUI {
    ObservableList<String> equipList = FXCollections.observableArrayList("GAV", "Regulator", "Mask", "Finns", "Weight", "Suit");
        @FXML
        private Button bag;

        @FXML
        private Button cerca;

        @FXML
        private Button menu;

        @FXML
        private Button search;

        @FXML
        private Button user;
        @FXML
        private ChoiceBox<String> equipBox;

        @FXML
        private void initialize() {
            equipBox.setItems(equipList);
            equipBox.setValue("select types");
        }
        @FXML
        void dbRent(ActionEvent event) {
            // think about
        }

        @FXML
        void bagButtonClicked(ActionEvent event) throws IOException {
            Stage stage = (Stage)bag.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("cartGUI.fxml"));
            primaryStage.setTitle("What's on your cart?");
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
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
        void searchButtonClicked(ActionEvent event) throws IOException {
            Stage stage = (Stage)search.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("searchGUI.fxml"));
            primaryStage.setTitle("Research page");
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }

        @FXML
        void yourProfile(ActionEvent event) throws IOException {
            Stage stage = (Stage)user.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("youGUI.fxml"));
            primaryStage.setTitle("About You");
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }

}

