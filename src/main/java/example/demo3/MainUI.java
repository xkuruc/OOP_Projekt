package example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainUI {
    private VBox vbox;
    private Scene scene;
    private Stage Stage;
    private Group Root;
    public MainUI(){
        this.vbox = new VBox();
        this.scene = new Scene(vbox, Color.GRAY);
        this.Stage = new Stage();
        this.Root =  new Group();
    }
    public void MainUISetup(){
        BaseUI hornaLista = new HornaLista(scene, vbox);
        hornaLista.setupUI(this.Root, this.Stage);

        BaseUI imageUI = new ImageUI(scene, vbox);
        imageUI.setupUI(this.Root, this.Stage);

        Stage.setScene(scene);
        Stage.show();
    }
}
