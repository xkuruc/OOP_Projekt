module example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.demo3 to javafx.fxml;
    exports example.demo3;
    exports example.demo3.button;
    opens example.demo3.button to javafx.fxml;
    exports example.demo3.events;
    opens example.demo3.events to javafx.fxml;
    exports example.demo3.pouzivatelia;
    opens example.demo3.pouzivatelia to javafx.fxml;
}