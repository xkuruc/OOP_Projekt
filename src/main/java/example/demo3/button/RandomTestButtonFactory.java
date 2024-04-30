package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

/**
 * Sluzi na vytvorenie Random vyhodnotenie Buttonu, ktory odsimuluje hlasovanie vsetkych uzivatelov a to naraz
 * Po stlaceni sa vykona {@link example.demo3.events.RandomVyhodnotenieEvent}
 */
public class RandomTestButtonFactory extends ButtonFactory{
    /**
     * Sluzi na vytvorenie Random vyhodnotenie Buttonu
     * Po stlaceni sa vykona {@link example.demo3.events.RandomVyhodnotenieEvent}
     * @param eventHandler to je {@link example.demo3.events.RandomVyhodnotenieEvent} ktory umozni odsimulovanie volieb, oddeluje sa tak aplikacna logika od rozhrania
     * @return vrati sa dany button s danou funkcionalitou
     */
    @Override
    public Button createButton(EventHandler eventHandler){
        Button RandomTestButton = new Button(getTitle());
        RandomTestButton.setOnAction(e -> {
            eventHandler.handle();
        });
        root.getChildren().add(RandomTestButton);
        return RandomTestButton;
    }
    private void RandomVyhodnotit(){

    }
    protected String getTitle() {
        return "Random Vyhodnotenie";
    }
}
