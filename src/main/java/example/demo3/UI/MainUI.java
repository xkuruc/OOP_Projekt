package example.demo3.UI;

import example.demo3.NewHornaLista;
import example.demo3.events.DataServiceManager;
import example.demo3.events.ImageEntity;
import example.demo3.pouzivatelia.Amater;
import example.demo3.pouzivatelia.Novy;
import example.demo3.pouzivatelia.Profesional;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainUI extends DataServiceManager {
    private VBox vbox;
    private Scene scene;

    public MainUI(){
        this.vbox = new VBox();
        this.scene = new Scene(vbox, Color.GRAY);
    }
    public void MainUISetup(){
        Uzivatel uzivatel = userService.getAktualnyPouzivatel();
        ImageUI imageUI;
        BaseUI hornaLista;
        if(uzivatel instanceof Profesional){
            imageUI = new ProfesionalImageUI(vbox);
            hornaLista = new HornaLista(vbox, imageUI);
        } else if (uzivatel instanceof Amater) {
            imageUI = new AmaterImageUi(vbox);
            hornaLista = new HornaLista(vbox, imageUI);
        }else if(uzivatel instanceof Novy){
            imageUI = new AmaterImageUi(vbox);
            hornaLista = new NewHornaLista(vbox, imageUI);
        }else{
            imageUI = new AmaterImageUi(vbox);
            hornaLista = new NewHornaLista(vbox, imageUI);
        }

        imageUI.setupUI(stage);
        hornaLista.setupUI(stage);

        stage.setScene(scene);
        stage.show();
    }
}
