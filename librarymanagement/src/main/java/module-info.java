module com.example.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;
    requires mysql.connector.java;


    opens com.example.librarymanagement to javafx.fxml;
    exports com.example.librarymanagement;
}