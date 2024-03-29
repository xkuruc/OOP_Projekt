package example.demo3;

import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public abstract class Uzivatel {
    private String meno;
    private String rola;
    private String lajk;
    private ArrayList<ToggleGroup> toggleGroup;
    public Uzivatel(){
        this("Neznamy", "Amater", "" );
    }
    public Uzivatel(String meno, String rola, String lajk){
        this.meno = meno;
        this.rola = rola;
        this.lajk = lajk;
        this.toggleGroup = null;
    }
    public abstract void dajLajk();

    public String getMeno(){return this.meno;}
    public String getRola(){return this.rola;}
    public String getLajk(){return this.lajk;}
    public ArrayList<ToggleGroup> getToggleGroup(){
        return this.toggleGroup;
    }
    public void setToggleGroup(ArrayList<ToggleGroup> toggleGroup ){
        this.toggleGroup = toggleGroup;
    }

    public void setMeno(String meno){this.meno=meno;}
    public void setRola(String rola){this.rola=rola;}
    public void setLajk(String lajk){this.lajk=lajk;}
}
