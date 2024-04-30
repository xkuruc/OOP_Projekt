package example.demo3.button;

import example.demo3.events.DataServiceManager;
import example.demo3.events.EventHandler;
import javafx.scene.control.Button;
/**
 * Toto je abstraktna clasa, ktora sluzi na Abstract Factory pattern, na efektivne vytvaranie novych Buttonov
 * Zarucuje to otvorenost systemu pre modifikacie
 */
public abstract class ButtonFactory extends DataServiceManager {
    public abstract Button createButton(EventHandler eventHandler);
}
