package weatherstyle.gestionecitta.storage.dao;

import com.sun.xml.bind.v2.TODO;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;

public class CittaDAOImpl implements CittaDAOInterface{

    @Override
    public boolean doSaveCitta(Citta citta) {
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO Citta (nome, latitudine, longitudine) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, citta.getNome());
            ps.setString(2, citta.getLat());
            ps.setString(3, citta.getLon());

            if (ps.executeUpdate() != 1) {
                return false;
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idCitta = rs.getInt(1);
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
                    "SELECT ID, nome, latitudine, longitudine " +
                            "FROM Citta c join Suggerimento s on s.IDCitta = c.ID " +
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
}
