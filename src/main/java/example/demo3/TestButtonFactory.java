package example.demo3;

import javafx.scene.control.Button;

public class TestButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(){
        Button TestButton = new Button(getTitle());
        TestButton.setOnAction(e -> {
            Vyhodnotit();
        });
        root.getChildren().add(TestButton);
        return TestButton;
    }
    private void Vyhodnotit(){

    }
    protected String getTitle() {
        return "Vyhodnotiť";
    }
}
