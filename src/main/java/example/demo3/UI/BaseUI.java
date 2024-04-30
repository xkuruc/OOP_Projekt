package example.demo3.UI;

import example.demo3.events.DataServiceManager;
import javafx.stage.Stage;

//aby si len vedel, keby si neiplmementoval tu UISetup interface, tak to je template design pattern
//ze zrobis si takuto abstraktnu nadtriedu, a jej deti iba prepisuju jej metody, a potom vytvoris instanciu podtriedy ale na BaseUI (na nadtriede),
// a zavolas funkciu, ktoru nemaju zadefinovanu, ako teraz setupUI, a sa zavola ich vlastna implementacia setupContent

/**
 * toto je spolocna classa pre vsetky pouzivatelskeho rozhrania, definuje nejake spolocne vlastne metody a funkcionality
 * - {@link UISetup}
 * Sluzi hlavne na vytvorenie {@link HornaLista} a {@link example.demo3.NewHornaLista}
 */
public abstract class BaseUI extends DataServiceManager implements UISetup{
    protected abstract void setupContent(Stage stage);
    @Override
    public void setupUI(Stage stage) {
        setupContent(stage);
    }

    @Override
    public void stageSetup(Stage stage, int width, int height){
        stage.setTitle(getTitle());
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setResizable(false);
    }

    protected abstract String getTitle();

}
