package example.demo3.UI;

import example.demo3.events.EventHandler;
import example.demo3.events.ImageEntity;
import example.demo3.pouzivatelia.Profesional;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Paths;

//dobre kamo, ono sa toto vie vsetko extrahovat asi do IMAGEUI
//Ze create hodnotenie, a pri novom iba prepises tu funkciu ze nic no
//aj by som mohol spravit ze createHodnotenie
    // a to by sa skladalo zo creae normalne hodnotenie a profresionalImageUI by si tam pridaj aj rovno ze create superHodnotenie
//chapes ne
public class AmaterImageUi extends ImageUI{

    public AmaterImageUi(VBox vBox){super(vBox);}
    public void setupContent(Stage stage) {
        stageSetup(stage, 800, 800);
        setScrollPane(createScrollPane(800, 800));

        for (ImageEntity imageEntity : imageService.returnObjectArray() ) {
            //URL imageUrl = getClass().getResource("./obrasky/" + imageEntity.getUrl());
            String imageUrl = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
                    + "/example/demo3/obrasky", imageEntity.getUrl()).toString();
            if (imageUrl == null) { //toto bude treba opravit, po toto bude furt false no
                System.err.println("Nenasiel som subor: " + imageEntity.getUrl());
            }else{
                addImage(imageEntity);
            }
        }
        vbox.getChildren().add(scrollPane);
    }

    public void addImage(ImageEntity imageEntity){

        Label label = createLabel(imageEntity.getAutor());
        content.getChildren().add(label);
        String url = "file:"+ Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
                + "/example/demo3/obrasky", imageEntity.getUrl()).toString();

        ImageView imageView = createImageView(url);
        content.getChildren().add(imageView);

        HBox hBox = new HBox();
        VBox.setMargin(hBox,  new Insets(10, 0, 50, 150));
        toggleGroups.add(createHodnotenie(hBox, imageEntity));

        content.getChildren().add(hBox);
        getScrollPane().setContent(content);
    }
    public ToggleGroup createHodnotenie(HBox hBox, ImageEntity imageEntity){
        ToggleGroup toggleGroup = new ToggleGroup();
        for(int i=0; i<5; i++){
            final int value = i + 1;
            createButton(hBox, toggleGroup, String.valueOf(value), new EventHandler() {
                @Override
                public void handle() {
                    updateHondnotenie(imageEntity , value);
                    imageEntity.updateHodnotenie(userService.getAktualnyPouzivatel(), value);
                }
            } );
        }
        int i;
        if((i=userService.getAktualnyPouzivatel().getIndexOhodnotenia(imageEntity)) >=0){
            int index = userService.getAktualnyPouzivatel().getHodnotenia().get(i);
            toggleGroup.selectToggle((RadioButton) hBox.getChildren().get(index-1));
        }
        return toggleGroup;
    }
    private RadioButton createButton(HBox hBox, ToggleGroup toggleGroup, String text, EventHandler eventHandler){
        RadioButton button =  new RadioButton(text);
        button.setToggleGroup(toggleGroup);
        hBox.setSpacing(30);
        button.setStyle("-fx-font-size: 14px;");
        button.setOnAction(event -> {
            eventHandler.handle();
        });
        hBox.getChildren().add(button);
        return button;
    }
}
