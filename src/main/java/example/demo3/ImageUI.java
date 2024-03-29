package example.demo3;

import example.demo3.events.ImageEntity;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ImageUI extends BaseUI{
    ArrayList<ToggleGroup> toggleGroups;

    private VBox vbox; //toto je celkovo akoze ImageUi
    VBox content; //toto je content vo scrollPanely
    private ScrollPane scrollPane;
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

    public ToggleGroup createHodnotenie(HBox hBox, ImageEntity imageEntity){
        ToggleGroup toggleGroup = new ToggleGroup();
        for(int i=0; i<5; i++){
            RadioButton radioButton = new RadioButton(String.valueOf(i+1));
            radioButton.setToggleGroup(toggleGroup);
            hBox.setSpacing(30);
            radioButton.setStyle("-fx-font-size: 14px;");
            hBox.getChildren().add(radioButton);

            final int value = i + 1;
            radioButton.setOnAction(event -> {
                updateHondnotenie(imageEntity , value);
            });
        }

        int i;
        if((i=userService.getAktualnyPouzivatel().getIndexOhodnotenia(imageEntity)) >=0){
            int index = userService.getAktualnyPouzivatel().getHodnotenia().get(i);
            toggleGroup.selectToggle((RadioButton) hBox.getChildren().get(index-1));
        }
        return toggleGroup;
    }
     public void updateHondnotenie(ImageEntity imageEntity, int hodnotenie){
        userService.getAktualnyPouzivatel().updateHodnotenie(imageEntity, hodnotenie);
     }

    @Override
    protected void setupContent(Stage stage) {
        stageSetup(stage, 800, 800);
        setScrollPane(createScrollPane(800, 800));

        for (ImageEntity imageEntity : imageService.returnObjectArray() ) {
            URL imageUrl = getClass().getResource("obrasky/" + imageEntity.getUrl());

            if (imageUrl == null) {
                System.err.println("Nenasiel som subor: " + imageEntity.getUrl());
            }else{
                addImage(imageEntity);
            }
        }
        vbox.getChildren().add(scrollPane);
    }

    public void addImage(ImageEntity imageEntity){

        Label label = createLabel(imageEntity.getAutor());
        content.getChildren().add(label);
        String url = "file:"+ Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
                + "/example/demo3/obrasky", imageEntity.getUrl()).toString();

        ImageView imageView = createImageView(url);
        content.getChildren().add(imageView);

        HBox hBox = new HBox();
        VBox.setMargin(hBox,  new Insets(10, 0, 50, 150));
        toggleGroups.add(createHodnotenie(hBox, imageEntity));
        content.getChildren().add(hBox);
        getScrollPane().setContent(content);
    }

    @Override
    protected String getTitle() {
        return "Najlepší obrázok";
    }
}
