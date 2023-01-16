package com.example.diversWorld.Controller.Grafico;

import com.example.diversWorld.Bean.AccountRegistrationBean;
import com.example.diversWorld.Controller.Applicativo.LogInControllerApplicativo;
import com.example.diversWorld.Exceptions.AlreadyRegisteredUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.ZoneId;

import static java.util.Date.from;

public class AccountControllerG {

    @FXML
    private DatePicker dateBirth;
    @FXML
    private TextField email;
    @FXML
    private TextField license;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField pass1;

    @FXML
    private TextField lastname;
    @FXML
    private Button bag;
    @FXML
    private Button menu;
    @FXML
    private Button search;
    @FXML
    private Button signIn;
    @FXML
    private Label errorLabel;

   LogInControllerApplicativo regController = new LogInControllerApplicativo();
    @FXML
    private Boolean verfyInsert(AccountRegistrationBean rBean) {
        if (Boolean.TRUE.equals(checkEmpty())){
            errorLabel.setText("Insert all fields");
            return false;
        }
        if (dateBirth.getValue() == null) {
            errorLabel.setText("Insert a birth date");
            return false;
        }
        if (!pass.getText().equals(pass1.getText())){
            errorLabel.setText("Password field must be the same");
            return false;
        }
        if(Boolean.FALSE.equals(rBean.validateName(name.getText()))) {
            errorLabel.setText("insert a correct name");
            return false;
        }else {
            rBean.setName(name.getText());
        }
        if(Boolean.FALSE.equals(rBean.validateLastname(lastname.getText()))){
            errorLabel.setText("Insert a correct lastname");
            return false;
        } else {
            rBean.setLastname(lastname.getText());
        }
        if(Boolean.FALSE.equals(rBean.validateEmail(email.getText()))){
            errorLabel.setText("Insert a correct email");
            return false;
        } else {
            rBean.setEmail(email.getText());
        }
        if(Boolean.FALSE.equals(rBean.validatePassword(pass.getText()))){
            errorLabel.setText("Insert a correct password [8-16 chars, containing numbers, letters and a " +
                    "special characters]");
            return false;
        } else {
            rBean.setPassword(pass.getText());
        }
        Date data = (Date) from(dateBirth.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        rBean.setBirthDate(data);

        return true;
    }
    public Boolean checkEmpty(){
        TextField[] arrayOFNodes = {name, lastname, email, pass, pass1};
        for(TextField field: arrayOFNodes) {
            if(field.getText().equals("")){
                return true;
            }
        }
        return false;
    }
    //@Override
    public void onExit(){
        errorLabel.setText("");
    }

    void signInButtonClicked(ActionEvent event) throws IOException, AlreadyRegisteredUserException {
        AccountRegistrationBean rBean = new AccountRegistrationBean();
        if (Boolean.FALSE.equals(verfyInsert(rBean))){
            return;
        }
        regController.register(rBean);
        Stage stage = (Stage)bag.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("HomeGUI.fxml"));
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
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

}
