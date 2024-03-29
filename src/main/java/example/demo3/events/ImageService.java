package example.demo3.events;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageService extends ImageServiceData implements DataService<ImageEntity>{
    public ImageService(){
        destination = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "example/demo3/obrasky";
        imageEntityArrayList = new ArrayList<>();
        VytvorStatickeObjekty();
    }

    //aj toto sa da teoreticky zapisat do jednej generickej metody, že vytvorStytickeObjekty(T)
    //a vytvori statických autorov, a statické obrázky
    public void VytvorStatickeObjekty(){
        String[] autory = new String[]{"Marek", "Peto", "Filip"};
        try {
            Path[] files = Files.list(Paths.get(destination))
                    .filter(path -> Files.isRegularFile(path) && !path.getFileName().toString().startsWith("."))
                    .toArray(Path[]::new);
            String[] fileNames = Arrays.stream(files)
                    .map(Path::getFileName)
                    .map(Path::toString) // Convert Path to String
                    .toArray(String[]::new);

            for(int i=0, j=0; i<files.length;i++,j++){
                if(j>=autory.length){
                    j=0;
                }

                ImageEntity image = new ImageEntity(autory[j], "", String.valueOf(fileNames[i]));
                PridajObjekt(image);
            }
        } catch (IOException e) {
            System.err.println("Failed to list directory: " + destination);
            e.printStackTrace();
        }
    }
    //to by sa mohlo a prepisat na ze pridajObjekt, bude to len genericke
    //a prida aj pouzivatela aj obrazok pohode ne

    public String SaveData(ImageEntity data, Stage stage){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    data.setUrl(file.getName());
                    Path destination = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky", data.getUrl());
                    Files.copy(file.toPath(), destination);
                    System.out.println("Obrazok bol ulozeny");
                    PridajObjekt(new ImageEntity(data.getAutor(), "",(file.getName())));
                    return file.getName();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Pruser");
        }
        return null;
    };

    public void ReturnData(){
        Path directory = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky");
        try {
            // Iterate through all files in the directory
            Files.list(directory)
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            System.out.println("File: " + file.getFileName());
                        } catch (Exception e) {
                            System.err.println("Failed to read file: " + file);
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            System.err.println("Failed to list directory: " + directory);
            e.printStackTrace();
        }
    }


}
