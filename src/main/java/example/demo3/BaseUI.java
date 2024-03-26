package example.demo3;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class BaseUI extends DataServiceManager implements UISetup{
    protected abstract void setupContent(Group root, Stage stage);
    @Override
    public void setupUI( Group root, Stage stage) {
        setupContent(root, stage);
    }
    protected abstract String getTitle();

}
