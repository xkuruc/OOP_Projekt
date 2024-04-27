package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

public class VyhodnotitButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(EventHandler eventHandler){
        Button VyhonotitButton = new Button(getTitle());
        VyhonotitButton.setOnAction(e -> {
            eventHandler.handle();
        });
        root.getChildren().add(VyhonotitButton);
        return VyhonotitButton;
    }

    protected String getTitle() {
        return "Vyhodnotiť";
    }
}
