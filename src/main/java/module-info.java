module com.example.applicazione {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.applicazione to javafx.fxml;
    exports com.example.applicazione;
}