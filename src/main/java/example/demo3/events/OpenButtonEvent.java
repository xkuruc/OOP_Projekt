package example.demo3.events;

import example.demo3.UI.ImageUI;
import javafx.stage.Stage;

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
        ImageEntity imageEntity = new ImageEntity(userService.getAktualnyPouzivatel().getMeno(),"","");
        String path = imageService.SaveData(imageEntity, stage);
        imageEntity.setUrl(path);
        //imageUI.addImage("file:"+Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky", path).toString(), userService.getAktualnyPouzivatel().getMeno());
        imageUI.addImage(imageEntity);
    }
}
