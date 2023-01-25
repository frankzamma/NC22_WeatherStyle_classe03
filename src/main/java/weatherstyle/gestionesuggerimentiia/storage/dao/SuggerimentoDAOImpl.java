package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;

import java.util.List;

public class SuggerimentoDAOImpl implements SuggerimentoDAOInterface{

    @Override
    public boolean doSaveSuggerimento(Suggerimento suggerimento) {
        return false;
    }

    @Override
    public List<Suggerimento> doRetrieveCronologiaSuggerimentiByUtenteID(int utenteID) {
        return null;
    }
}
