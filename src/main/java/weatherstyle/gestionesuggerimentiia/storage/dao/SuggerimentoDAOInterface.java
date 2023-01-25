package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;

public interface SuggerimentoDAOInterface {

    boolean doSaveSuggerimento(Suggerimento suggerimento);
    List<Suggerimento> doRetrieveCronologiaSuggerimentiByUtenteID(int utenteID);

}
