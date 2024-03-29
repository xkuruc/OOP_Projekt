package example.demo3.pouzivatelia;

public class Amater extends Uzivatel{
    public Amater(String name){
        super(name, "Amater","");
    }
    @Override
    public void dajLajk(){
        System.out.println(getRola() + " "+getMeno()+" Dal like, akoze amater");
    }
}
