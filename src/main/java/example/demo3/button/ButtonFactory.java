package example.demo3.button;

import example.demo3.events.DataServiceManager;
import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

public abstract class ButtonFactory extends DataServiceManager {
    public abstract Button createButton(EventHandler eventHandler);
}
