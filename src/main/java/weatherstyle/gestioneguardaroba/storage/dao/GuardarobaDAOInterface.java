package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;

/**
 * @author Annalaura Miglino
 * L'interfaccia <code>GuardarobaDAOInterface</code> ha,
 * al suo interno, tutti i metodi per poter gestire
 * i dati presenti nel database di un guardaroba.
 */

public interface GuardarobaDAOInterface {

    /**
     * Questo metodo permette di ottenere un guardaroba dal suo ID.
     * @param id è l'ID dell'utente associato al guardaroba.
     * @return il guardaroba associato a quell'ID.
     */
    Guardaroba doRetrieveGuardarobaById(int id);

    /**
     * Questo metodo salva un guardaroba nel database.
     * @param idUtente salva il guardaroba con lo stesso ID dell'utente
     *                 che lo possiede.
     * @return vero se il guardaroba è stato creato, falso altrimenti.
     */
    boolean doSaveGuardaroba(int idUtente);

    /**
     * Restituisce il numero di capi presenti nel guardaroba.
     * @param idUtente è l'ID del guardaroba, che è uguale a quello dell'utente.
     * @return il numero di capi nel guardaroba.
     */
    int doRetrieveNumeroCapi(int idUtente);

    /**
     * Setta il numero di capi nel guardaroba.
     * @param idUtente è l'ID del guardaroba, che è uguale a quello dell'utente.
     * @param numero è il numero di capi da settare.
     * @return true se la modifica è andato a buon fine, false altrimenti.
     */
    boolean doSaveNumeroCapi(int idUtente,int numero);


}
