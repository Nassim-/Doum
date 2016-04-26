package nassim.doum.models;

/**
 * Created by tread on 18/04/2016.
 */
public class AppData {

    public static Utilisateur User;
    public static Chariot chariot;

    public AppData() {
        AppData.chariot = new Chariot();
    }

    public static Chariot getChariot() {
        return chariot;
    }

    public static void setChariot(Chariot chariot) {
        AppData.chariot = chariot;
    }

}
