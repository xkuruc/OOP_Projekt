package example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import javafx.scene.control.ScrollPane;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;


//inak pravdepodobne viem dať zobraziť aj nejaký gif kamo
//tam možem skúsiť žeby som zobrazil nejaký gif namiesto obraska


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        DataServiceManager dataServiceManager = new DataServiceManager();
        new ImageUI().setupUI(root,stage);
        new OpenImageUI().setupUI(root,stage);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}