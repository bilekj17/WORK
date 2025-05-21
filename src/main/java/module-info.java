module com.example.praxe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.praxe to javafx.fxml;
    exports com.example.praxe;
}