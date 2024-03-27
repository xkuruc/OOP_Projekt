package example.demo3;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogOutButtonFactory extends ButtonFactory {
    public Button createButton() {
        Button logOutButton = new Button(getTitle());
        logOutButton.setOnAction(e -> {
            LogOut();
        });
        root.getChildren().add(logOutButton);
        return logOutButton;
    }
    private void LogOut(){
        stage.close();
        userService.setAktualnyPouzivatel(null);
        DataServiceManager.root = new Group();
        DataServiceManager.stage = new Stage();
        //DataServiceManager.imageService = new ImageService();
        //DataServiceManager.userService = new UserService();
        new LoginUI().setupUI(root, stage);
    }
    //@Override
    protected String getTitle() {
        return "Log Out";
    }
}
