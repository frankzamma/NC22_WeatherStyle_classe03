package weatherstyle.gestionecitta.storage.dao;

import com.sun.xml.bind.v2.TODO;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;
import java.util.List;

public class CittaDAOImpl implements CittaDAOInterface{

    @Override
    public boolean doSaveCitta(Citta citta) {

        if (doRetrieveCittaByLatLon(citta.getLat(),citta.getLon())) {
            return false;
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

    //TODO da testare ancora
    @Override
    public Citta doRetrieveCittaBySuggerimentoID(int idSuggerimento) {
        Citta citta = new Citta();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT ID, nome, latitudine, longitudine "
                            + "FROM Citta c join Suggerimento s on s.IDCitta = c.ID "
                            + "where s.IDCitta=?");
            preparedStatement.setInt(1,idSuggerimento);

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

    @Override
    public List<Citta> doRetrieveCittaByUtenteID(int idUtente) {
        return null;
    }

    @Override
    public boolean doSaveCittaUtente(int idUtente,Citta citta) {
        return false;
    }

    private boolean doRetrieveCittaByLatLon(String lat,String lon) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT latitudine, longitudine "
                            + "FROM Citta c  "
                            + "where c.latitudine=? and c.longitudine=?");
            preparedStatement.setString(1,lat);
            preparedStatement.setString(2,lon);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return false;
    }
}
