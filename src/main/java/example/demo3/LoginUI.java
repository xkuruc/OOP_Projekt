package example.demo3;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginUI extends BaseUI{
    private VBox vbox;
    private Scene scene;
    private ToggleGroup toggleGroup;
    private TextField nameField;
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
        stageSetup(stage, 400, 400);
        stage.setScene(getScene());
        createRadioButton();
        createNameInput();
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
            logIn(stage);
        });
        getVbox().getChildren().add(button);
    }
    public void createNameInput(){
        TextField nameField = new TextField();
        nameField.setPromptText("Prihlasovacie meno");
        vbox.getChildren().add(nameField);
        this.nameField = nameField;
    }

    private void logIn(Stage stage){

        //tu by som mohol zrobit že vyhodi vlastny error nejaky
        if(nameField.getText().isEmpty() || toggleGroup.getSelectedToggle() == null){
            return;
        }else{
            stage.close();
            Uzivatel uzivatel = Factory.createUserFactory(((RadioButton) toggleGroup.getSelectedToggle()).getText())
                    .createUzivatel(nameField.getText().toString());
            userService.updateData(uzivatel);
            userService.setAktualnyPouzivatel(uzivatel);

            MainUI mainUI = new MainUI();
            mainUI.MainUISetup();
        }
    }
    @Override
    protected String getTitle() {
        return "LOGIN";
    }
}
