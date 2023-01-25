package weatherstyle.gestionecitta.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

public interface CittaLogicInterface {

    boolean salvaCitta(Citta citta);
    List<Citta> recuperaCittaDaSuggerimentiID(List<Integer> idSuggerimenti);
    List<Citta> ottieniCittaByName(String name);

}
