package example.demo3.pouzivatelia;

/**
 * Dalsia moznost Uzivatela
 * <p>
 *     tento typ uzivatela bude moct pridavat fotky a bude moct hodnotit obrazky (ale iba obycajne hodnotenie)
 * </p>
 */
public class Amater extends Uzivatel{
    public Amater(String name){
        super(name, "Amater","");
    }
    @Override
    public void dajLajk(){
        System.out.println(getRola() + " "+getMeno()+" Dal like, akoze amater");
    }
}
