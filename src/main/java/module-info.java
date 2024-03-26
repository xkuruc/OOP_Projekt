module example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.demo3 to javafx.fxml;
    exports example.demo3;
}