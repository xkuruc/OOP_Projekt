package example.demo3.UI;

import example.demo3.pouzivatelia.Factory;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class Chybajuce_udaje extends Exception{
    public Chybajuce_udaje(String message){
        super(message);
    }
}
class Chybajuce_meno extends Exception{
    public Chybajuce_meno(String message){
        super(message);
    }
}

class Chybajuca_rola extends Exception{
    public Chybajuca_rola(String message){
        super(message);
    }
}

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
            logIn(stage);
        } catch (Chybajuce_meno | Chybajuca_rola e ) {
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
            //logIn(stage);
        });
        getVbox().getChildren().add(button);
    }
    public void createNameInput(){
        TextField nameField = new TextField();
        nameField.setPromptText("Prihlasovacie meno");
        vbox.getChildren().add(nameField);
        this.nameField = nameField;
    }

    private void logIn(Stage stage) throws Chybajuce_meno, Chybajuca_rola{

        //tu by som mohol zrobit že vyhodi vlastny error nejaky
        if(nameField.getText().isEmpty() ){
            throw new Chybajuce_meno("Vloz meno !");
        } else if (toggleGroup.getSelectedToggle() == null) {
            throw new Chybajuca_rola("Vyber si rolu !");
        } else{
            stage.close();
            Uzivatel uzivatel;
            if( (uzivatel = userService.exists(nameField.getText().toString())) == null){
                uzivatel = Factory.createUserFactory(((RadioButton) toggleGroup.getSelectedToggle()).getText())
                        .createUzivatel(nameField.getText().toString());
                userService.PridajObjekt(uzivatel);
                System.out.println(uzivatel.getMeno()+"!!!!!!!!");
            }
            //userService.updateData(uzivatel);
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
