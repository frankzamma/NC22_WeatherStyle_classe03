package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;

import java.util.List;

/**
 * @author Annalaura Miglino
 * L'interfaccia <code>CapoAbbigliamentoDAOInterface</code> ha,
 * al suo interno, tutti i metodi per poter gestire
 * i dati presenti nel database di tutti i capi d'abbigliamento.
 */

public interface  CapoAbbigliamentoDAOInterface {

    /**
     * Cerca un capo d'abbigliamento in base all'ID.
     * @param idCapoAbbigliamento è l'ID del capo da cercare.
     * @return il capo d'abbigliamento corrispondente.
     */
    CapoAbbigliamento doRetrieveCapoById(int idCapoAbbigliamento);

    /**
     * Cerca una maglia in base all'ID.
     * @param idCapoAbbigliamento è l'ID della maglia da cercare.
     * @return la maglia all'ID corrispondente.
     */
    Maglia doRetrieveMagliaByIdCapoAbbigliamento(int idCapoAbbigliamento);

    /**
     * Cerca un paio di pantaloni in base all'ID.
     * @param idCapoAbbigliamento è l'ID dei pantaloni da cercare.
     * @return i pantaloni con l'ID corrispondente.
     */
    Pantaloni doRetrievePantaloniByIdCapoAbbigliamento(int idCapoAbbigliamento);

    /**
     * Cerca un paio di scarpe in base all'ID.
     * @param idCapoAbbigliamento è l'ID delle scarpe da cercare.
     * @return le scarpe con l'ID corrispondente.
     */
    Scarpe doRetrieveScarpeByIdCapoAbbigliamento(int idCapoAbbigliamento);

    /**
     * Salva una maglia nel database
     * @param m è la maglia da salvare.
     * @return vero se il salvataggio è andato a buon fine, falso altrimenti.
     */
    boolean doSaveMaglia(Maglia m, int idGuardaroba);

    /**
     * Salva un paio di pantaloni nel database
     * @param p è il paio di pantaloni da salvare.
     * @return vero se il salvataggio è andato a buon fine, falso altrimenti.
     */
    boolean doSavePantaloni(Pantaloni p, int idGuardaroba);

    /**
     * Salva un paio di scarpe nel database
     * @param s è il paio di pantaloni da salvare.
     * @return vero se il salvataggio è andato a buon fine, falso altrimenti.
     */
    boolean doSaveScarpe(Scarpe s, int idGuardaroba);

    /**
     * Permette di ottenere la lista di maglia presenti nel guardaroba.
     * @param idG è l'ID del guardaroba.
     * @return la lista di maglie nel guardaroba.
     */
    List<Maglia> doRetrieveMaglieByIdGuardaroba (int idG);

    /**
     * Permette di ottenere la lista di pantaloni presenti nel guardaroba.
     * @param idG è l'ID del guardaroba.
     * @return la lista di pantaloni nel guardaroba.
     */
    List<Pantaloni> doRetrievePantaloniByIdGuardaroba (int idG);

    /**
     * Permette di ottenere la lista di scarpe presenti nel guardaroba.
     * @param idG è l'ID del guardaroba.
     * @return la lista di scarpe nel guardaroba.
     */
    List<Scarpe> doRetrieveScarpeByIdGuardaroba (int idG);

}
