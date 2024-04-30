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

/**
 * Toto je classa, v ktorej som definoval hlavne operacie s obrazkami, ako napriklad ulozenie obrazka, nacitanie obrazka...
 * Classa pracuje so obrazkami, ktore su reprezentovane vo forme ImageEntity objektov -{@link ImageEntity}
 * @see ImageEntity
 */
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

    /**
     * Vytvori staticke objekty obrazkov. Vytvori ich tolko koľko ich je ulozenych vo priecinku "obrasky"
     * <p>
     *    To je potrebne preto ze ked pouzivatel sa prvy krat prihlasy aby tam uz boly nejake obrazky
     *    Vytvori ich tak ze kazdemu vytvorenemu statickemu pouzivatelovi prida postupne jeden obrazok az pokym nevycerpame vsetky staticke obrazky
     */
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
    /**
     * Ulozi dany obrazok do priecinka "obrasky"
     * <p>
     *     poznamka: Nemôžu byt ulozene dva obrazky s rovnakym menom
     *
     *
     * @param data to je ImageEntity objekt reprezentujuci obrazok aj so danymi udajmi ako autor, adresa ...
     * @see ImageEntity
     * @param stage to je stage, to sluzi na to aby sme vedeli nacitat dany obrazok
     * @return      Vrati adresu na ktoru bol obrazok ulozeny
     */
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
                    ioException.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Pruser");
        }
        return null;
    };
    /**
     * Sluzi len na vypísanie udajov. LEN NA KONTROLU
     */
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
