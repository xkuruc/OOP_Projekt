package example.demo3.pouzivatelia;

/**
 * Dalsia moznost Uzivatela
 * <p>
 *     tento typ uzivatela ma najmensie prava, najmensie privilegia
 *     Nemoze pridavat fotky, nemoze hlasovat, moze si iba prezerat fotky
 * </p>
 */
public class Novy extends Uzivatel{
    public Novy(String name){
        super(name, "Novy", "");
    }
    @Override
    public void dajLajk(){
        System.out.println(getMeno()+" "+getMeno()+" Dal like, akoze Novy");
    }
}
