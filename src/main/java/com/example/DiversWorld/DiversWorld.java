package com.example.DiversWorld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DiversWorld extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DiversWorld.class.getResource("homeGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 333);
        stage.setTitle("DIVERS WORLD!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}