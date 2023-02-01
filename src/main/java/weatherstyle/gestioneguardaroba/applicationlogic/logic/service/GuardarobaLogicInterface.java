package weatherstyle.gestioneguardaroba.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.utils.ErrorParameterException;

import java.util.List;

/**
 @author Annalaura Miglino
 L'interfaccia rappresenta le operazioni eseguibili su un guardaroba.
 */

public interface GuardarobaLogicInterface {
    /**
     * Il metodo salva una maglia nel guardaroba.
     * @param m è la maglia da salvare.
     * @param idGuardaroba è l'ID del guardaroba in cui salvare la maglia.
     * @return true se il salvataggio è andato a buon fine, false altrimenti.
     * @throws ErrorParameterException
     */
    boolean salvaMaglia(Maglia m,int idGuardaroba) throws ErrorParameterException;

    /**
     * Il metodo salva dei pantaloni nel guardaroba.
     * @param p è il paio di pantaloni da salvare.
     * @param idGuardaroba è l'ID del guardaroba in cui salvare i pantaloni.
     * @return true se il salvataggio è andato a buon fine, false altrimenti.
     * @throws ErrorParameterException
     */
    boolean salvaPantaloni(Pantaloni p,int idGuardaroba) throws ErrorParameterException;

    /**
     * Il metodo salva delle scarpe nel guardaroba.
     * @param s è il paio di scarpe da salvare.
     * @param idGuardaroba è l'ID del guardaroba in cui salvare le scarpe.
     * @return true se il salvataggio è andato a buon fine, false altrimenti.
     * @throws ErrorParameterException
     */
    boolean salvaScarpe(Scarpe s,int idGuardaroba) throws ErrorParameterException;

    /**
     * Il metodo permette di ottenere tutte le maglie di un guardaroba.
     * @param idUtente è l'ID del guardaroba, che corrisponde all'ID dell'utente.
     * @return la lista di maglie nel guardaroba.
     */
    List<Maglia> getMaglie(int idUtente);

    /**
     * Il metodo permette di ottenere tutti i pantaloni di un guardaroba.
     * @param idUtente è l'ID del guardaroba, che corrisponde all'ID dell'utente.
     * @return la lista di pantaloni nel guardaroba.
     */
    List<Pantaloni> getPantaloni(int idUtente);

    /**
     * Il metodo permette di ottenere tutte le scarpe di un guardaroba.
     * @param idUtente è l'ID del guardaroba, che corrisponde all'ID dell'utente.
     * @return la lista di scarpe nel guardaroba.
     */
    List<Scarpe> getScarpe(int idUtente);

    /**
     * Il metodo permette di ottenere tutti i capi d'abbigliamento di un guardaroba.
     * @param idUtente è l'ID del guardaroba, che corrisponde all'ID dell'utente.
     * @return è la lista di tutti i capi d'abbigliamento presenti nel guardaroba.
     */
    List<CapoAbbigliamento> getAll(int idUtente);

    /**
     * Il metodo permette di aggiornare il numero dei capi d'abbigliamento in un guardaroba.
     * @param idUtente è l'ID del guardaroba, che corrisponde all'ID dell'utente.
     * @return true se l'aggiornamento è andato a buon fine, false altrimenti.
     */
    boolean aggiornaNumeroCapi(int idUtente);
}
