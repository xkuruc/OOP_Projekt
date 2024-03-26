package example.demo3;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface UISetup {
    void setupUI(Group root,Stage stage);

    void stageSetup(Stage stage, Scene scene, int width, int height);

}
