package example.demo3.pouzivatelia;

/**
 * toje je Factory pattern so vnorenymi classami, ktore sluzia na vytvorenie daneho uzivatela
 * Tymto sposobom som zarucil ze moj program je otvoreny zmenam a modifikaciam
 */
public class Factory {
    /**
     * Sluzi na vytvorenie uzivatela typu "Novy"
     */
    public static class NovyFactory implements UzivatelFactory{
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Novy(meno);
        }
    }
    /**
     * Sluzi na vytvorenie uzivatela typu "Proffesional"
     */
    public static class ProffesionalFactory implements UzivatelFactory {
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Profesional(meno);
        }
    }
    /**
     * Sluzi na vytvorenie uzivatela typu "Amater"
     */
    public static class AmaterFactory implements UzivatelFactory{
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Amater(meno);
        }
    }
    /**
     * Sluzi na vytvorenie uzivatela typu urceneho podla stringu
     * @param userType sluzi na urcenie typu uzivatela a nasledne vytvorenie uzivatela daneho typu
     * @return vrati spravny uzivatel factory, podla ktoreho sa vytvori spravny typ uzivatela
     */
    public static UzivatelFactory createUserFactory(String userType) {
        switch (userType) {
            case "Profesional":
                return new Factory.ProffesionalFactory();
            case "Novy":
                return new Factory.NovyFactory();
            case "Amater":
                return new Factory.AmaterFactory();
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }

}
