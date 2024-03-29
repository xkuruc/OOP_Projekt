package example.demo3.events;

import example.demo3.pouzivatelia.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserService extends UserServiceData implements  DataService<Uzivatel>{
    private Uzivatel aktualnyPouzivatel;
    public UserService(){
        uzivatelArrayList = new ArrayList<>();
    }
    public void setAktualnyPouzivatel(Uzivatel uzivatel){
        this.aktualnyPouzivatel = uzivatel;
    }
    public void VytvorStatickeObjekty(){
        PridajObjekt(new Profesional("Marek"));
        PridajObjekt(new Amater("Filip"));
        PridajObjekt(new Novy("Peter"));
    }

    public Uzivatel exists(String meno){
        for(Uzivatel uzivatel : returnObjectArray()){
            if(uzivatel.getMeno().equals(meno)){
                return uzivatel;
            }
        }
        return null;
    }

    public String SaveData(Uzivatel data, Stage stage){
        return null;
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
