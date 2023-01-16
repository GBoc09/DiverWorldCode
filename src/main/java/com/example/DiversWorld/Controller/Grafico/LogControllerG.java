package com.example.DiversWorld.Controller.Grafico;

import com.example.DiversWorld.Bean.AccountRegistrationBean;
import com.example.DiversWorld.Bean.LogBean;
import com.example.DiversWorld.Bean.UserBean;
import com.example.DiversWorld.Controller.Applicativo.LogInControllerApplicativo;
import com.example.DiversWorld.Exceptions.AlreadyRegisteredUserException;
import com.example.DiversWorld.Exceptions.WrongLoginCredentialException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LogControllerG {

    private LogBean bean = new LogBean();
    /**
     * connessione con il controller applicativo del login
      */
    private LogInControllerApplicativo log = new LogInControllerApplicativo();
    private AccountRegistrationBean bean1 = new AccountRegistrationBean();

    @FXML
    private Button account;

    @FXML
    private Button facebook;
    @FXML
    private Label errorLabel;


    @FXML
    private ImageView google;

    @FXML
    private Button login;

    @FXML
    private Button menu;

    @FXML
    private Button search;
    @FXML
    private PasswordField textPass;

    @FXML
    private TextField textUser;


    @FXML
    void facebookButtonClicked(ActionEvent event) {
        // dummy
    }

    @FXML
    void googleButtonClicked(ActionEvent event) {
        // dummy
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage)account.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("accountGUI.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
        try {
            log.register(bean1);
        } catch (AlreadyRegisteredUserException e){

        }
    }

    @FXML
    void logButtonClicked(ActionEvent event) {
       bean.setUserID(textUser.getText());
       bean.setPassword(textPass.getText());
       try{
           log.login(bean);
           UserBean me = log.getUserByLoginData(bean);
           //bundle.addBean("loggedUser", me);

       }catch (WrongLoginCredentialException e1) {
       errorLabel.setText("Wrong credentials supplied, check your Email and Password!");
       };
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
        //@Override
        public void onExit(){
            textUser.setText("");
            textPass.setText("");
            errorLabel.setText("");

        }

}

