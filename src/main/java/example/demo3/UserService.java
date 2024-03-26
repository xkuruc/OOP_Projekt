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
    public void updateData(Uzivatel uzivatel){
        for(Uzivatel uzivatel1 : uzivatelArrayList){
            if(uzivatel1.getMeno().equals(uzivatel.getMeno())){
                uzivatel1.setRola(uzivatel.getRola());
                uzivatel1.setLajk(uzivatel.getLajk());
                return;
            }
        }
        PridajObjekt(uzivatel);
    }
    public Uzivatel getAktualnyPouzivatel(){
        return this.aktualnyPouzivatel;
    }
}
