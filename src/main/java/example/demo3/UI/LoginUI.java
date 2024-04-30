package example.demo3.UI;

import example.demo3.events.LogInEvent;
import example.demo3.pouzivatelia.Factory;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class Chybajuca_rola extends Exception{
    public Chybajuca_rola(String message){
        super(message);
    }
}

/**
 * toto je classa reprezentujuca prihlasovacie rozhranie. Zavola {@link LogInEvent} a jeho metodu {@link LogInEvent#logIn(String, String)}
 * Taktie pracuje aj so vlastnymi vynimkami, ktore su definovane vo {@link LogInEvent} a ich chybovu hlasku vypise
 * aj tu sa dodrziava oddelenie aplikacnej logiky od pouzivatelskeho rozhrania
 */
public class LoginUI extends BaseUI{
    private VBox vbox;
    private Scene scene;
    private ToggleGroup toggleGroup;
    private TextField nameField;
    private LogInEvent logInEvent;
    public LoginUI(){
        this.vbox = new VBox();
        this.scene = new Scene(vbox, Color.GRAY);
        this.logInEvent = new LogInEvent(userService);
    }

    public VBox getVbox(){
        return this.vbox;
    }
    public Scene getScene(){
        return this.scene;
    }
    @Override
    protected void setupContent(Stage stage) {
        stageSetup(stage, 400, 400);
        stage.setScene(getScene());
        createRadioButton();
        createNameInput();
        createLoginButton(stage);

        stage.show();
    }

    public void handle() {
        try {
            if(toggleGroup.getSelectedToggle() == null) {
                throw new Chybajuca_rola("Vyber si rolu !");
            }
            logInEvent.logIn(nameField.getText(), ((RadioButton) toggleGroup.getSelectedToggle()).getText());
            stage.close();
            MainUI mainUI = new MainUI();
            mainUI.MainUISetup();
        } catch (Exception e ) {
            Label label = new Label(e.getMessage());
            vbox.getChildren().add(label);
        }
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
            handle();
        });
        getVbox().getChildren().add(button);
    }
    public void createNameInput(){
        TextField nameField = new TextField();
        nameField.setPromptText("Prihlasovacie meno");
        vbox.getChildren().add(nameField);
        this.nameField = nameField;
    }

    @Override
    protected String getTitle() {
        return "LOGIN";
    }
}
