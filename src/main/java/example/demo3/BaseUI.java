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

    @Override
    public void stageSetup(Stage stage, int width, int height){
        stage.setTitle(getTitle());
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setResizable(false);

    }

    protected abstract String getTitle();

}
