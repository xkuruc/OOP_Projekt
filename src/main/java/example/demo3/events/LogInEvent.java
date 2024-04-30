package example.demo3.events;

import example.demo3.UI.LoginUI;
import example.demo3.UI.MainUI;
import example.demo3.pouzivatelia.Factory;
import example.demo3.pouzivatelia.Uzivatel;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * vlastna vynimka, ktora signalizuje pouzivatelovi ze nevlozil ani rolu ani meno
 */
class Chybajuce_udaje extends Exception{
    public Chybajuce_udaje(String message){
        super(message);
    }
}
/**
 * vlastna vynimka, ktora signalizuje pouzivatelovi ze nevlozil meno
 */
class Chybajuce_meno extends Exception{
    public Chybajuce_meno(String message){
        super(message);
    }
}
/**
 * vlastna vynimka, ktora signalizuje pouzivatelovi ze nevlozil rolu
 */
class Chybajuca_rola extends Exception{
    public Chybajuca_rola(String message){
        super(message);
    }
}

/**
 * toto je classa, ktora sluzi na prihlasenie pripadne registraciu uzivatela
 * Sluzi na oddelenie aplikacnej logiky od pouzivatelskeho rozhrania vo {@link LoginUI}
 * V pripade nejakych problemov vracia aj vlastné vynimky {@link Chybajuca_rola}, {@link Chybajuce_meno}, {@link Chybajuce_udaje}
 */
public class LogInEvent{
    private UserService userService;
    public LogInEvent(UserService userService){
        this.userService = userService;
    }

    /**
     *Toto je metoda ktora zabezpeci prihlasenie, pripadne registraciu uzivatela
     * Ak nema dostatocne udaje tak vyvolá vlastne vynimky {@link Chybajuca_rola}, {@link Chybajuce_meno}, {@link Chybajuce_udaje}
     * Ak dany pouzivatel podla mena existuje tak ho len prihlasi, ak taky pouzivatel s takym menom neexistuje tak vytvori noveho pouzivatela podla zvolenej roly a mena
     * a potom nastavy aktualneho pouzivatela na daneho pouzivatela
     * @param name meno pouzivatela
     * @param rola zvolena rola
     * @throws Chybajuce_meno vynimka signalizujuca chybajuce meno
     * @throws Chybajuca_rola vynimka signalizujuca chybajucu rolu
     * @throws Chybajuce_udaje vynimka signalizujuca chybajuce udaje, to je ze chyba aj meno aj rola
     */
    public void logIn(String name, String rola) throws Chybajuce_meno, Chybajuca_rola, Chybajuce_udaje{
        if(name.isEmpty() && rola.isEmpty()){
            throw new Chybajuce_udaje("Vypln vsetky udaje!");
        } else if(name.isEmpty() ){
            throw new Chybajuce_meno("Vloz meno !");
        } else if (rola.isEmpty()) {
            throw new Chybajuca_rola("Vyber si rolu !");
        } else{

            Uzivatel uzivatel;
            if( (uzivatel = userService.exists(name)) == null){
                uzivatel = Factory.createUserFactory(rola).createUzivatel(name);
                userService.PridajObjekt(uzivatel);
            }
            userService.setAktualnyPouzivatel(uzivatel);
        }
    }
}
