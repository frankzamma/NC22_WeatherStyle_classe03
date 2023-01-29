package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionecitta.storage.dao.CittaDAOImpl;
import weatherstyle.gestionecitta.storage.dao.CittaDAOInterface;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOImpl;
import weatherstyle.gestionemeteo.storage.dao.MeteoDAOInterface;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raffaele Aurucci
 * classe che si interfaccia al DB e lavora sulle tabelle in merito al Suggerimento, in particolare sulla tabella
 * Suggerimento
 */
public class SuggerimentoDAOImpl implements SuggerimentoDAOInterface{

    /**
     * usa cittaDAO per recuperare la città relativa a un suggerimento
     */
    private final CittaDAOInterface cittaDAO = new CittaDAOImpl();

    /**
     * usa meteoDAO per recuperare il meteo relativo a un suggerimento
     */
    private final MeteoDAOInterface meteoDAO = new MeteoDAOImpl();

    /**
     * usa outfitDAO per recuperare un outfit rispetto al suggerimento
     */
    private final OutfitDAOInterface outfitDAO = new OutfitDAOImpl();

    /**
     * salva un suggerimento nel DB, dopodichè riempie l'oggetto con la chiave restituita dal DB
     * @param suggerimento che si vuole salvare
     * @return true se è stato possibile salvare, false altrimenti
     */
    @Override
    public boolean doSaveSuggerimento(Suggerimento suggerimento) {

        cittaDAO.doSaveCitta(suggerimento.getCitta());
        meteoDAO.doSaveMeteo(suggerimento.getMeteoDailyMin());
        outfitDAO.doSaveOutfit(suggerimento.getOutfit());

        System.out.println(suggerimento.getCitta() + "\n" +
                suggerimento.getMeteoDailyMin() + "\n" +
                suggerimento.getOutfit() + "\n" +
                suggerimento.getUtente());

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Suggerimento (dataSuggerimento, IDutente, IDcitta, IDoutfit)"
                            + "VALUES(?,?,?,?)");
            preparedStatement.setDate(1,suggerimento.getDate());
            preparedStatement.setInt(2, suggerimento.getUtente().getId());
            preparedStatement.setInt(3, suggerimento.getCitta().getId());
            preparedStatement.setInt(4, suggerimento.getOutfit().getId());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int idSuggerimento = resultSet.getInt(1);
            suggerimento.setId(idSuggerimento);

        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        return true;
    }

    /**
     * permette di recuperare la cronologia completa dei suggerimenti dell'utente
     * @param utenteID id dell'utente di cui si vogliono i suggerimenti
     * @return una lista di suggerimenti con tutti i campi settati
     */
    @Override
    public List<Suggerimento> doRetrieveCronologiaSuggerimentiByUtenteID(int utenteID) {

        List<Suggerimento> suggerimentoList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Suggerimento s where s.IDutente=?");
            preparedStatement.setInt(1,utenteID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Suggerimento suggerimento = new Suggerimento();
                suggerimento.setId(resultSet.getInt("ID"));
                suggerimento.setDate(resultSet.getDate("dataSuggerimento"));

                suggerimento.setCitta(cittaDAO.doRetrieveCittaBySuggerimentoID(suggerimento.getId()));
                suggerimento.setOutfit(outfitDAO.doRetrieveOutfitBySuggerimentoID(suggerimento.getId()));
                suggerimento.setMeteoDailyMin(meteoDAO.doRetrieveMeteoBySuggerimentoID(suggerimento.getId()));

                suggerimentoList.add(suggerimento);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return suggerimentoList;
    }
}
