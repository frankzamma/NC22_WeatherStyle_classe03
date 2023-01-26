package weatherstyle.gestioneutenti.storage.dao;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.dao.CittaDAOImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAOInterface {
    @Override
    public boolean doSaveUtente(Utente utente) {
        try(Connection connection = ConnectionPool.getConnection()){
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into Utente (nome, cognome, dataNascita, email, password) values" +
                            " ( ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(2, utente.getNome());
            statement.setString(3, utente.getCognome());
            statement.setDate(4, Date.valueOf(utente.getDataNascita()));
            statement.setString(5, utente.getEmail());
            statement.setString(6, utente.getPassword());

            int res =  statement.executeUpdate();

            if(res == 0){
                return false;
            }else{
                ResultSet resultSet = statement.getGeneratedKeys();
                int id =  resultSet.getInt(1);

                utente.setId(id);
                return true;
            }


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utente doRetrieveUtenteByID(int id) {
        try(Connection connection =  ConnectionPool.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * from Utente WHERE id = ?");

            statement.setInt(1, id);

            ResultSet res =  statement.executeQuery();

            if(res.next()){
                return creaUtente(res);
            }else {
                return null;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utente doRetrieveUtenteByUsernameAndPassword(String email, String password) {
        try(Connection connection =  ConnectionPool.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * from Utente WHERE email = ? AND password = ?");

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet res =  statement.executeQuery();
            if(res.next()) {
                return creaUtente(res);
            }else{
                return null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean doExistsEmail(String email) {
        try(Connection connection =  ConnectionPool.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement("SELECT id from Utente WHERE email = ? ");

            statement.setString(1, email);

            ResultSet res =  statement.executeQuery();

            return res.next();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    private Utente creaUtente(ResultSet res) throws SQLException {
        Utente u = new Utente();

        int id =  res.getInt(1);
        String nome =  res.getString(2);
        String cognome  = res.getString(3);
        LocalDate dataNascita =  res.getDate(4).toLocalDate();
        String email =  res.getString(5);
        String password =  res.getString(6);

        u.setId(id);
        u.setNome(nome);
        u.setCognome(cognome);
        u.setDataNascita(dataNascita);
        u.setEmail(email);
        u.setPassword(password);

        CittaDAOImpl cittaDAO =  new CittaDAOImpl();
        List<Citta> citta =  cittaDAO.doRetrieveCittaByUtenteID(id);

        u.setCitta(citta);
        //TODO aggiungere setGuardaroba

        boolean ecologista =  checkEcologista(id);
        u.setEcologista(ecologista);
        return u;
    }

    private boolean checkEcologista(int id){
        try(Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT id FROM ecologista WHERE id = ?");

            statement.setInt(1, id);
            ResultSet res =  statement.executeQuery();

            return res.next();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
