package MainWindow;

import javafx.beans.property.SimpleStringProperty;

public class BBA {
    /**
     * Klasse BBA, hinzufügen der relevanten Größen für Brandbekämpfungsabschnitte!
     */
    public  String name;
    public int anzahlTB = 0;

    public BBA(String name) {
        this.name = new String(name);
    }

    public  String getName() {
        return name;
    }

    public int getAnzahlTB() {
        return anzahlTB;
    }

    /**
     * Ermöglicht die Ausgabeb der ArrayList bbaListe mit den vergebenen Namen der BBA's
      * @return
     */
    @Override
    public String toString() {
        return name;
    }

}
