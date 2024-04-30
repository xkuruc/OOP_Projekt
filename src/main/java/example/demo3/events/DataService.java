package example.demo3.events;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Toto je genericke rozhranie, ktore vyuzivaju {@link ImageService} a {@link UserService}
 * <p>
 *    Su v nej definovane spolocne metody, ktore vyuzivaju obidva {@link ImageService} a {@link UserService}
 *
 */
public interface DataService<T> {
    public ArrayList<T> returnObjectArray();
    /**
     * Metoda na ulozenie daneho objektu
     * V v mojom programe sa pouziva na ulozenie {@link ImageEntity} a {@link  example.demo3.pouzivatelia.Uzivatel} Objektov
     */
    public String SaveData(T data, Stage stage);
    /**
     * Metoda na vytvorenie statickych objektov
     * V v mojom programe sa pouziva na vytvorenie {@link ImageEntity} a {@link  example.demo3.pouzivatelia.Uzivatel} Objektov,
     * To sluzi na to, aby ked sa pouzivatel prihlasi prvykrat do programu, aby tam aj nieco uz bolo
     */
    public void VytvorStatickeObjekty();

    /*public void ReadData(String database, String collection);
    public ArrayList<T> ReturnData();

    //public T getElementById(String ID, String database, String collection);

    public void UpdateData(String filterField, String filterValue, String updateField, String updateValue, String database, String collection);

    //vrati celkovy pocet pouzivatelov, abo celkovy pocet obrazkov
    default int ReturnNumberOfData(String databaza, String kolekcia){return 0;};
    //treba nejakú defaultnu metódu tu vymyslieť kamo dopici*/

    /**
     * Vo {@link ImageService} a aj vo {@link UserService} je pole vsetkych obrazkov (resp uzivatelov),
     * No a tato defualt metoda sluzi na pridanie Objektov ({@link ImageEntity} a {@link example.demo3.pouzivatelia.Uzivatel}) do tejto kolekcie
     *
     */
    default public void PridajObjekt(T o){
        returnObjectArray().add(o);
    }
}
