module com.example.DiversWorld {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.diversWorld to javafx.fxml;
    exports com.example.diversWorld;
}