package example.demo3.UI;

import example.demo3.button.*;
import example.demo3.events.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Toto je classa, ktora reprezentuje hornu listu, kvoly umyslu oddelenia aplikacnej logiky od pouzovatelskeho rozhrania re oddelena definicia rozhrania a funkcionality danych buttonov
 * Ze buttony su vytvorene a definovane vo svojich vlastnych classach a ich funkcionalita je vytvorena v inych classach
 * Tato classa sluzi len ako miesto spojenia tychto elementov
 */
public class HornaLista extends BaseUI{
    /**
     * tento Vbox je vlastne ta horna lista
     */
    protected VBox vbox;
    /**
     * Tento hbox reprezuntuje miesto do ktoreho sa butony bude ukladat vedla seba
     */
    protected HBox hBox;
    protected ImageUI imageUI;

    public HornaLista( VBox vbox, ImageUI imageUI){
        this.vbox = vbox;
        this.hBox = new HBox();
        this.imageUI = imageUI;
    }
    /**
     * Tato metoda sluzi na pridanie tlacidiel a ich funkcionalit,
     * Je tu pouzita metoda {@link #setupFunkcie(VBox)}, ktora prida buttony a funkcionality, ktore su specificke pre daneho pouzivatela (napriklad moznost pridavat obrazky)
     * nasledujú definicie buttonov, ktore su rovnake pre vsetkych pouzivatelov (ako napriklad {@link VyhodnotitEvent}, {@link RandomVyhodnotenieEvent}, {@link  ZobrazitHodnotenieEvent})
     * @param stage reprezentuje okno, do ktoreho chceme vlozit tie buttony
     * @see VyhodnotitButtonFactory
     * @see RandomTestButtonFactory
     * @see ZobrazitVyhodnotenieButtonFactory
     */
    @Override
    protected void setupContent(Stage stage) {
        setupFunkcie(vbox);

        addButton(hBox, new VyhodnotitButtonFactory(), new VyhodnotitEvent(imageService, userService, stage));
        addButton(hBox, new RandomTestButtonFactory(), new RandomVyhodnotenieEvent(imageService, userService));
        addButton(hBox, new ZobrazitVyhodnotenieButtonFactory(), new ZobrazitHodnotenieEvent(imageService, userService, imageUI, stage));

        vbox.getChildren().add(hBox);
    }
    /**
     * Tato funckia sluzi na vytvorenie buttonu daneho typu a pridanie funkcionality specifikovanej vo argumente
     *
     * <p>
     *     Hlavne sluzi na zrozumitelne a jasne oddelenie aplikacnej logiky od pouzivatelskeho rozhrania
     *     Velmi efektivne sa tu vyuziva polymorfizmus a factory pattern, ktory nam umoznuje vytvorit nove Buttony hocijakeho typu, otvorene pre modifikaciu
     * </p>
     * @param hBox specifikuje hbox do ktoreho sa dane Buttony maju ulozit, vid {@link #hBox}
     * @param buttonFactory tu sa pouziva factory pattern na efektivne vyuzitie polymorfizmu na vytvorenie noveho buttona hocijakeho typu
     * @param eventHandler tu sa uplatnuje strategy pattern na pridanie pozadovanej funkcionality do Buttonu. Takto je to otvorene modifikaciam, oddeluje aplikacnu logiku od pouzivatelskeho rozhrania
     */
    protected void addButton(HBox hBox, ButtonFactory buttonFactory, EventHandler eventHandler) {
        Button button = buttonFactory.createButton(eventHandler);
        HBox.setMargin(button, new Insets(10, 10, 10, 10));
        hBox.getChildren().add(button);
    }

    /**
     * Toto je metoda na pridanie specifickych funkcionalitych pre rozne typy pouzivatelov
     * Buttony su pridavane pomocou {@link #addButton(HBox, ButtonFactory, EventHandler)} metody
     * <p>
     *     Tato metoda je prekonávana, napr vid {@link example.demo3.NewHornaLista} a je upravovana na specificke potreby pre typ uzivatela
     * </p>
     * @param vbox specifikuje vbox, do ktoreho maju byt pridane buttony
     */
    protected void setupFunkcie(VBox vbox){
        HBox hBox1 = new HBox();
        addButton(hBox1, new LogOutButtonFactory(), new LogOutButtonEvent(userService, imageService, stage));
        addButton(hBox1, new OpenImageButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        vbox.getChildren().add(hBox1);
    }


    /*@Override
    public void setupUI(Stage stage) {
        setupContent(stage);
    }*/

    @Override
    protected String getTitle() {
        return null;
    }
}
