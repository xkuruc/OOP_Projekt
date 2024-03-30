package example.demo3.UI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface UISetup {
    void setupUI(Stage stage);

    void stageSetup(Stage stage, int width, int height);

}
