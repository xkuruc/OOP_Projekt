package example.demo3;

public abstract class Uzivatel {
    private String meno;
    private String rola;
    private String lajk;
    public Uzivatel(){
        this("Neznamy", "Amater", "" );
    }
    public Uzivatel(String meno, String rola, String lajk){
        this.meno = meno;
        this.rola = rola;
        this.lajk = lajk;
    }
    public abstract void dajLajk();

    public String getMeno(){return this.meno;}
    public String getRola(){return this.rola;}
    public String getLajk(){return this.lajk;}

    public void setMeno(String meno){this.meno=meno;}
    public void setRola(String rola){this.rola=rola;}
    public void setLajk(String lajk){this.lajk=lajk;}
}
