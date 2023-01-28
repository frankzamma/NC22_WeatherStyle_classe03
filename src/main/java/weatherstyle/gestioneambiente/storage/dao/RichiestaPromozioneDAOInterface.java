package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

/**
 * @author angelopalmieri
 * Interfaccia che definisce i metodi che sono implementati
 * dalla classe RichiestaPromozioneDAOImpl
 */
public interface RichiestaPromozioneDAOInterface {

    /**
     * Questo metodo permette di salvare una richiesta di promozione
     * all'interno del database.
     * @param richiestaPromozione rappresenta la richiesta di promozione
     *                            che si vuole salvare nel database.
     * @return true se la richiesta di promozione è stata salvata correttamente
     * nel database, false altrimenti.
     */
    boolean doSaveRichiestaPromozione(RichiestaPromozione richiestaPromozione);

    /**
     * Questo metodo permette di acquisire tutte le richieste di promozione
     * che sono state salvate nel database precedentemente.
     * @return una lista contenente tutte le richieste di promozione
     * presenti nel database.
     */
    List<RichiestaPromozione> doRetrieveAll();

    /**
     * Questo metodo permette di aggiornare lo stato di una certa richiesta di promozione.
     * @param richiestaPromozione rappresenta la richiesta di promozione di cui si vuole
     *                            aggiornare lo stato.
     * @param nuovoStato rappresenta il nuovo stato in cui si trova la richiesta di promozione.
     * @param admin rappresenta l'amministratore che sta eseguendo la modifica e che quindi
     *              ha deciso se approvare o rifiutare la richiesta di promozione.
     * @return true l'aggiornamento viene eseguito correttamente, false altrimenti.
     */
    boolean doUpdateStato(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin);

    /**
     * Questo metodo permette di acquisire tutte le richieste di promozione che si trovano
     * in un determinato stato.
     * @param stato rappresenta lo stato delle richieste di promozione che si vuole acquisire.
     * @return una lista contenente tutte le richieste di promozione che hanno lo stato
     * uguale a quello passato come parametro.
     */
    List<RichiestaPromozione> doRetrieveRichiestaPromozioneByStato(String stato);

    /**
     * Questo metodo permette di acquisire la richiesta di promozione effettuata da un
     * utente dato il suo id.
     * @param idUtente rappresenta l'id di un utente.
     * @return la richiesta di promozione associata a idUtente, se invece l'utente non
     * ha mai richiesto la promozione oppure l'id non esiste allora restituisce null.
     */
    RichiestaPromozione doRetrieveByIdUtente(int idUtente);

    /**
     * Questo metodo permette di acquisire una richiesta di promozione dato il suo id.
     * @param idRichiestaPromozione rappresenta l'id di una richiesta di promozione
     * @return la richiesta di promozione associata a idRichiestaPromozione, se non
     * esiste allora restituisce null.
     */
    RichiestaPromozione doRetrieveById(int idRichiestaPromozione);

}
