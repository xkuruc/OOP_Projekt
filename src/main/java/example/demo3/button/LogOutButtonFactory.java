package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

/**
 * Sluzi na vytvorenie Log out Buttonu
 * Po stlaceni sa vykona {@link example.demo3.events.LogOutButtonEvent}
 */
public class LogOutButtonFactory extends ButtonFactory {
    /**
     * Na vytvorenie obrazku a pridanie funkcionality
     * Po stlaceni sa vykona {@link example.demo3.events.LogOutButtonEvent}
     * @param eventHandler to je {@link example.demo3.events.LogOutButtonEvent}, ktory umozni pouzivatelovi sa odhlasit, a nalsedne sa prihlasit noveho pouzivatela
     * @return vraci sa dany vytvoreny button s danou funkcionalitou
     *                     Zabezpecuje sa tak oddelenie aplikacnej logiky od pouzivatelskeho rozhrania
     */
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
