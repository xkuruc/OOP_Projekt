package example.demo3.events;

import example.demo3.pouzivatelia.Uzivatel;

import java.net.URL;
import java.util.ArrayList;

public class ImageEntity {
    private String popis;
    private String autor;
    private String url;
    private ArrayList<Integer> hodnotenieObrazka;
    private ArrayList<Uzivatel> uzivateliaCoHodnotili;
    public ImageEntity(){
        this("Anonym", "test", null);
    }
    public ImageEntity(String autor, String popis, String url){
        this.autor = autor;
        this.popis = popis;
        this.url = url;
        this.hodnotenieObrazka = new ArrayList<>();
        this.uzivateliaCoHodnotili = new ArrayList<>();
    }
    public String getPopis(){return this.popis;}
    public String getAutor(){return this.autor;}
    public void setPopis(String popis){this.popis = popis;}
    public void setAutor(String autor){this.autor = autor;}
    public String getUrl(){return this.url;}
    public void setUrl(String url){ this.url = url;}
    public ArrayList<Integer> getHodnotenie(){return this.hodnotenieObrazka;}
    public void updateHodnotenie(Uzivatel uzivatel, int hodnotenie){
        int i=0;
        for(Uzivatel uzivatel1 : this.uzivateliaCoHodnotili){
            if(uzivatel1.getMeno().equals(uzivatel.getMeno())){
                this.hodnotenieObrazka.set(i, hodnotenie);
                return;
            }
            i++;
        }
        this.uzivateliaCoHodnotili.add(uzivatel);
        this.hodnotenieObrazka.add(hodnotenie);
    }
    public ArrayList<Uzivatel> getUzivateliaCoHodnotili(){return this.uzivateliaCoHodnotili;}
}
