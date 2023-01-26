package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.dao.CittaDAOImpl;
import weatherstyle.gestionecitta.storage.dao.CittaDAOInterface;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDaily;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuggerimentoDAOImpl implements SuggerimentoDAOInterface{

    private CittaDAOInterface cittaDAO = new CittaDAOImpl();
    private MeteoDAOInterface meteoDAO = new MeteoDAOImpl();
    private OutfitDAOInterface outfitDAO = new OutfitDAOImpl();

    @Override
    public boolean doSaveSuggerimento(Suggerimento suggerimento) {

        return false;
    }

    @Override
    public List<Suggerimento> doRetrieveCronologiaSuggerimentiByUtenteID(int utenteID) {

        List<Suggerimento> suggerimentoList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Suggerimento where s.IDutente=?");
            preparedStatement.setInt(1, utenteID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Suggerimento suggerimento = new Suggerimento();
                suggerimento.setId(resultSet.getInt("ID"));
                suggerimento.setDate(resultSet.getDate("dataSuggerimento"));

                suggerimento.setCitta(cittaDAO.doRetrieveCittaBySuggerimentoID(suggerimento.getId()));
                suggerimento.setOutfit(outfitDAO.doRetrieveOutfitBySuggerimentoID(suggerimento.getId()));
                suggerimento.setMeteoDaily(meteoDAO.doRetrieveMeteoBySuggerimentoID(suggerimento.getId()));

                suggerimentoList.add(suggerimento);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return suggerimentoList;
    }
}
