package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;

/**
* @author Raffaele Aurucci
* interfaccia che definisce i metodi che deve avere SuggerimentoDAO
*/
public interface SuggerimentoDAOInterface {

    boolean doSaveSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> doRetrieveCronologiaSuggerimentiByUtenteID(int utenteID);

}
