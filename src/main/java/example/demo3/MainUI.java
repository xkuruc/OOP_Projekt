package example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainUI extends DataServiceManager{
    private VBox vbox;
    private Scene scene;
    //private Stage Stage;
    //private Group Root;
    public MainUI(){
        this.vbox = new VBox();
        this.scene = new Scene(vbox, Color.GRAY);
        //this.Stage = new Stage();
        //this.Root =  new Group();
    }
    public void MainUISetup(){
        BaseUI hornaLista = new HornaLista(scene, vbox);
        hornaLista.setupUI(root, stage);

        BaseUI imageUI = new ImageUI(scene, vbox);
        imageUI.setupUI(root, stage);

        stage.setScene(scene);
        stage.show();
    }
}
