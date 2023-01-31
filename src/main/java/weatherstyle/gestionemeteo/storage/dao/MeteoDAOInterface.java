package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

/**
 * Interfaccia Meteo dao interface.
 *
 * @author Francesco Giuseppe Zammarrelli Interfaccia per i metodi del package gestionemeteo.storage.dao
 */
public interface MeteoDAOInterface {
    /**
     * Metodo per recupare un istanza di meteoDaily avendo l'id suggerimento a cui fa riferimento
     * @param idSuggerimento
     * @return un istanza di MeteoDailyMin se esiste un suggerimento con id = idSuggerimento, null altrimenti
     */
    MeteoDailyMin doRetrieveMeteoBySuggerimentoID(int idSuggerimento);

    /**
     * Metodo per salvare un istanza di MeteoDailyMin nel database.
     * @param meteo
     * @return true se il salvataggio avviene correttamente, false altrimenti
     */
    boolean doSaveMeteo(MeteoDailyMin meteo);
}
