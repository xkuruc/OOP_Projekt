package example.demo3.UI;

import example.demo3.button.*;
import example.demo3.events.EventHandler;
import example.demo3.events.LogOutButtonEvent;
import example.demo3.events.OpenButtonEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//problem je v tom kamo, že baseUI a hornaLista nemaju rovnaky vbox a scene,

public class HornaLista extends BaseUI{
    private VBox vbox;
    private HBox hBox;
    private ImageUI imageUI;

    public HornaLista( VBox vbox, ImageUI imageUI){
        this.vbox = vbox;
        this.hBox = new HBox();
        this.imageUI = imageUI;
    }

    @Override
    protected void setupContent(Stage stage) {
        addButton(new OpenImageButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        addButton(new LogOutButtonFactory(), new LogOutButtonEvent(userService, stage));
        addButton(new TestButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        addButton(new RandomTestButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));
        addButton(new ZobrazitVyhodnotenieButtonFactory(), new OpenButtonEvent(imageService, userService, imageUI, stage));

        vbox.getChildren().add(hBox);
    }
    private void addButton(ButtonFactory buttonFactory, EventHandler eventHandler) {
        Button button = buttonFactory.createButton(eventHandler);
        HBox.setMargin(button, new Insets(0, 10, 0, 10));
        hBox.getChildren().add(button);
    }


    public void handle() {

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
