package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;

import java.util.List;

/**
 * @author angelopalmieri
 * Interfaccia che definisce i metodi che sono implementati
 * nella classe EventoDAOImpl
 */
public interface EventoDAOInterface {
    /**
     * Questo metodo permette di acquisire un evento dato il suo id.
     * @param idEvento rappresenta l'id dell'evento.
     * @return l'evento associato a idEvento, se invece l'idEvento non
     * esiste allora restituisce null.
     */
    Evento doRetrieveById(int idEvento);

    /**
     * Questo metodo permette di salvare un evento, volto alla salvaguardia
     * dell'ambiente, all'interno del database.
     * @param evento rappresenta l'evento che si vuole salvare nel database.
     * @return true se l'evento viene salvato correttamente all'interno del
     * database, false altrimenti.
     */
    boolean doSaveEvento(Evento evento);

    /**
     * Questo metodo permette di acquisire tutti gli eventi che si svolgeranno
     * in una data e un'ora futura rispetto alla data e l'ora in cui viene
     * invocato questo metodo.
     * @return una lista contenenti tutti gli eventi che si svolgeranno nel
     * futuro.
     */
    List<Evento> doRetrieveAfterCurrentDate();

    /**
     * Questo metodo permette di acquisire tutti gli eventi che sono stati creati
     * dagli ecologisti, precedentemente salvati nel database.
     * @return una lista contenente tutti gli eventi volti alla salvaguardia
     * dell'ambiente che sono presenti nel database.
     */
    List<Evento> doRetrieveAll();
}
