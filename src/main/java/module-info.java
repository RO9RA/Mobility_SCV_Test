module com.example.mobility_scv {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.mobility_scv to javafx.fxml;
    exports com.example.mobility_scv;
}