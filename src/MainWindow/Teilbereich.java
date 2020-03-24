package MainWindow;

import javafx.beans.property.SimpleStringProperty;

public class Teilbereich {

    public String name;

    public Teilbereich(String name) {
        this.name = new String(name);
    }

    public  String getName() {
        return name;
    }

    public void setName ( String n ) {
        name = n;
    }


    /**
     * Ermöglicht die Ausgaben der ArrayList bbaListe mit den vergebenen Namen der BBA's
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
}

