package example.demo3;

import javafx.scene.Group;
import javafx.stage.Stage;

public class LogOutButtonEvent implements EventHandler{
    private UserService userService;
    private Stage stage;
    public LogOutButtonEvent(UserService userService, Stage stage){
        this.stage = stage;
        this.userService = userService;
    }

    @Override
    public void handle() {
        stage.close();
        userService.setAktualnyPouzivatel(null);
        DataServiceManager.root = new Group();
        DataServiceManager.stage = new Stage();
        new LoginUI().setupUI(stage);
    }
}
