package example.demo3.pouzivatelia;

import example.demo3.events.ImageEntity;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public abstract class Uzivatel {
    private String meno;
    private String rola;
    private String lajk;
    private ArrayList<Integer> hodnotenia;
    private ArrayList<ImageEntity> ohodnoteneObrasky;

    public void updateHodnotenie(ImageEntity imageEntity, int hodnotenie){
        int i=0;
        for( ImageEntity imageEntity1 : getOhodnoteneObrasky() ){
            if(imageEntity1.getUrl().equals(imageEntity.getUrl())){
                getHodnotenia().set(i, hodnotenie);
                System.out.println(hodnotenie + "cojedopici!!!!");
                return;
            }
            i++;
        }
        getOhodnoteneObrasky().add(imageEntity);
        getHodnotenia().add(hodnotenie);
        System.out.println(hodnotenie + "!!!!");
    }

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

    public void setMeno(String meno){this.meno=meno;}
    public void setRola(String rola){this.rola=rola;}
    public void setLajk(String lajk){this.lajk=lajk;}
}
