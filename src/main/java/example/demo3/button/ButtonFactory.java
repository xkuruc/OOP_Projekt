package example.demo3;

import javafx.scene.control.Button;

public abstract class ButtonFactory extends DataServiceManager{
    public abstract Button createButton(EventHandler eventHandler);
}
