package example.demo3;

import example.demo3.events.DataServiceManager;
import javafx.stage.Stage;

public abstract class BaseUI extends DataServiceManager implements UISetup{
    protected abstract void setupContent(Stage stage);
    @Override
    public void setupUI(Stage stage) {
        setupContent(stage);
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
