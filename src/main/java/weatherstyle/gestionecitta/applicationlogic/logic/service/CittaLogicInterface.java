package weatherstyle.gestionecitta.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * interfaccia che definisce i servizi disponibili nel package gestionecitta
 */
public interface CittaLogicInterface {

    boolean salvaCitta(Citta citta);
    List<Citta> ottieniCittaByName(String name);

}
