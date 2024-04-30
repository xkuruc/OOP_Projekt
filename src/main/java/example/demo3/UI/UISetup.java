package example.demo3.UI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * toto je rozhranie, ktore pouzivaju vsetky objekty reprezentujuce nejake pouzivatelske rozhranie
 * definuje nejake spolocne metody
 */
public interface UISetup {
    void setupUI(Stage stage);
    void stageSetup(Stage stage, int width, int height);

}
