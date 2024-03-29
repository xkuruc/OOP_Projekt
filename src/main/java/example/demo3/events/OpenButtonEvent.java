package example.demo3;

import javafx.stage.Stage;

import java.net.URL;

public class OpenButtonEvent implements EventHandler{
    private ImageUI imageUI;
    private ImageService imageService;
    private UserService userService;
    private Stage stage;
    public OpenButtonEvent(ImageService imageService, UserService userService, ImageUI imageUI, Stage stage){
        this.imageUI = imageUI;
        this.imageService = imageService;
        this.userService = userService;
        this.stage = stage;
    }

    @Override
    public void handle() {
        String path = imageService.SaveData(new ImageEntity(userService.getAktualnyPouzivatel().getMeno(),"",""), stage);
        URL imageUrl = getClass().getResource("obrasky/" + path);
        imageUI.addImage(imageUrl.toExternalForm(), userService.getAktualnyPouzivatel().getMeno());
    }
}
