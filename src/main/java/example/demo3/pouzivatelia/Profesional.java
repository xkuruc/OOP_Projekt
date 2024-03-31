package example.demo3.pouzivatelia;

import example.demo3.events.ImageEntity;


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
