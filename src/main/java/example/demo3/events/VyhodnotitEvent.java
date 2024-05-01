package example.demo3.events;

import example.demo3.UI.ImageUI;
import example.demo3.UI.VyhercaUI;
import example.demo3.button.VyhodnotitButtonFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Metoda pre {@link  VyhodnotitButtonFactory}
 * Sluzi na vyhodnotenie vyhercu
 * Sluzi aj na oddelenie aplikacnej logiky od uzivatelskeho rozhrania, a to tak ze na tomto mieste urci vyhercu, a potom vytvori objekt, ktory vytvori nove okno a vyhercu tam posle jak argument
 */
public class VyhodnotitEvent implements EventHandler{
    private ImageService imageService;
    private UserService userService;
    private ImageEntity vyherca;
    private int vyhercaPocetBodov;
    //private ZobrazitVyhodnotenieUI zobrazitVyhodnotenieUI;
    Stage stage;
    public VyhodnotitEvent(ImageService imageService, UserService userService, Stage stage){
        this.imageService = imageService;
        this.userService = userService;
        this.stage = stage;
    }
    /**
     * Spocita vyslednu hodnotu vsetkych hodnoteni pre dany obrazok
     * @param hodnotenie to je ArrayList hodnot, ktore reprezentuju hodnotenia uzivatelov pre dany obrazok, kazdy {@link ImageEntity} ma taky atribut
     * @return vracia vyslednu hodnotu hodnoteni
     */
    private int spocitajHodnotenie(ArrayList<Integer> hodnotenie){
        /*int vysledok = 0;
        for(Integer cislo : hodnotenie){
            vysledok += cislo;
        }
        return vysledok;*/
        return hodnotenie.stream().mapToInt((Integer i) -> i.intValue()).sum(); // toto je lambda expression, co robi uplne to iste jak hore nad tymto
                                                                                // ten stream sa použiva na operacie filter, map, reduce, sort ....
        //ono by to bolo to iste jak
        // return hodnotenie.stream().mapToInt(Integer::intValue).sum();        // a to uz je method reference
    }
    /**
     * Vyhodnoti vyhercu, vyherny obrázok a ten vrati
     * <p>
     *     pre kazdy obrazok zavola {@link #spocitajHodnotenie(ArrayList)} a urci vyhercu podla najvacsieho hodnotenia
     * </p>
     * @return vracia vyherny obrazok
     */
    private ImageEntity vyhodnotVyhercu(){
        int max = 0;
        ImageEntity vyherca = imageService.returnObjectArray().get(0);
        for(ImageEntity image : imageService.returnObjectArray()){
            int cislo = spocitajHodnotenie(image.getHodnotenie());
            if(cislo>max){
                max = cislo;
                vyherca = image;
            }
        }
        this.vyherca = vyherca;
        this.vyhercaPocetBodov = max;
        return vyherca;
    }

    /**
     * Metoda na vytvorenie noveho okna, kde bude zobrazeny vyherny obrazok (obrazok s najvacsim poctom hlasov)
     * Kvoly zameru oddelenia aplikacnej logiky od pouzivatelskeho rozhrania je vyherca vypocitany inde, a pouzivatelskeho rozhranie je vytvorene inde
     * Vytvori {@link VyhercaUI} objekt a vyhercu posle ako argument
     *
     */
    @Override
    public void handle() {
        new VyhercaUI(vyhodnotVyhercu(), this.vyhercaPocetBodov).setupUI(stage);
    }


}
