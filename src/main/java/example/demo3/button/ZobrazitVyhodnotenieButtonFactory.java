package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

/**
 * Sluzi na vytvorenie Zobrazit Vyhodnotit buttonu, ktory zobrazi aktualne ohodnotenie vsetkych obrazkov
 * Po stlaceni sa vykona {@link example.demo3.events.ZobrazitHodnotenieEvent}
 */
public class ZobrazitVyhodnotenieButtonFactory extends ButtonFactory {
    /**
     * Sluzi na vytvorenie Zobrazit Vyhodnotit Buttonu
     * Po stlaceni sa vykona {@link example.demo3.events.ZobrazitHodnotenieEvent}
     * @param eventHandler to je {@link example.demo3.events.ZobrazitHodnotenieEvent} ktory umozni zobrazenie aktualneho ohodnotenia vsetkych obrazkov, oddeluje sa tak aplikacna logika od rozhrania
     * @return vrati sa dany button s danou funkcionalitou
     */
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
