module com.dilan.colorearimg {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.base;
    requires java.sql;
    requires java.se;
    requires java.desktop;
    requires java.instrument;
    opens com.dilan.colorearimagenes to javafx.fxml;
    opens com.dilan.controller to javafx.fxml;
    opens com.dilan.util to javafx.fxml;
    exports com.dilan.colorearimagenes;
    exports com.dilan.controller;
    exports com.dilan.util;
}