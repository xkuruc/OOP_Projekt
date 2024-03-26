package example.demo3;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class ImageUI extends BaseUI{
    class ScrollPanelService{
        private int width;
        private int height;
        private ScrollPane scrollPane;
        ScrollPanelService(int width, int height){
            this.width = width;
            this.height = height;
            this.scrollPane = new ScrollPane();

        }
        public ScrollPane createScrollPane(){
            this.scrollPane.setPrefSize(this.width, this.height);
            this.scrollPane.setFitToWidth(true);
            this.scrollPane.setFitToHeight(true);
            VBox content = new VBox();
            content.setSpacing(100);

            for (ImageEntity imageEntity : imageService.returnObjectArray() ) {
                URL imageUrl = getClass().getResource("obrasky/" + imageEntity.getUrl());

                if (imageUrl == null) {
                    System.err.println("Couldn't find file: " + imageEntity.getUrl());
                    continue;
                }

                Image image = new Image(imageUrl.toExternalForm());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(imageService.getWidth());
                imageView.setFitHeight(imageService.getHeight());
                VBox.setMargin(imageView, new Insets(0, 0, 0, 150));
                content.getChildren().add(imageView);
            }

            scrollPane.setContent(content);
            return scrollPane;
        }
    }
    @Override
    protected void setupContent(Group root, Stage stage) { //ano ja viem netreba tu ten stage, ale možno bude treba dakedy
        //returnUserService().setAktualnyPouzivatel(new Profesional("Marek"));
        userService.setAktualnyPouzivatel(new Profesional("Marek"));
        Scene scene = new Scene(root, Color.GRAY);

        stageSetup(stage, scene, 800, 800);
        ScrollPanelService scrollPanelService = new ScrollPanelService(800,800);
        ScrollPane scrollPane = scrollPanelService.createScrollPane();
        root.getChildren().add(scrollPane);

        stage.show();
    }

    @Override
    protected String getTitle() {
        return "Najlepší obrázok";
    }
}
