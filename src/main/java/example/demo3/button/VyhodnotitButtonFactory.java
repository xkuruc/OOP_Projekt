package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;


/**
 * Sluzi na vytvorenie Vyhodnotit buttonu, ktory vyhodnoti vítaza (najlepsi obrazok )
 * <p>
 *     Za najlepsi obrazok sa povazuje ten co dosiahne najvacsi pocet hlasov
 *     </p>
 * Po stlaceni sa vykona {@link example.demo3.events.VyhodnotitEvent}
 */
public class VyhodnotitButtonFactory extends ButtonFactory{
    /**
     * Sluzi na vytvorenie Vyhodnotit Buttonu
     * Po stlaceni sa vykona {@link example.demo3.events.VyhodnotitEvent}
     * @param eventHandler to je {@link example.demo3.events.VyhodnotitEvent} ktory umozni zobrazenie najlepsieho obrazka v novom okne , oddeluje sa tak aplikacna logika od rozhrania
     * @return vrati sa dany button s danou funkcionalitou
     */
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
