package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

/**
 * @author angelopalmieri
 * Interfaccia che definisce i metodi che sono implementati nella
 * classe RichiestaPromozioneLogicImpl.
 */
public interface RichiestaPromozioneLogicService {

    /**
     * Questo metodo permette di acquisire la richiesta di promozione effettuata da un
     * utente dato il suo id.
     * @param idUtente rappresenta l'id di un utente.
     * @return la richiesta di promozione associata a idUtente, se invece l'utente non
     * ha mai richiesto la promozione oppure l'id non esiste allora restituisce null.
     */
    RichiestaPromozione ottieniRichiestaPromozionePerIdUtente(int idUtente);

    /**
     * Questo metodo permette di salvare una richiesta di promozione
     * e renderla persistente.
     * @param richiestaPromozione rappresenta la richiesta di promozione
     *                            che si vuole rendere persistente.
     * @throws IllegalArgumentException se richiestaPromozione è null oppure,
     * se l'utente ha già effettuato una richiesta di promozione oppure,
     * se mancano le tematiche d'interesse ambientale oppure,
     * se la stringa che rappresenta l'esperienze è troppo lunga o troppo corta.
     * @return true se la richiesta di promozione è stata resa persistente,
     * false altrimenti.
     */
    boolean salvaRichiestaPromozione(RichiestaPromozione richiestaPromozione);

    /**
     * Questo metodo permette di acquisire tutte le richieste di promozione
     * che sono state rese persistenti precedentemente.
     * @return una lista contenente tutte le richieste di promozione
     * presenti nel database.
     */
    List<RichiestaPromozione> ottieniListaRichiestePromozione();

    /**
     * Questo metodo permette di acquisire tutte le richieste di promozione che si trovano
     * in un determinato stato.
     * @param stato rappresenta lo stato delle richieste di promozione che si vuole acquisire.
     * @throws IllegalArgumentException se stato è null oppure,
     * se la stringa stato è diverso da "in attesa", "approvata" e "rifiutata"
     * @return una lista contenente tutte le richieste di promozione che hanno lo stato
     * uguale a quello passato come parametro.
     */
    List<RichiestaPromozione> ottieniListaRichiestePromozionePerStato(String stato);

    /**
     * Questo metodo permette di aggiornare lo stato di una certa richiesta di promozione.
     * @param richiestaPromozione rappresenta la richiesta di promozione di cui si vuole
     *                            aggiornare lo stato.
     * @param nuovoStato rappresenta il nuovo stato in cui si trova la richiesta di promozione.
     * @param admin rappresenta l'amministratore che sta eseguendo la modifica e che quindi
     *              ha deciso se approvare o rifiutare la richiesta di promozione.
     * @throws IllegalArgumentException se richiestaPromozione è null oppure,
     * se lo stato in cui si trova richiestaPromozione è diverso da "in attesa",
     * perché significherebbe che la richiesta è stata già valutata, oppure,
     * se nuovoStato è null oppure,
     * se la stringa nuovoStato è diversa da "in attesa", "approvata" e "rifiutata" oppure,
     * se admin è null dato che solo gli amministratori possono eseguire questa operazione.
     * @return true l'aggiornamento viene eseguito correttamente, false altrimenti.
     */
    boolean aggiornaStatoRichiestaPromozione(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin);

    /**
     * Questo metodo permette di acquisire una richiesta di promozione dato il suo id.
     * @param idRichiestaPromozione rappresenta l'id di una richiesta di promozione
     * @return la richiesta di promozione associata a idRichiestaPromozione, se non
     * esiste allora restituisce null.
     */
    RichiestaPromozione ottieniRichiestaPromozionePerId(int idRichiestaPromozione);

}
