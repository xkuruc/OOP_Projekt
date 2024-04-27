package example.demo3.UI;

import example.demo3.button.*;
import example.demo3.events.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//problem je v tom kamo, že baseUI a hornaLista nemaju rovnaky vbox a scene,

public class HornaLista extends BaseUI{
    protected VBox vbox;
    protected HBox hBox;
    protected ImageUI imageUI;

    public HornaLista( VBox vbox, ImageUI imageUI){
        this.vbox = vbox;
        this.hBox = new HBox();
        this.imageUI = imageUI;
    }

    @Override
    protected void setupContent(Stage stage) {
        setupFunkcie(vbox);

        addButton(hBox, new TestButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        addButton(hBox, new RandomTestButtonFactory(), new RandomVyhodnotenieEvent(imageService, userService));
        addButton(hBox, new ZobrazitVyhodnotenieButtonFactory(), new ZobrazitHodnotenieEvent(imageService, userService, imageUI, stage));

        vbox.getChildren().add(hBox);
    }
    protected void addButton(HBox hBox, ButtonFactory buttonFactory, EventHandler eventHandler) {
        Button button = buttonFactory.createButton(eventHandler);
        HBox.setMargin(button, new Insets(10, 10, 10, 10));
        hBox.getChildren().add(button);
    }
    protected void setupFunkcie(VBox vbox){
        HBox hBox1 = new HBox();
        addButton(hBox1, new LogOutButtonFactory(), new LogOutButtonEvent(userService, imageService, stage));
        addButton(hBox1, new OpenImageButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        vbox.getChildren().add(hBox1);
    }


    /*@Override
    public void setupUI(Stage stage) {
        setupContent(stage);
    }*/

    @Override
    protected String getTitle() {
        return null;
    }
}
