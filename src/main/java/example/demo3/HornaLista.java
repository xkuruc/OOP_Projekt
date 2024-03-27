package example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//problem je v tom kamo, že baseUI a hornaLista nemaju rovnaky vbox a scene,

public class HornaLista extends BaseUI{
    private VBox vbox;
    private Scene scene;
    public HornaLista(Scene scene, VBox vbox){
        this.vbox = vbox;
        this.scene = scene;
    }

    @Override
    protected void setupContent(Group root, Stage stage) {
        ButtonFactory openImageButtonFactory = new OpenImageButtonFactory();
        Button openButton = openImageButtonFactory.createButton();
        VBox.setMargin(openButton, new Insets(0, 10, 0, 10));
        vbox.getChildren().add(openButton);

        ButtonFactory logOutButtonFactory = new LogOutButtonFactory();
        Button logOutButton = logOutButtonFactory.createButton();
        VBox.setMargin(logOutButton, new Insets(0, 10, 0, 10));
        vbox.getChildren().add(logOutButton);
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
