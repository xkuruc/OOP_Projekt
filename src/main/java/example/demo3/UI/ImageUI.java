package example.demo3.UI;

import example.demo3.events.ImageEntity;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class ImageUI extends BaseUI{
    ArrayList<ToggleGroup> toggleGroups;

    public VBox vbox; //toto je celkovo akoze ImageUi
    VBox content; //toto je content vo scrollPanely
    public ScrollPane scrollPane;
    public ImageUI(VBox vbox){
        this.vbox = vbox;
        this.toggleGroups = new ArrayList<>();
        this.content = new VBox();
    }
    public ScrollPane getScrollPane(){return this.scrollPane;}
    public void setScrollPane(ScrollPane scrollPane){this.scrollPane = scrollPane;}

    public ScrollPane createScrollPane(int width, int height) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(width, height);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        return scrollPane;
    }

    public Label createLabel(String text){
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-padding: 10px 10px 0px " + (400
                -label.getLayoutBounds().getWidth()/2 -150)+ "px" );
        return label;
    }

    public ImageView createImageView(String imageUrl){
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(imageService.getWidth());
        imageView.setFitHeight(imageService.getHeight());
        VBox.setMargin(imageView, new Insets(0, 0, 0, 150));
        return imageView;
    }

     public void updateHondnotenie(ImageEntity imageEntity, int hodnotenie){
        userService.getAktualnyPouzivatel().updateHodnotenie(imageEntity, hodnotenie);
     }

     public abstract void setupContent(Stage stage);

    public abstract void addImage(ImageEntity imageEntity);


    @Override
    protected String getTitle() {
        return "Najlepší obrázok";
    }
}
