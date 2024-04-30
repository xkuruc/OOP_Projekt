package example.demo3.events;

import example.demo3.pouzivatelia.*;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Toto je classa, v ktorej som definoval hlavne operacie s pouzivatelmi, ako napriklad vytvorenie pouzivatela, uprava pouzivatela atd
 * Classa pracuje so uzivatelmi, ktorí su reprezentovany vo forme Uzivatel objektov -{@link Uzivatel}
 * @see Uzivatel
 */
public class UserService extends UserServiceData implements  DataService<Uzivatel>{
    private Uzivatel aktualnyPouzivatel;
    public UserService(){
        uzivatelArrayList = new ArrayList<>();
    }
    /**
     * Nastavi noveho aktualneho pouzivatela
     * <p>
     *    Aktualny pouzivatel je pouzivatel co je prave prihlaseny
     *
     * @param uzivatel to je uzivatel, ktory ma byt nastaveny ako novy aktualny pouzivatel
     */
    public void setAktualnyPouzivatel(Uzivatel uzivatel){
        this.aktualnyPouzivatel = uzivatel;
    }

    /**
     * Vytvori staticke objekty pouzivatelov
     * <p>
     *    Je to potrebne nato aby ked sa pouzivatel prihlasy prvy krat aby tam uz boli nejaky pouzivatelia
     *
     */
    public void VytvorStatickeObjekty(){
        PridajObjekt(new Profesional("Marek"));
        PridajObjekt(new Amater("Filip"));
        PridajObjekt(new Novy("Peter"));
    }

    /**
     * Zisti, existuje  pouzivatel s danym menom. Ak existuje tak ho vrati, ak nie, vrati NULL
     *
     * @param  meno  meno hôadaneho pouzivatela
     * @return      pouzivatel s danym menom, alebo NULL ak neexistuje
     */
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

    /**
     * Upravy daneho pouzivatela
     * @param uzivatel uzivatel ktory ma byt upraveny
     * @param meno nove meno
     * @param rola nova rola
     */
    public void updateData(Uzivatel uzivatel, String meno, String rola){
        for(Uzivatel uzivatel1 : uzivatelArrayList){
            if(uzivatel1.getMeno().equals(uzivatel.getMeno())){
                uzivatel1.setRola(rola);
                uzivatel1.setMeno(meno);
                return;
            }
        }
    }
    /**
     * Vrati aktualneho pouzivatela.
     * <p>
     *    Aktualny pouzivatel je pouzivatel co je prave prihlaseny
     *
     * @return      Aktualny pouzivatel
     */
    public Uzivatel getAktualnyPouzivatel(){
        return this.aktualnyPouzivatel;
    }
}
