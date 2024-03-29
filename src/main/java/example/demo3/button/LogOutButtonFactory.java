package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

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
