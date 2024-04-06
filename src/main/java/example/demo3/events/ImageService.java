package example.demo3.events;

import example.demo3.pouzivatelia.UserServiceData;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

//kamo, treba nejako prepojit aboco, treba proste ze jak vytvaras staticke objektu tuna, ze mena sa pridaju podla toho jake su su ulozene vo array vsetkych uzivatelov vo userservice

public class ImageService extends ImageServiceData implements DataService<ImageEntity>{
    private ArrayList<Uzivatel>  uzivatelArrayList;
    public ImageService(){
        destination = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "example/demo3/obrasky";
        imageEntityArrayList = new ArrayList<>();
    }
    public String getDestination(){
        return destination;
    }
    public void setUzivatelArrayList(ArrayList<Uzivatel> uzivatelArrayList){this.uzivatelArrayList = uzivatelArrayList;}
    //aj toto sa da teoreticky zapisat do jednej generickej metody, že vytvorStytickeObjekty(T)
    //a vytvori statických autorov, a statické obrázky
    public void VytvorStatickeObjekty(){
        imageEntityArrayList = new ArrayList<>();
        try {
            Path[] files = Files.list(Paths.get(destination))
                    .filter(path -> Files.isRegularFile(path) && !path.getFileName().toString().startsWith("."))
                    .toArray(Path[]::new);
            String[] fileNames = Arrays.stream(files)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toArray(String[]::new);

            for(int i=0, j=0; i<files.length; i++, j++){
                if(j>= uzivatelArrayList.size()){
                    j=0;
                }
                ImageEntity image = new ImageEntity(uzivatelArrayList.get(j).getMeno(), "", String.valueOf(fileNames[i]));
                PridajObjekt(image);
            }
        } catch (IOException e) {
            System.err.println("Nieje vytvorený priecinok s obrazkami, prosím vytvorte priecinok s obrazkami na adrese  " + destination);
            e.printStackTrace();
        }
    }
    //to by sa mohlo a prepisat na ze pridajObjekt, bude to len genericke
    //a prida aj pouzivatela aj obrazok pohode ne

    //som zistil ze dostanes error, ak pridas dva tie iste obrasky, s tym istym nazvom no
    public String SaveData(ImageEntity data, Stage stage){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    data.setUrl(file.getName());
                    Path destination = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky", data.getUrl());
                    //String destination = "file:"+Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "/example/demo3/obrasky", data.getUrl());
                    Files.copy(file.toPath(), destination);
                    System.out.println("Obrazok bol ulozeny");
                    PridajObjekt(new ImageEntity(data.getAutor(), "",(file.getName())));
                    return file.getName();
                } catch (IOException ioException) {
                    System.out.println("TUSOM ");
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
