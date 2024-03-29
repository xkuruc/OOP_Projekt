package example.demo3;

public class Profesional extends Uzivatel{
    public Profesional(String name){
        super(name, "Profesional","");
    }
    @Override
    public void dajLajk(){
        System.out.println(getRola() + " "+getMeno()+" Dal like, akoze Profesional");
    }
}
