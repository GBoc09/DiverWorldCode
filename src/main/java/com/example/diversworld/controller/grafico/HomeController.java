package com.example.diversworld.controller.grafico;

import com.example.diversworld.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button bag;

    @FXML
    private Button free;

    @FXML
    private Button menu;

    @FXML
    private Button scuba;

    @FXML
    private Button search;

    @FXML
    private Button user;

   private UserBean loggedUser = null;
   private String loginPage = "logGUI.fxml";
   private String title = "You have to login!";
    @FXML
    void bagButtonClicked(ActionEvent event) throws IOException {
        if (loggedUser == null) {
            Stage stage = (Stage)bag.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(loginPage));
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }

    }

    @FXML
    void freeDiButtonClicked(ActionEvent event) throws IOException {
        if (loggedUser == null) {
            Stage stage = (Stage)free.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(loginPage));
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        } else {
            Stage stage = (Stage)free.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("freeGUI.fxml"));
            primaryStage.setTitle("Free Divers");
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }

    }

    @FXML
    void menuButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage)menu.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("homeGUI.fxml"));
        primaryStage.setTitle("Divers World");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

    @FXML
    void scubaButtonClicked(ActionEvent event) throws IOException {
        if (loggedUser == null) {
            Stage stage = (Stage)scuba.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(loginPage));
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }else{
            Stage stage = (Stage)scuba.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("scubaGUI.fxml"));
            primaryStage.setTitle("Scuba Divers");
            primaryStage.setScene(new Scene(root, 600, 333));
            primaryStage.show();
        }

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
    void userButtonClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage)user.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(loginPage));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

}
