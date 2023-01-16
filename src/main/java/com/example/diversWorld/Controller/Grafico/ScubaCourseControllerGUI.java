package com.example.diversWorld.Controller.Grafico;

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

public class ScubaCourseControllerGUI {

    ObservableList<String> courseList = FXCollections.observableArrayList("Discover Scuba","Open Water", "Advanced", "Rescue", "Dive Master");
    @FXML
    private Button bag;

    @FXML
    private ChoiceBox<String> courseBox;

    @FXML
    private Button fins;

    @FXML
    private Button menu;

    @FXML
    private Button search;

    @FXML
    private Button user;

    @FXML
    private void initialize() {
        courseBox.setItems(courseList);
        courseBox.setValue("select level");
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
    void findCourse(ActionEvent event) {
        // think about
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
