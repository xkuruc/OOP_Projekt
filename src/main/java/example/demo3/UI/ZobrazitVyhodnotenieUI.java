package example.demo3.UI;

import example.demo3.events.ImageEntity;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;

public class ZobrazitVyhodnotenieUI extends BaseUI{
    private VBox vBox1;
    private VBox content;
    private Scene scene;
    private ArrayList<Label> labelArrayList;
    private ScrollPane scrollPane;
    public ZobrazitVyhodnotenieUI(){
        this.vBox1 = new VBox();
        this.content = new VBox();
        this.scene = new Scene(vBox1);
        this.labelArrayList = new ArrayList<>();
        this.scrollPane = createScrollPane(500, 500);
    }

    public void upravTextHodnoteniaObrazka(ImageEntity imageEntity, int hodnotenie){
        int i = 0;
        for(ImageEntity image : imageService.returnObjectArray()){
            if(imageEntity.getUrl().equals(image.getUrl())){
                Label label = labelArrayList.get(i);
                label.setText(label.getText() + hodnotenie);
                return;
            }
            i++;
        }
    }

    private Stage createNewWindow(int width, int height){
        Stage stage = new Stage();
        stageSetup(stage, width, height);
        return stage;
    }

    private void createVysledneHodnotenie(Stage stage){
        for (ImageEntity imageEntity : imageService.returnObjectArray() ) {
            addImage(imageEntity);
        }
    }
    private ImageView createImageView(String imageUrl, int width, int height){
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        VBox.setMargin(imageView, new Insets(0, 0, 0, 20));
        return imageView;
    }
    private void addImage(ImageEntity imageEntity){
        VBox vboxAkozeVsetko = new VBox();
        HBox hBox = new HBox();

        vboxAkozeVsetko.getChildren().add(createLabel(imageEntity.getAutor()));

        String url = "file:"+ Paths.get(imageService.getDestination(), imageEntity.getUrl());
        ImageView imageView = createImageView(url, 100, 100);
        hBox.getChildren().add(imageView);

        Label label = createHodnotenieLabel("Počet hlasov: ");
        hBox.getChildren().add(label);
        labelArrayList.add(label);

        vboxAkozeVsetko.getChildren().add(hBox);
        content.getChildren().add(vboxAkozeVsetko);
    }
    private Label createHodnotenieLabel(String text){
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-padding: 30px 30px 0px 30px");
        return label;
    }

    private Label createLabel(String text){
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10px 10px 0px 30px");
        return label;
    }

    private ScrollPane createScrollPane(int width, int height){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(width, height);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        return scrollPane;
    }

    @Override
    protected void setupContent(Stage stage) {
        Stage stage1 = createNewWindow(500, 500);

        createVysledneHodnotenie(stage1);
        scrollPane.setContent(content);
        vBox1.getChildren().add(scrollPane);
        stage1.setScene(scene);
        stage1.show();
    }
    @Override
    protected String getTitle() {
        return "Hodnotenie";
    }
}
