package example.demo3.pouzivatelia;

import example.demo3.events.ImageEntity;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
/**
 * Toto je spolocna trieda pre vsetky typy uzivatelov vo programe
 * <p>
 *     v tejto abstraktnej triede su definovane vsetky spolocne atributy a metody, ktore pouzivaju uzivatelia
 *     Zatial mam v programe 3 typy pouzivatelov- {@link Profesional} {@link Amater} a {@link Novy}
 * </p>
 */
public abstract class Uzivatel {
    private String meno;
    private String rola;
    private String lajk;
    /**
     * to je ArrayList, ktory obsahuje ciselne hodnotenia obrazkov, ktore sa nachadzaju na rovnakom indexe vo {@link #ohodnoteneObrasky}
     */
    private ArrayList<Integer> hodnotenia;
    /**
     * to je ArrayList, ktory obsahuje obrazky, ktore boli ohodnotene, ich hodnotenie sa nachadza na rovnakom indexe vo {@link #hodnotenia}
     */
    private ArrayList<ImageEntity> ohodnoteneObrasky;

    /**
     * Toto updatuje hodnotenie pre dany obrazok, obrazok je reprezentovany ako {@link ImageEntity} objekt
     *
     * <p>
     *     vyuziva sa to hlavne pri opakovanom hlasovani pre ten isty obrazok
     * </p>
     * @param imageEntity to je ten obrazok, pre ktory chceme zmenit ohodnotenie aktualnym pouzivatelom
     * @param hodnotenie to je nove hodnotenie, ktore chceme aby ten obrazok mal ponovom
     */
    public void updateHodnotenie(ImageEntity imageEntity, int hodnotenie){
        int i=0;
        for( ImageEntity imageEntity1 : getOhodnoteneObrasky() ){
            if(imageEntity1.getUrl().equals(imageEntity.getUrl())){
                getHodnotenia().set(i, hodnotenie);
                return;
            }
            i++;
        }
        getOhodnoteneObrasky().add(imageEntity);
        getHodnotenia().add(hodnotenie);
    }

    /**
     * To sluzi na ziskanie indexu ohodnotenie pre dany obrazok
     * <p>
     *     Pretoze kazdy pouzivatel ma ako atribut dva polia, {@link #ohodnoteneObrasky} ktore sluzia na ulozenia obrazkov, ktore dany pouzivatel ohodnotil a
     *     {@link #hodnotenia}, ktore obsahuje uz konretne ohodnotenia obrazkov na danom indexe
     *     A tato metoda sluzi na urcenie indexu daneho obrazka aby sme potom vedeli urcit jeho ohodnotenie
     * </p>
     * @param imageEntity to je ten obrazok, ktoreho index chceme zistit
     * @return vracia index daneho obrazka
     */

    public int getIndexOhodnotenia(ImageEntity imageEntity){
        int i =0;
        for(ImageEntity imageEntity1: getOhodnoteneObrasky()){
            if(imageEntity1.getUrl().equals(imageEntity.getUrl())){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Uzivatel(){
        this("Neznamy", "Amater", "" );
    }
    public Uzivatel(String meno, String rola, String lajk){
        this.meno = meno;
        this.rola = rola;
        this.lajk = lajk;
        this.hodnotenia = new ArrayList<>();
        this.ohodnoteneObrasky = new ArrayList<>();
    }
    public abstract void dajLajk();

    public String getMeno(){return this.meno;}
    public String getRola(){return this.rola;}
    public String getLajk(){return this.lajk;}

    public ArrayList<Integer> getHodnotenia() {
        return hodnotenia;
    }

    public ArrayList<ImageEntity> getOhodnoteneObrasky() {
        return ohodnoteneObrasky;
    }
    public void setHodnotenia(ArrayList<Integer> hodnotenia){
        this.hodnotenia = hodnotenia;
    }
    public void setOhodnoteneObrasky(ArrayList<ImageEntity> ohodnoteneObrasky){
        this.ohodnoteneObrasky = ohodnoteneObrasky;
    }

    public void setMeno(String meno){this.meno=meno;}
    public void setRola(String rola){this.rola=rola;}
    public void setLajk(String lajk){this.lajk=lajk;}
}
