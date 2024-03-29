package example.demo3;

import javafx.scene.layout.VBox;

public class AddImageEvent extends ImageUI{

    public AddImageEvent(VBox vbox) {
        super(vbox);
    }

    public void handle(){
        String name = imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(), "", ""), stage);
        if(name !=null){
            super.addImage(getClass().getResource("obrasky/" + name).toExternalForm(), userService.getAktualnyPouzivatel().getMeno());
        }
    }
}
