package example.demo3;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogOutButtonFactory extends ButtonFactory {
    public Button createButton(EventHandler eventHandler) {
        Button logOutButton = new Button(getTitle());
        logOutButton.setOnAction(e -> {
            eventHandler.handle();
        });
        root.getChildren().add(logOutButton);
        return logOutButton;
    }
    //@Override
    protected String getTitle() {
        return "Log Out";
    }
}
