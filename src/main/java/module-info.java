module com.example.applicazione {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.applicazione to javafx.fxml;
    exports com.example.applicazione;
}