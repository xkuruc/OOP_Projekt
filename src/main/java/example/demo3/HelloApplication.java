package example.demo3;

import example.demo3.UI.LoginUI;
import example.demo3.events.DataServiceManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        DataServiceManager.root = root;
        DataServiceManager.stage = stage;
        new LoginUI().setupUI(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}