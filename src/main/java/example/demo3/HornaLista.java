package example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//problem je v tom kamo, že baseUI a hornaLista nemaju rovnaky vbox a scene,

public class HornaLista extends BaseUI{
    private VBox vbox;
    private Scene scene;
    private HBox hBox;
    public HornaLista(Scene scene, VBox vbox){
        this.vbox = vbox;
        this.scene = scene;
        this.hBox = new HBox();
    }

    @Override
    protected void setupContent(Group root, Stage stage) {
        ButtonFactory openImageButtonFactory = new OpenImageButtonFactory();
        Button openButton = openImageButtonFactory.createButton();
        HBox.setMargin(openButton, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(openButton);

        ButtonFactory logOutButtonFactory = new LogOutButtonFactory();
        Button logOutButton = logOutButtonFactory.createButton();
        HBox.setMargin(logOutButton, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(logOutButton);

        ButtonFactory testButtonFactory = new TestButtonFactory();
        Button testButton = testButtonFactory.createButton();
        HBox.setMargin(testButton, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(testButton);

        ButtonFactory randomTestButtonFactory = new RandomTestButtonFactory();
        Button randomTestButton = randomTestButtonFactory.createButton();
        HBox.setMargin(randomTestButton, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(randomTestButton);

        ButtonFactory zobrazitVyhodnotenieButtonFactory = new ZobrazitVyhodnotenieButtonFactory();
        Button zobrazitVyhodnotenieButton = zobrazitVyhodnotenieButtonFactory.createButton();
        HBox.setMargin(zobrazitVyhodnotenieButton, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(zobrazitVyhodnotenieButton);

        vbox.getChildren().add(hBox);
    }

    @Override
    public void setupUI(Group root, Stage stage) {
        setupContent(root, stage);
    }

    @Override
    protected String getTitle() {
        return null;
    }
}
