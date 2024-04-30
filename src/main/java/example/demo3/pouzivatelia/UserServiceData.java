package example.demo3.pouzivatelia;
import java.util.ArrayList;

/**
 * toto je classa, v ktorej su definovane nejake hlavne udaje pre pracu s {@link Uzivatel} objektmi
 */
public class UserServiceData {
    public static ArrayList<Uzivatel> uzivatelArrayList;
    public ArrayList<Uzivatel> returnObjectArray(){
        return uzivatelArrayList;
    }
}
