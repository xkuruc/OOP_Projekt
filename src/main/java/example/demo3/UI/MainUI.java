package example.demo3.UI;

import example.demo3.events.DataServiceManager;
import example.demo3.events.ImageEntity;
import example.demo3.pouzivatelia.Amater;
import example.demo3.pouzivatelia.Profesional;
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
        //ImageUI imageUI = new ImageUI(vbox);
        //ImageUI imageUI = new ProfesionalImageUI(vbox);
        ImageUI imageUI;
        if(userService.getAktualnyPouzivatel() instanceof Profesional){
            imageUI = new ProfesionalImageUI(vbox);
        } else if (userService.getAktualnyPouzivatel() instanceof Amater) {
            imageUI = new AmaterImageUi(vbox);
        }else {
            imageUI = new AmaterImageUi(vbox);
        }
        imageUI.setupUI(stage);

        BaseUI hornaLista = new HornaLista(vbox, imageUI);
        hornaLista.setupUI(stage);

        stage.setScene(scene);
        stage.show();
    }
}
