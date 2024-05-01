package example.demo3.events;

import example.demo3.UI.BaseUI;
import example.demo3.UI.ImageUI;
import example.demo3.UI.ZobrazitVyhodnotenieUI;
import example.demo3.button.VyhodnotitButtonFactory;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Metoda pre {@link  example.demo3.button.ZobrazitVyhodnotenieButtonFactory}
 * Sluzi aj na oddelenie aplikacnej logiky od pouzivatelskeho rozhrania
 * <p>
 *     Sluzi na zobrazenie aktualnych vysledkov hlasovania,
 *     Vytvori nove okno, kde sa zobrazia vsetky obrazky a ich autory, s ich aktualnym hlasovanim
 *     </p>
 */
public class ZobrazitHodnotenieEvent  implements EventHandler{
    private ImageUI imageUI;
    private ImageService imageService;
    private UserService userService;
    //private ZobrazitVyhodnotenieUI zobrazitVyhodnotenieUI;
    Stage stage;
    public ZobrazitHodnotenieEvent(ImageService imageService, UserService userService, ImageUI imageUI, Stage stage){
        this.imageService = imageService;
        this.userService = userService;
        this.imageUI = imageUI;
        //this.zobrazitVyhodnotenieUI = new ZobrazitVyhodnotenieUI();
        this.stage = stage;
    }
    //preto som to spravil takto aby som oddelil aplikacnu logiku od rozhrania
    //aby logika nebola zavisla na rozhrani
    /**
     * Spocita aktualne hodnotenie daneho obrazka, a to vrati
     * @param hodnotenie to je ArrayList, ktory obsahuje vsetky hodnotenia pre dany obrazok, kazdy {@link ImageEntity} tym disponuje
     */
    public int spocitajHodnotenie(ArrayList<Integer> hodnotenie){
        int vysledok = 0;
        for(Integer cislo : hodnotenie){
            vysledok += cislo;
        }
        return vysledok;
    }
    /**
     * Tato metoda vytvori nove okno kde sa zorazia vsetky obrazky s ich hodnotenim
     * <p>
     *     Kvoly umyslu oddelenia aplikacnej logiky od pouzivatelskeho rozhrania je nove okno vytvorene na inom mieste a hodnotenie je spocitane inde
     *     Vysldne hodnotenie je do UI vlozene cez metodu {@link ZobrazitVyhodnotenieUI#upravTextHodnoteniaObrazka(ImageEntity, int)} cim sa zaruci oddelenie aplikacnej logiky
     * </p>
     */
    @Override
    public void handle() {
        ZobrazitVyhodnotenieUI zobrazitVyhodnotenieUI = new ZobrazitVyhodnotenieUI();
        zobrazitVyhodnotenieUI.setupUI(stage);
        for(ImageEntity image : imageService.returnObjectArray()){
            zobrazitVyhodnotenieUI.upravTextHodnoteniaObrazka(image, spocitajHodnotenie(image.getHodnotenie()));
        }
    }
}
