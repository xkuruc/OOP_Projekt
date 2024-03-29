package example.demo3;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpenImageButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(EventHandler eventHandler){
        Button openButton = new Button(getTitle());
        openButton.setOnAction(e -> {
            eventHandler.handle();
            //imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(),"",""), stage);
            //imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(), "", ""), stage);
            //dobre kamo potrebujem najst sposob ako z tadialto z tohoto miesta zavolat metodu addImage() vo ImageUI
            //dopici
            //chapes ne zeby ked pridas nejaky obrazok tak prida aj na tu obrazovku, ale aj do arrayList<ImageEntity> vo imageServiceData
            //to je vsetko aj preto aby som potom nemusel stale pre kazdeho noveho uzivatela vytvarat nove ImageUi a novy scroll bar
            //lebo potrebujem nejako spravit ze ked uzivatel zrobi nejake to hlasovanie, a potom sa odhlasi, a prihlasi tak mu ukaze kde dal hlasy a ake ma hlasy a tak


            //abo presunut toto miesto, na ine miesto
        });
        root.getChildren().add(openButton);
        return openButton;
    }

    protected String getTitle() {
        return "Pridať obrázok";
    }
}
