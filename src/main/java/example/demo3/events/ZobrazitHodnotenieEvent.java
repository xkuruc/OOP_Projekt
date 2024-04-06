package example.demo3.events;

import example.demo3.UI.BaseUI;
import example.demo3.UI.ImageUI;
import example.demo3.UI.ZobrazitVyhodnotenieUI;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

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
    public int spocitajHodnotenie(ArrayList<Integer> hodnotenie){
        int vysledok = 0;
        for(Integer cislo : hodnotenie){
            vysledok += cislo;
        }
        return vysledok;
    }

    @Override
    public void handle() {
        ZobrazitVyhodnotenieUI zobrazitVyhodnotenieUI = new ZobrazitVyhodnotenieUI();
        zobrazitVyhodnotenieUI.setupUI(stage);
        for(ImageEntity image : imageService.returnObjectArray()){
            zobrazitVyhodnotenieUI.upravTextHodnoteniaObrazka(image, spocitajHodnotenie(image.getHodnotenie()));
        }
    }
}
