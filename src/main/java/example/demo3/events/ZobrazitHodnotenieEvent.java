package example.demo3.events;

import example.demo3.UI.BaseUI;
import example.demo3.UI.ImageUI;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ZobrazitHodnotenieEvent extends BaseUI implements EventHandler{
    private ImageUI imageUI;
    private ImageService imageService;
    private UserService userService;
    private VBox vBox1;
    private Scene scene;
    public ZobrazitHodnotenieEvent(ImageService imageService, UserService userService, ImageUI imageUI){
        this.imageService = imageService;
        this.userService = userService;
        this.imageUI = imageUI;
        this.vBox1 =  new VBox();
        this.scene = new Scene(vBox1);
    }

    private Stage createNewWindow(){
        Stage stage = new Stage();
        stageSetup(stage, 500, 500);
        return stage;
    }
    @Override
    public void handle() {
        Stage stage1 = createNewWindow();
        createHodnotenie(stage1);
        stage1.setScene(scene);
        stage1.show();
    }

    private void createHodnotenie(Stage stage){
        VBox vBox = new VBox();
        for(Uzivatel uzivatel : userService.returnObjectArray()){
            Label label = new Label(uzivatel.getMeno());
            vBox.getChildren().add(label);
        }
        vBox1.getChildren().add(vBox);
    }
    @Override
    protected void setupContent(Stage stage){

    }

    @Override
    protected String getTitle() {
        return "Hodnotenie";
    }
}
