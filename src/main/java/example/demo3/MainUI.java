package example.demo3;

import example.demo3.events.DataServiceManager;
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
        ImageUI imageUI = new ImageUI(vbox);
        imageUI.setupUI(stage);

        BaseUI hornaLista = new HornaLista(vbox, imageUI);
        hornaLista.setupUI(stage);

        stage.setScene(scene);
        stage.show();
    }
}
