package example.demo3.events;

import example.demo3.UI.LoginUI;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * Tu je definovany Event pre {@link example.demo3.button.LogOutButtonFactory}
 * Vyuziva sa strategy pattern, cez rozhranie {@link EventHandler}
 */
public class LogOutButtonEvent implements EventHandler{
    private UserService userService;
    private ImageService imageService;
    private Stage stage;
    public LogOutButtonEvent(UserService userService, ImageService imageService, Stage stage ){
        this.stage = stage;
        this.userService = userService;
        this.imageService = imageService;
    }

    /**
     * Metoda na odhlasenie
     * <p>
     *     Ulozi sa aktualny progres, a zavrie sa hlavne okno
     *     Potom sa otvori nove mensie okno, ktore vyzve pouzivatela na nove prihlasenie
     */
    @Override
    public void handle() {
        stage.close();
        userService.setAktualnyPouzivatel(null);
        DataServiceManager.root = new Group();
        DataServiceManager.stage = new Stage();
        new LoginUI().setupUI(DataServiceManager.stage);

        for(ImageEntity image: imageService.returnObjectArray()){
            System.out.println(image.getUrl());
            int i=0;
            for(Uzivatel uzivatel: image.getUzivateliaCoHodnotili()){
                System.out.println(uzivatel.getMeno() +"  "+ image.getHodnotenie().get(i));
                i++;
            }
        }
    }
}
