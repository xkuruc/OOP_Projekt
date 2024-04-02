package example.demo3.pouzivatelia;

public class Factory {
    public static class NovyFactory implements UzivatelFactory{
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Novy(meno);
        }
    }
    public static class ProffesionalFactory implements UzivatelFactory {
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Profesional(meno);
        }
    }
    public static class AmaterFactory implements UzivatelFactory{
        @Override
        public Uzivatel createUzivatel(String meno) {
            return new Amater(meno);
        }
    }
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
