package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;

import java.util.List;

/**
 * @author angelopalmieri
 * Interfaccia che definisce i metodi che sono implementati nella
 * classe EventoLogicImpl.
 */
public interface EventoLogicInterface {
    /**
     * Questo metodo permette di acquisire un evento dato il suo id.
     * @param idEvento rappresenta l'id dell'evento.
     * @return l'evento associato a idEvento, se invece l'idEvento non
     * esiste allora restituisce null.
     */
    Evento ottieniEventoPerId(int idEvento);

    /**
     * Questo metodo permette di salvare e rendere persistente un evento,
     * volto alla salvaguardia dell'ambiente.
     * @param evento rappresenta l'evento che si vuole rendere persistente.
     * @throws IllegalArgumentException se evento è null oppure,
     * se l'utente che vuole salvare l'evento non è un ecologista oppure,
     * se la lunghezza del nome dell'evento è troppo lunga o troppo corta oppure,
     * se il luogo in cui si svolge l'evento non esiste oppure,
     * se la data e l'ora dell'evento non rispettano il formato adottato oppure,
     * se la data e l'ora dell'evento si trovano nel passato rispetto alla
     * data e all'ora in cui si vuole salvare l'evento,
     * se la lunghezza della descrizione è troppo lunga o troppo corta oppure,
     * se la lunghezza delle altre informazioni è troppo lunga o troppo corta.
     * @return true se l'evento viene reso persistente, false altrimenti.
     */
    boolean salvaEvento(Evento evento);

    /**
     * Questo metodo permette di acquisire tutti gli eventi che si svolgeranno
     * in una data e un'ora futura rispetto alla data e l'ora in cui viene
     * invocato questo metodo.
     * @return una lista contenenti tutti gli eventi che si svolgeranno nel
     * futuro.
     */
    List<Evento> ottieniListaEventiFuturi();

    /**
     * Questo metodo permette di acquisire tutti gli eventi che sono stati creati
     * dagli ecologisti, precedentemente resi persistenti.
     * @return una lista contenente tutti gli eventi volti alla salvaguardia
     * dell'ambiente che sono presenti nel database.
     */
    List<Evento> ottieniListaEventi();
}
