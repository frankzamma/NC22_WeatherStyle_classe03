package weatherstyle.gestionemeteo.storage.dao;

import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;

/**
 * @author  Francesco Giuseppe Zammarrelli
 *
 * Classe per gestire le operazioni con il database relative al meteo
 */
public class MeteoDAOImpl implements MeteoDAOInterface{

    /**
     * Metodo per recupare un istanza di meteoDaily avendo l'id suggerimento a cui fa riferimento
     * @param idSuggerimento
     * @return un istanza di MeteoDailyMin se esiste un suggerimento con id = idSuggerimento, null altrimenti
     * @throws RuntimeException nel caso di problemi relativi alla connessione con DB
     */
    @Override
    public MeteoDailyMin doRetrieveMeteoBySuggerimentoID(int idSuggerimento) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT m.ID, m.stagione, m.temperatura, m.meteo " +
                            "FROM meteo m, suggerimento s " +
                            "WHERE s.ID = ?  AND s.IDmeteo = m.ID");


            statement.setInt(1, idSuggerimento);

            ResultSet res =  statement.executeQuery();

            MeteoDailyMin meteoDailyMin =  new MeteoDailyMin();
            if(res.next()){
                int id =  res.getInt(1);
                String stagionePrevisione = res.getString(2);
                double temperaturaPercepitaMedia =  res.getInt(3);
                String meteo = res.getString(4);

                meteoDailyMin.setId(id);
                meteoDailyMin.setTemperaturaPercepitaMedia(temperaturaPercepitaMedia);
                meteoDailyMin.setStagionePrevisione(stagionePrevisione);
                meteoDailyMin.setMeteo(meteo);


                return meteoDailyMin;
            }else{
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per salvare un istanza di MeteoDailyMin nel database.
     * @param meteo
     * @return true se il salvataggio avviene correttamente, false altrimenti
     * @throws RuntimeException nel caso di problemi relativi alla connessione con DB
     */
    @Override
    public boolean doSaveMeteo(MeteoDailyMin meteo) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO meteo(stagione, temperatura, meteo) " +
                            "VALUES(?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, meteo.getStagionePrevisione());
            statement.setInt(2, (int) meteo.getTemperaturaPercepitaMedia());
            statement.setString(3, meteo.getMeteoStringMin());

            int result =  statement.executeUpdate();
            if(result == 1){
                ResultSet res =  statement.getGeneratedKeys();
                res.next();
                int id =  res.getInt(1);
                meteo.setId(id);

                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
