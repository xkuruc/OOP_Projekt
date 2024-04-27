package example.demo3.events;

import example.demo3.UI.ImageUI;
import example.demo3.UI.VyhercaUI;
import example.demo3.button.VyhodnotitButtonFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

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
    private int spocitajHodnotenie(ArrayList<Integer> hodnotenie){
        int vysledok = 0;
        for(Integer cislo : hodnotenie){
            vysledok += cislo;
        }
        return vysledok;
    }
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

    @Override
    public void handle() {
        new VyhercaUI(vyhodnotVyhercu(), this.vyhercaPocetBodov).setupUI(stage);
    }


}
