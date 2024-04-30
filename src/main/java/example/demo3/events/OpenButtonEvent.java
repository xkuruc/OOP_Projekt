package example.demo3.events;

import example.demo3.UI.ImageUI;
import javafx.stage.Stage;
/**
 * Metoda pre {@link  example.demo3.button.OpenImageButtonFactory}
 * <p>
 *     sluzi na nahratie noveho obrazka, a nasledne ulozenie obrazka, a pridanie obrazka na plochu
 *     Vytvori sa tak nova polozka na hlasovanie. Prispieva to tak ku dynamickosti mojho programu
 *     Vytvori sa novy {@link ImageEntity} objekt so vsetkymi potrebnymi informaciami.
 *     - Ako autor sa nastavy aktualny pouzivatel
 *     </p>
 */
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

    /**
     *
     *     sluzi na nahratie noveho obrazka, a nasledne ulozenie obrazka, a pridanie obrazka na plochu
     *     Vytvori sa tak nova polozka na hlasovanie.
     *     <p>
     *     Prispieva to tak ku dynamickosti mojho programu
     *     Vytvori sa novy {@link ImageEntity} objekt so vsetkymi potrebnymi informaciami.
     *     - Ako autor sa nastavy aktualny pouzivatel
     *     </p>
     */
    @Override
    public void handle() {
        ImageEntity imageEntity = new ImageEntity(userService.getAktualnyPouzivatel().getMeno(),"","");
        String path = imageService.SaveData(imageEntity, stage);
        if(path!=null){
            imageEntity.setUrl(path);
            //imageUI.addImage("file:"+Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky", path).toString(), userService.getAktualnyPouzivatel().getMeno());
            imageUI.addImage(imageEntity);
        }
    }
}
