package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOInterface;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOInterface;
import weatherstyle.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SuggerimentoLogicService implements SuggerimentoLogicInterface{

    SuggerimentoDAOInterface suggerimentoDAO;
    OutfitDAOInterface outfitDAO;

    public SuggerimentoLogicService(SuggerimentoDAOInterface suggerimentoDAO, OutfitDAOInterface outfitDAO){
        this.suggerimentoDAO = suggerimentoDAO;
        this.outfitDAO = outfitDAO;
    }

    @Override
    public boolean salvaSuggerimento(Suggerimento suggerimento) {
        if (suggerimento == null)
            throw new IllegalArgumentException("Suggerimento non può essere null");

        return suggerimentoDAO.doSaveSuggerimento(suggerimento);
    }

    @Override
    public List<Suggerimento> ottieniCronologiaSuggerimentiUtente(int idUtente) {

    }

    @Override
    public Set<Set<CapoAbbigliamento>> ottieniSuggerimentiCapi(Guardaroba guardaroba, MeteoDaily meteoDaily) {
        return null;
    }

    @Override
    public boolean salvaOutfit(Outfit outfit) {
        return false;
    }

    @Override
    public List<Suggerimento> ottieniOutfitDaSuggerimentoID(List<Integer> idSuggerimenti) {
        return null;
    }
}
