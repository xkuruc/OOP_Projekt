package example.demo3.events;

import example.demo3.UI.LoginUI;
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
        new LoginUI().setupUI(DataServiceManager.stage);
    }
}
