package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

public class OpenImageButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(EventHandler eventHandler){
        Button openButton = new Button(getTitle());
        openButton.setOnAction(e -> {
            eventHandler.handle();

        });
        root.getChildren().add(openButton);
        return openButton;
    }

    protected String getTitle() {
        return "Pridať obrázok";
    }
}
