package example.demo3.events;

import javafx.stage.Stage;

import java.util.ArrayList;

public interface DataService<T> {
    public ArrayList<T> returnObjectArray();
    public String SaveData(T data, Stage stage);
    public void VytvorStatickeObjekty(); //toto vytvori natvrdo nejakých začiatočných použivateľov a nejaké obrázky

    /*public void ReadData(String database, String collection);
    public ArrayList<T> ReturnData();

    //public T getElementById(String ID, String database, String collection);

    public void UpdateData(String filterField, String filterValue, String updateField, String updateValue, String database, String collection);

    //vrati celkovy pocet pouzivatelov, abo celkovy pocet obrazkov
    default int ReturnNumberOfData(String databaza, String kolekcia){return 0;};
    //treba nejakú defaultnu metódu tu vymyslieť kamo dopici*/
    default public void PridajObjekt(T o){
        returnObjectArray().add(o);
    }
}
