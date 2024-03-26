package example.demo3;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginUI extends BaseUI{
    private VBox vbox;
    private Scene scene;
    private ToggleGroup toggleGroup;
    public LoginUI(){
        this.vbox = new VBox();
        this.scene = new Scene(vbox, Color.GRAY);
    }
    public VBox getVbox(){
        return this.vbox;
    }
    public Scene getScene(){
        return this.scene;
    }
    @Override
    protected void setupContent(Group root, Stage stage) {
        stageSetup(stage, getScene(), 400, 400);
        createRadioButton();
        createLoginButton(stage);


        stage.show();
    }
    public void createRadioButton(){
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("Profesional");
        radioButton1.setToggleGroup(toggleGroup);

        RadioButton radioButton2 = new RadioButton("Amater");
        radioButton2.setToggleGroup(toggleGroup);

        RadioButton radioButton3 = new RadioButton("Novy");
        radioButton3.setToggleGroup(toggleGroup);
        getVbox().getChildren().addAll(radioButton1, radioButton2, radioButton3);
        this.toggleGroup= toggleGroup;
    }
    public void createLoginButton(Stage stage){
        Button button = new Button("LOGIN");

        button.setOnAction(e -> {
            stage.close();

            Stage newStage = new Stage();
            Group newRoot = new Group();
            new ImageUI().setupUI(newRoot,newStage);
            new OpenImageUI().setupUI(newRoot,newStage);
        });
        getVbox().getChildren().add(button);
    }

    @Override
    protected String getTitle() {
        return "LOGIN";
    }
}
