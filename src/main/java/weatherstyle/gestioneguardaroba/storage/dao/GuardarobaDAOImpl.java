package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.utils.ConnectionPool;
import java.sql.*;

/**
 * @author Annalaura Miglino
 * Questa classe implementa tutti i metodi dell'interfaccia
 * <code>GuardarobaDAOInterface</code>
 */
public class GuardarobaDAOImpl implements GuardarobaDAOInterface {

    @Override
    public Guardaroba doRetrieveGuardarobaById(int id) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from Guardaroba WHERE ID = ?");

            statement.setInt(1,id);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                return creaGuardaroba(res);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean doSaveGuardaroba(int idUtente) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into Guardaroba (ID, numeroCapi) values (?,0)",Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,idUtente);

            int res =  statement.executeUpdate();

            if (res == 0) {
                return false;
            } else {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int doRetrieveNumeroCapi(int idUtente) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT numeroCapi from Guardaroba WHERE ID = ?");

            statement.setInt(1,idUtente);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                int numero = res.getInt(1);
                return numero;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean doSaveNumeroCapi(int idUtente, int numero) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement statement =  connection.prepareStatement(
                    "UPDATE guardaroba set numeroCapi = ? WHERE ID = ?");

            statement.setInt(1, numero);
            statement.setInt(2, idUtente);

            int res =  statement.executeUpdate();

            if (res == 0) {
                return false;
            } else {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Questo metodo restituisce un oggetto <code>Guardaroba</code>.
     * Viene creato a partire dal risultato della query.
     */
    public Guardaroba creaGuardaroba(ResultSet res) throws SQLException {
        Guardaroba g = new Guardaroba();

        int id =  res.getInt(1);
        int numeroCapi = res.getInt(2);

        g.setId(id);
        g.setNumeroCapi(numeroCapi);

        return g;
    }
}
