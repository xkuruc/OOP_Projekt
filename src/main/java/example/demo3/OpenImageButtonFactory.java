package example.demo3;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpenImageButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(){
        Button openButton = new Button(getTitle());
        openButton.setOnAction(e -> {
            //returnImageService().SaveData(new ImageEntity(returnUserService().getAktualnyPouzivatel().getMeno(), "", ""), stage);
            imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(), "", ""), stage);
            System.out.println(userService.getAktualnyPouzivatel().getMeno()); //asi neprintuje dobre meno dopici
            root.getChildren().add(openButton);
        });
        return openButton;
    }
    /*@Override
    protected void setupContent(Group root, Stage stage) {
        //returnUserService().setAktualnyPouzivatel(new Profesional("Marek"));
        Button openButton = new Button(getTitle());
        openButton.setOnAction(e -> {
            //returnImageService().SaveData(new ImageEntity(returnUserService().getAktualnyPouzivatel().getMeno(), "", ""), stage);
            imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(), "", ""), stage);
            System.out.println(userService.getAktualnyPouzivatel().getMeno());
        });
        root.getChildren().add(openButton);
    }*/

    protected String getTitle() {
        return "Otvoriť...";
    }
}
