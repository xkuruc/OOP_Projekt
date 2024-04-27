package example.demo3.UI;

import example.demo3.events.ImageEntity;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class VyhercaUI extends BaseUI{
    private VBox vBox1;
    private VBox content;
    private Scene scene;
    private ImageEntity vyhernyObrazok;
    private int vyhercaPocetBodov;

    public VyhercaUI(ImageEntity vyhernyObrazok, int vyhercaPocetBodov){
        this.vBox1 = new VBox();
        this.content = new VBox();
        this.scene = new Scene(vBox1);
        this.vyhernyObrazok = vyhernyObrazok;
        this.vyhercaPocetBodov = vyhercaPocetBodov;
    }
    @Override
    protected void setupContent(Stage stage) {
        Stage stage1 = createNewWindow(500, 500);
        addImage(vyhernyObrazok);
        Label label = new Label("Pocet bodov: "+ vyhercaPocetBodov);
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10px 10px 0px 100px");
        vBox1.getChildren().add(content);
        vBox1.getChildren().add(label);
        stage1.setScene(scene);
        stage1.show();
    }

    private Stage createNewWindow(int width, int height){
        Stage stage = new Stage();
        stageSetup(stage, width, height);
        return stage;
    }
    private ImageView createImageView(String imageUrl, int width, int height){
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
    private Label createLabel(String text){
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 40px; -fx-font-weight: bold; -fx-padding: 10px 10px 0px 200px");
        return label;
    }
    private void addImage(ImageEntity imageEntity){
        VBox vboxAkozeVsetko = new VBox();
        HBox hBox = new HBox();

        vboxAkozeVsetko.getChildren().add(createLabel(imageEntity.getAutor()));

        String url = "file:"+ Paths.get(imageService.getDestination(), imageEntity.getUrl());
        ImageView imageView = createImageView(url, 300, 300);
        hBox.getChildren().add(imageView);
        VBox.setMargin(hBox,  new Insets(10, 0, 10, 100));

        vboxAkozeVsetko.getChildren().add(hBox);
        content.getChildren().add(vboxAkozeVsetko);
    }

    @Override
    protected String getTitle() {
        return "VYHERCA";
    }
}
