package example.demo3.pouzivatelia;

import example.demo3.events.ImageEntity;

/**
 * Dalsia moznost Uzivatela
 * <p>
 *     tento typ uzivatela ma najviac privilegii
 *     Moze pridavat lubovolny pocet fotiek, moze hlasovat fotky, ma pristup ku super hodnoteniu, ktore dava obrazku vyrazny naskok, toto super hodnotenie je vsak uplatitelne iba na jeden obrazok
 *
 * </p>
 */
public class Profesional extends Uzivatel{
    private int superHodnotenie;
    private ImageEntity superHodnotenieImage;
    public Profesional(String name){
        super(name, "Profesional","");
        this.superHodnotenie = 0;
    }
    public int getSuperHodnotenie(){
        return this.superHodnotenie;
    }
    public void setSuperHodnotenie(int superHodnotenie){
        this.superHodnotenie = superHodnotenie;
    }
    public ImageEntity getSuperHodnotenieImage(){
        return this.superHodnotenieImage;
    }
    public void setSuperHodnotenieImage(ImageEntity imageEntity){
        this.superHodnotenieImage = imageEntity;
    }
    public void vymazSuperHodnotenie(){
        setSuperHodnotenie(0);
        setSuperHodnotenieImage(null);
    }
    @Override
    public void dajLajk(){
        System.out.println(getRola() + " "+getMeno()+" Dal like, akoze Profesional");
    }
}
