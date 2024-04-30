package example.demo3.pouzivatelia;
/**
 * Toto je interface, ktory sa pouziva vo factory patterne na vytvorenie spravneho typu uzivatela
 */
public interface UzivatelFactory {
    Uzivatel createUzivatel(String meno);
}
