package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

/**
 * Sluzi na vytvorenie Pridat obrazok Buttonu, ktory umozni pouzivatelovi nahrat vlastny obrazok
 * Po stlaceni sa vykona {@link example.demo3.events.OpenButtonEvent}
 */
public class OpenImageButtonFactory extends ButtonFactory{
    /**
     * Sluzi na vytvorenie Pridat obrazok Buttonu
     * Po stlaceni sa vykona {@link example.demo3.events.LogOutButtonEvent}
     * @param eventHandler to je {@link example.demo3.events.LogOutButtonEvent} ktory umozni pouzivatelovi pridat novy obrazok, oddeluje sa tak aplikacna logika od rozhrania
     * @return vrati sa dany button s danou funkcionalitou
     */
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
