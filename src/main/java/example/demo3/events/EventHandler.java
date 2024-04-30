package example.demo3.events;

/**
 * Toto je interface, ktore pouzivaju vacsina Buttonov vo programe,
 * Pouziva sa vo strategy pattern
 * @see example.demo3.button.ButtonFactory
 */
public interface EventHandler  {
    void handle();
}
