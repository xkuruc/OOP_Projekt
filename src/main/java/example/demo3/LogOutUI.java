package example.demo3;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogOutUI extends BaseUI implements UISetup{
    protected void setupContent(Group root, Stage stage) {
        Button openButton = new Button(getTitle());
        openButton.setOnAction(e -> {
            LogOut(stage);
        });
        root.getChildren().add(openButton);
    }
    private void LogOut(Stage stage){
        userService.setAktualnyPouzivatel(null);
        stage.close();
        Stage newStage = new Stage();
        Group newRoot = new Group();
        new LoginUI().setupUI(newRoot, newStage);
        newStage.show();
    }
    @Override
    protected String getTitle() {
        return "Log Out";
    }
}
