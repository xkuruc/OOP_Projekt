package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

public class ZobrazitVyhodnotenieButtonFactory extends ButtonFactory {
    @Override
    public Button createButton(EventHandler eventHandler){
        Button VyhodnotenieButton = new Button(getTitle());
        VyhodnotenieButton.setOnAction(e -> {
            eventHandler.handle();
        });
        root.getChildren().add(VyhodnotenieButton);
        return VyhodnotenieButton;
    }
    protected String getTitle() {
        return "Zobrazit Vyhodnotenie";
    }
}
