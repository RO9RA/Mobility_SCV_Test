module com.example.mobility_scv {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.logging;


    opens com.example.mobility_scv to javafx.fxml;
    exports com.example.mobility_scv;
}