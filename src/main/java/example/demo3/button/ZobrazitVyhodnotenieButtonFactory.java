package example.demo3;

import javafx.scene.control.Button;

public class ZobrazitVyhodnotenieButtonFactory extends ButtonFactory {
    @Override
    public Button createButton(EventHandler eventHandler){
        Button VyhodnotenieButton = new Button(getTitle());
        VyhodnotenieButton.setOnAction(e -> {
            ZobrazitVyhodnotenie();
        });
        root.getChildren().add(VyhodnotenieButton);
        return VyhodnotenieButton;
    }
    private void ZobrazitVyhodnotenie(){

    }
    protected String getTitle() {
        return "Zobrazit Vyhodnotenie";
    }
}
