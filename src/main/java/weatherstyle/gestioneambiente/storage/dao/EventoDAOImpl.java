package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOInterface;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author angelopalmieri
 * Classe che gestisce le informazioni persistenti che riguardano gli eventi a favore dell'ambiente
 * creati dagli ecologisti.
 */
public class EventoDAOImpl implements EventoDAOInterface {
    /**
     * Questo metodo permette di creare un oggetto Evento a partire
     * da un resultSet ottenuto tramite una query.
     * @param resultSet rappresenta il risultato di una query
     * @return un evento se il resultSet contiene risultati,
     * altrimenti restituisce null.
     */
    private static Evento creaEvento(ResultSet resultSet) {
        Evento evento = new Evento();
        UtenteDAOInterface utenteDAO = new UtenteDAOImpl();

        try {
            evento.setId(resultSet.getInt("ID"));
            evento.setNome(resultSet.getString("nome"));
            evento.setDataOraEvento(resultSet.getTimestamp("dataOraEvento"));
            evento.setLuogo(resultSet.getString("luogo"));
            evento.setDescrizione(resultSet.getString("descrizione"));
            evento.setAltreInformazioni(resultSet.getString("altreInformazioni"));
            evento.setUtente(utenteDAO.doRetrieveUtenteByID(resultSet.getInt("IDutente")));
        } catch (SQLException sql) {
            throw new RuntimeException();
        }
        return evento;
    }

    @Override
    public Evento doRetrieveById(int idEvento) {
        Evento evento;

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM Evento WHERE ID=?");
            prepareStatement.setInt(1,idEvento);
            ResultSet resultSet = prepareStatement.executeQuery();
            resultSet.next();
            evento = creaEvento(resultSet);

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return evento;
    }

    @Override
    public boolean doSaveEvento(Evento evento) {
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement prepareStatement = connection.prepareStatement(
                    "INSERT INTO Evento (nome, dataOraEvento, luogo, descrizione, altreInformazioni, IDutente) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1,evento.getNome());
            prepareStatement.setTimestamp(2,evento.getDataOraEvento());
            prepareStatement.setString(3,evento.getLuogo());
            prepareStatement.setString(4,evento.getDescrizione());
            prepareStatement.setString(5,evento.getAltreInformazioni());
            prepareStatement.setInt(6,evento.getUtente().getId());

            if (prepareStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet rs = prepareStatement.getGeneratedKeys();
            rs.next();
            int idEvento = rs.getInt(1);
            evento.setId(idEvento);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<Evento> doRetrieveAfterCurrentDate() {
        List<Evento> list = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Evento WHERE TIMESTAMPDIFF(MINUTE, CURRENT_TIMESTAMP(), dataOraEvento) > 0;");
            while (resultSet.next()) {
                list.add(creaEvento(resultSet));
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return list;
    }

    @Override
    public List<Evento> doRetrieveAll() {
        List<Evento> list = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Evento;");
            while (resultSet.next()) {
                list.add(creaEvento(resultSet));
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return list;
    }
}
