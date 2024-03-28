package example.demo3;

import javafx.scene.control.Button;

import java.util.Random;

public class RandomTestButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(){
        Button RandomTestButton = new Button(getTitle());
        RandomTestButton.setOnAction(e -> {
            RandomVyhodnotit();
        });
        root.getChildren().add(RandomTestButton);
        return RandomTestButton;
    }
    private void RandomVyhodnotit(){

    }
    protected String getTitle() {
        return "Random Vyhodnotenie";
    }
}
