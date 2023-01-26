package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;

/**
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


}
