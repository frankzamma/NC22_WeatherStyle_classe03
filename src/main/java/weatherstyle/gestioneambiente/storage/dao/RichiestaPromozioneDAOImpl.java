package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.AdminDAOInterface;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOInterface;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;
import java.util.List;

public class RichiestaPromozioneDAOImpl implements RichiestaPromozioneDAOInterface{
    private static RichiestaPromozione creaRichiestaPromozione(ResultSet resultSet) {
        RichiestaPromozione richiestaPromozione = new RichiestaPromozione();
        UtenteDAOInterface utenteDAO = new UtenteDAOImpl();
        AdminDAOInterface adminDAO = new AdminDAOImpl();

        try {
            if (resultSet.next()) {
                richiestaPromozione.setId(resultSet.getInt("ID"));
                richiestaPromozione.setTematiche(resultSet.getString("tematiche"));
                richiestaPromozione.setEsperienze(resultSet.getString("esperienze"));
                richiestaPromozione.setStato(resultSet.getString("stato"));
                richiestaPromozione.setUtente(utenteDAO.doRetrieveUtenteByID(resultSet.getInt("IDutente")));
                richiestaPromozione.setAdmin(adminDAO.doRetrieveAdminById(resultSet.getInt("IDadmin")));
                return richiestaPromozione;
            }
        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return null;
    }

    @Override
    public boolean doSaveRichiestaPromozione(RichiestaPromozione richiestaPromozione) {
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement prepareStatement = connection.prepareStatement(
                    "INSERT INTO RichiestaPromozione (tematiche, esperienze, stato, IDutente, IDadmin) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1,richiestaPromozione.getTematiche());
            prepareStatement.setString(2,richiestaPromozione.getEsperienze());
            prepareStatement.setString(3,"in attesa");
            prepareStatement.setInt(4,richiestaPromozione.getUtente().getId());
            prepareStatement.setInt(5,-1);

            if (prepareStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet rs = prepareStatement.getGeneratedKeys();
            rs.next();
            int idRichiestaPromozione = rs.getInt(1);
            richiestaPromozione.setId(idRichiestaPromozione);
            richiestaPromozione.setStato("in attesa");
            richiestaPromozione.setAdmin(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<RichiestaPromozione> doRetrieveAll() {
        List<RichiestaPromozione> list = null;
        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM RichiestaPromozione;");
            while (resultSet.next()) {
                list.add(creaRichiestaPromozione(resultSet));
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return list;
    }

    @Override
    public boolean doUpdateStatoById(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE RichiestaPromozione SET stato=? AND IDadmin=? WHERE ID=?");
            ps.setString(1,nuovoStato);
            ps.setInt(2,admin.getId());
            ps.setInt(3,richiestaPromozione.getId());
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public List<RichiestaPromozione> doRetrieveRichiestaPromozioneByStato(String stato) {
        List<RichiestaPromozione> list = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM RichiestaPromozione WHERE stato=?");
            prepareStatement.setString(1,stato);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                list.add(creaRichiestaPromozione(resultSet));
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return list;
    }

    @Override
    public RichiestaPromozione doRetrieveByIdUtente(int idUtente) {
        RichiestaPromozione richiestaPromozione;

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM RichiestaPromozione WHERE IDutente=?");
            prepareStatement.setInt(1,idUtente);
            ResultSet resultSet = prepareStatement.executeQuery();
            richiestaPromozione = creaRichiestaPromozione(resultSet);

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return richiestaPromozione;
    }

    @Override
    public RichiestaPromozione doRetrieveById(int idRichiestaPromozione) {
        RichiestaPromozione richiestaPromozione;

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM RichiestaPromozione WHERE ID=?");
            prepareStatement.setInt(1,idRichiestaPromozione);
            ResultSet resultSet = prepareStatement.executeQuery();
            richiestaPromozione = creaRichiestaPromozione(resultSet);

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return richiestaPromozione;
    }
}
