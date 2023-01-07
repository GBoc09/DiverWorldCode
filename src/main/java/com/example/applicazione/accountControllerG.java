package com.example.applicazione;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class accountControllerG {

    @FXML
    private TextField dateBirth;
    @FXML
    private TextField email;
    @FXML
    private TextField license;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField surname;
    @FXML
    private Button bag;
    @FXML
    private Button menu;
    @FXML
    private Button search;
    @FXML
    private Button signIn;

    @FXML
    void SingInButtonClicked(ActionEvent event) {
        /** gli utenti scrivono i loro dati all'interno delle label del form per la registrazione, cliccando su SIGN IN
         per inviare il form, si attiva una procedura all'interno della bean del log in che verifica la correttezza
         dei dati inseriti, se la verifica va a buon fine viene stampato a schermo il messaggio WELCOME ..., altrimenti
         viene ricaricata la pagina del form e con un messaggio (LA PROCEDURA DI ISCRIZIONE NON è ANDATA A BUON FINE
         PREGO INSERIRE NUOVAMENTE I DATI) */
        String nome = name.getText();
        String cognome = surname.getText();
        String data = dateBirth.getText();
        String brevetto = license.getText();
        String mail = email.getText();
        String pass  = pass.getText();

        /**
         * VERIFICA CORRETTEZZA NOME E COGNOME*/
        Integer check= 0;
        boolean ret = false;
        if(nome.matches("^[\\w]+$") && cognome.matches("^[\\w]+$")) {
            check = 0;
        } else {
            check += check;
        }
        if (check == 1) {
            System.out.println("Invalid");
            name.setText("");
            surname.setText("");
        } else {
            ret = true;
            System.out.println("Valid name and surname");
        }
        /**
         * VERIFICA CORRETTEZZA EMAIL
         */
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        ret = mail.matches(emailRegex);
        if (ret == false) {
            email.setText("");
            System.out.println("Invalid email address");
        }
        /**
         * VERIFICA CORRETTEZZA FORMATO DELLA DATA DI NASCITA
         *                                  !!bisogna aggiungere la correttezza dei giorni e dei mesi!!
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        try {
            formatter.parse(data);
            System.out.println("Valid date");
        } catch (Exception e) {
            System.out.println("Invalid date");
            dateBirth.setText("");
        }
        /**
         * VERIFICA CORRETTEZZA CHE IL NUMERO DI BREVETTO CONTENCA SOLO NUMERI
         */
        if(brevetto.matches("[0-9]+")) {
            System.out.println("License number is correct");
        }else {
            license.setText("");
            System.out.println("License number is incorrect");
        }


    }


    @FXML
    void bagButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Your Cart");
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
    void searchButtonClicked(ActionEvent event) throws IOException {
        System.out.println("... research page ...");
        Stage stage = (Stage)search.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("searchGUI.fxml"));
        primaryStage.setTitle("Research page");
        primaryStage.setScene(new Scene(root, 600, 333));
        primaryStage.show();
    }

}
