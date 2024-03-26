package example.demo3;

import javafx.stage.Stage;

import java.util.ArrayList;

public class UserService implements  DataService<Uzivatel>{
    private Uzivatel aktualnyPouzivatel;
    private ArrayList<Uzivatel> uzivatelArrayList;
    public UserService(){
        this.uzivatelArrayList = new ArrayList<>();
        //this.aktualnyPouzivatel = new Profesional("DOPICI");
    }
    public void setAktualnyPouzivatel(Uzivatel uzivatel){
        this.aktualnyPouzivatel = uzivatel;
    }
    public void VytvorStatickeObjekty(){
        PridajObjekt(new Profesional("Marek"));
        PridajObjekt(new Amater("Filip"));
        PridajObjekt(new Novy("Peter"));
    }
    public ArrayList<Uzivatel> returnObjectArray(){
        return this.uzivatelArrayList;
    }
    public void SaveData(Uzivatel data, Stage stage){

    }
    public Uzivatel getAktualnyPouzivatel(){
        return this.aktualnyPouzivatel;
    }
}
