package weatherstyle.gestionecitta.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raffaele Aurucci
 * classe che si interfaccia al DB e lavora sulle tabelle in merito alle Citta, in particolare sulle tabelle Citta e
 * Salvare
 */
public class CittaDAOImpl implements CittaDAOInterface{

    /**
     * salva citta nel DB e dopodichè riempie l'id dell'oggetto passato con la chiave restituita dal DB
     * @param citta citta da salvare
     * @return true se è stato possibile salvare la citta, false altrimenti
     */
    @Override
    public boolean doSaveCitta(Citta citta) {

        if (!doRetrieveCittaByLatLon(citta)) {
            return true;
        }

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Citta (nome, latitudine, longitudine) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,citta.getNome());
            preparedStatement.setString(2,citta.getLat());
            preparedStatement.setString(3,citta.getLon());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int idCitta = resultSet.getInt(1);
            citta.setId(idCitta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * recupera una citta nel DB rispetto ad un determinato suggerimento
     * @param idSuggerimento id del suggerimento
     * @return citta con tutti i campi settati
     */
    @Override
    public Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento) {
        Citta citta = new Citta();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT ID, nome, latitudine, longitudine " +
                            "FROM Citta c join Suggerimento s on s.IDcitta = c.ID " +
                            "where s.IDCitta=?");
            preparedStatement.setInt(1, idSuggerimento);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            citta.setId(resultSet.getInt("ID"));
            citta.setNome(resultSet.getString("nome"));
            citta.setLat(resultSet.getString("latitudine"));
            citta.setLon(resultSet.getString("longitudine"));

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return citta;
    }

    /**
     * recupera citta preferite di un utente
     * @param idUtente di cui si vogliono le citta preferite
     * @return una lista di citta preferite salvate dall'utente
     */
    @Override
    public List<Citta> doRetrieveCittaPreferiteByUtenteID(int idUtente) {

        List<Citta> cittaList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.ID, nome, latitudine, longitudine " +
                            "FROM Citta c join Salvare s on s.IDcitta = c.ID " +
                            "where s.IDutente=?");
            preparedStatement.setInt(1, idUtente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Citta citta = new Citta();
                citta.setId(resultSet.getInt("ID"));
                citta.setNome(resultSet.getString("nome"));
                citta.setLat(resultSet.getString("latitudine"));
                citta.setLon(resultSet.getString("longitudine"));
                cittaList.add(citta);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return cittaList;
    }

    /**
     * salva una citta preferita dell'utente
     * @param idUtente di cui si vuole salvare la citta
     * @param citta che si vuole salvare
     * @return true se è stato possibile salvare la citta, false altrimenti
     */
    @Override
    public boolean doSaveCittaByUtenteID(int idUtente, Citta citta) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Salvare (IDutente, IDcitta) VALUES(?,?)");
            preparedStatement.setInt(1, idUtente);
            preparedStatement.setInt(2, citta.getId());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int idCitta = resultSet.getInt(1);
            citta.setId(idCitta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * metodo che verifica se una determinata citta di cui si vuole il suggerimento non è stata già salvata nel DB, se
     * è già presente recupera il suo id
     * @param citta i cui campi sono stati già settati
     * @return true se è stato possibile salvare la citta, false altrimenti
     */
    private boolean doRetrieveCittaByLatLon(Citta citta) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT *"
                            + "FROM Citta c  "
                            + "where c.latitudine=? and c.longitudine=?");
            preparedStatement.setString(1, citta.getLat());
            preparedStatement.setString(2, citta.getLon());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                citta.setId(resultSet.getInt("ID"));
                return false;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return false;
    }
}
