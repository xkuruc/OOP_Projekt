package example.demo3.button;

import example.demo3.events.EventHandler;
import javafx.scene.control.Button;

public class RandomTestButtonFactory extends ButtonFactory{
    @Override
    public Button createButton(EventHandler eventHandler){
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
