package weatherstyle.gestionecitta.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.util.List;

/**
 * @author Raffaele Aurucci
 * interfaccia che definisce i metodi che deve avere CittaDAO
 */
public interface CittaDAOInterface {

    boolean doSaveCitta(Citta citta);
    Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento);
    List<Citta> doRetrieveCittaPreferiteByUtenteID(int idUtente);
    boolean doSaveCittaByUtenteID(int idUtente,Citta citta);
}
