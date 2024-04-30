package example.demo3;

import example.demo3.UI.HornaLista;
import example.demo3.UI.ImageUI;
import example.demo3.button.*;
import example.demo3.events.LogOutButtonEvent;
import example.demo3.events.OpenButtonEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * toto je classa reprezentujuca hornu listu pre pouzivatela typu "Novy",
 * Je prisposobena jeho privilegiam a dostupnym funkcionalitam 
 * metoda {@link #setupFunkcie(VBox)} prekonava metodu vo {@link HornaLista#setupFunkcie(VBox)}
 */
public class NewHornaLista extends HornaLista {
    public NewHornaLista(VBox vbox, ImageUI imageUI) {
        super(vbox, imageUI);
    }
    protected void setupFunkcie(VBox vbox){
        HBox hBox1 = new HBox();
        addButton(hBox1, new LogOutButtonFactory(), new LogOutButtonEvent(userService, imageService, stage));
        vbox.getChildren().add(hBox1);
    }

}
