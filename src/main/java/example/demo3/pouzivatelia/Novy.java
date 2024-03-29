package example.demo3;

public class Novy extends Uzivatel{
    public Novy(String name){
        super(name, "Novy", "");
    }
    @Override
    public void dajLajk(){
        System.out.println(getMeno()+" "+getMeno()+" Dal like, akoze Novy");
    }
}
