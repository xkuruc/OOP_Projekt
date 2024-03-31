package example.demo3.UI;

import example.demo3.events.ImageEntity;
import example.demo3.pouzivatelia.Profesional;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProfesionalImageUI extends ImageUI{
    public ProfesionalImageUI(VBox vbox) {
        super(vbox);
        superTogglegroup = null;
    }
    private final int hodnotaSuperHodnotenia = 10;
    ToggleGroup superTogglegroup;

    public void setupContent(Stage stage) {
        stageSetup(stage, 800, 800);
        setScrollPane(createScrollPane(800, 800));

        for (ImageEntity imageEntity : imageService.returnObjectArray() ) {
            //URL imageUrl = getClass().getResource("./obrasky/" + imageEntity.getUrl());
            String imageUrl = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
                    + "/example/demo3/obrasky", imageEntity.getUrl()).toString();
            if (imageUrl == null) { //toto bude treba opravit, po toto bude furt false no
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
        VBox.setMargin(hBox,  new Insets(10, 0, 10, 150));
        toggleGroups.add(createHodnotenie(hBox, imageEntity));
        content.getChildren().add(hBox);

        HBox hBox1 = new HBox();
        VBox.setMargin(hBox1,  new Insets(10, 0, 50, 200));
        createSuperHodnotenie(hBox1, imageEntity);
        content.getChildren().add(hBox1);

        getScrollPane().setContent(content);
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
                ((Profesional) userService.getAktualnyPouzivatel()).vymazSuperHodnotenie();
                updateHondnotenie(imageEntity , value);
                if(superTogglegroup!=null){
                    superTogglegroup.selectToggle(null);
                }
            });
        }
        int i;
        if((i=userService.getAktualnyPouzivatel().getIndexOhodnotenia(imageEntity)) >=0){
            int index = userService.getAktualnyPouzivatel().getHodnotenia().get(i);
            toggleGroup.selectToggle((RadioButton) hBox.getChildren().get(index-1));
        }
        return toggleGroup;
    }

    public ToggleGroup createSuperHodnotenie(HBox hBox, ImageEntity imageEntity){
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton upvoteButton = new RadioButton("Upvote");
        upvoteButton.setToggleGroup(toggleGroup);
        hBox.setSpacing(30);
        upvoteButton.setStyle("-fx-font-size: 14px;");
        upvoteButton.setOnAction(event -> {
            superHodnotenie(toggleGroup, imageEntity, hodnotaSuperHodnotenia);
        });
        hBox.getChildren().add(upvoteButton);

        RadioButton downvoteButton =  new RadioButton("Downvote");
        downvoteButton.setToggleGroup(toggleGroup);
        hBox.setSpacing(30);
        downvoteButton.setStyle("-fx-font-size: 14px;");
        downvoteButton.setOnAction(event -> {
            superHodnotenie(toggleGroup, imageEntity, -hodnotaSuperHodnotenia);
        });
        hBox.getChildren().add(downvoteButton);

        //if(((Profesional) userService.getAktualnyPouzivatel()).getSuperHodnotenie())
        Profesional profesional =((Profesional) userService.getAktualnyPouzivatel());
        if(profesional.getSuperHodnotenie()!=0 && profesional.getSuperHodnotenieImage().getUrl().equals(imageEntity.getUrl())){
            if(profesional.getSuperHodnotenie()>0){
                toggleGroup.selectToggle(upvoteButton);
            }else{
                toggleGroup.selectToggle(downvoteButton);
            }
            this.superTogglegroup = toggleGroup;
        }

        return toggleGroup;
    }

    private void superHodnotenie(ToggleGroup toggleGroup, ImageEntity imageEntity, int hodnota){
        Uzivatel user = userService.getAktualnyPouzivatel();
        ((Profesional) user).setSuperHodnotenie(hodnota);
        ((Profesional) user).setSuperHodnotenieImage(imageEntity);
        user.setHodnotenia(new ArrayList<>());
        user.setOhodnoteneObrasky(new ArrayList<>());
        for(ToggleGroup toggleGroup1 : toggleGroups){
            toggleGroup1.selectToggle(null);
        }
        if(this.superTogglegroup != null && this.superTogglegroup != toggleGroup){
            superTogglegroup.selectToggle(null);
        }
        this.superTogglegroup = toggleGroup;
    }
}
