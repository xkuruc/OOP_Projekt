package example.demo3.events;

import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * Toto je taka hlavna classa, ktora umoznuje aj sucasne vyuzivanie {@link UserService} a {@link ImageService} pre vsetky classy a objekty, ktore to potrebuju
 */
public class DataServiceManager {

    public static UserService userService = new UserService();
    public static ImageService imageService = new ImageService();
    public static Group root;
    public static Stage stage;

}
