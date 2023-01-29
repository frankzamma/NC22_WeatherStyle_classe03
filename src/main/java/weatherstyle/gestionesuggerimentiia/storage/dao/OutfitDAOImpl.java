package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOInterface;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;

/**
 * @author Raffaele Aurucci
 * classe che si interfaccia al DB e lavora sulle tabelle in merito all'Outfit, in particolare sulle tabelle Outfit e
 * Comporre
 */
public class OutfitDAOImpl implements OutfitDAOInterface {

    /**
     * usa capoAbbigliamentoDAO per recuperare il tipo di capo d'abbigliamento di un determinato outfit
     */
    private final CapoAbbigliamentoDAOInterface capoAbbigliamentoDAO = new CapoAbbigliamentoDAOImpl();

    /**
     * salva un oufit nel DB, richiede che l'outfit sia stato già riempito con tutti i campi di cui è composto, eccetto
     * la chiave.
     * @param outfit che si vuole salvare
     * @return true se è stato possibile salvare l'outfit, false altrimenti
     */
    @Override
    public boolean doSaveOutfit(Outfit outfit) {

        int id1 = doRetrieveComporreOutfitByCapoAbbigliamentoID(outfit.getMaglia().getId());
        int id2 = doRetrieveComporreOutfitByCapoAbbigliamentoID(outfit.getPantaloni().getId());
        int id3 = doRetrieveComporreOutfitByCapoAbbigliamentoID(outfit.getScarpe().getId());

        if ( (id1 == id2) && (id1 == id3) && (id2 == id3) && (id1 != -1)){
            outfit.setId(id1);
            return true;
        }

        //TODO da qui inizia a debuggare
        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Outfit (nome) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,outfit.getNome());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int idOutfit = resultSet.getInt(1);
            outfit.setId(idOutfit);

            System.out.println(outfit);
            if (doSaveComporreCapoAbbigliamentoByOutfitID(outfit.getMaglia().getId(),outfit.getId())
                    && doSaveComporreCapoAbbigliamentoByOutfitID(outfit.getPantaloni().getId(),outfit.getId())
                    && doSaveComporreCapoAbbigliamentoByOutfitID(outfit.getScarpe().getId(),outfit.getId())) {
                return true;
            }
            else
                return false;

        } catch (SQLException sql) {
            throw new RuntimeException("salvataggio outfit non riuscito");
        }
    }

    /**
     * recupera un outfit dell'utente a partire dal suo suggerimento
     * @param suggerimentoID di cui si vuole avere l'outfit
     * @return un Outfit con tutti i campi settati compresa la chiave
     */
    @Override
    public Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID) {

        Outfit outfit = new Outfit();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT o.ID, o.nome "
                        + "FROM Outfit o join Suggerimento s on o.ID = s.IDoutfit "
                        + "where s.ID=?");
            preparedStatement.setInt(1,suggerimentoID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                outfit.setId(resultSet.getInt("ID"));
                outfit.setNome(resultSet.getString("nome"));
                outfit.setMaglia(doRetrieveMagliaByOutfitID(outfit.getId()));
                outfit.setPantaloni(doRetrievePantaloneByOutfitID(outfit.getId()));
                outfit.setScarpe(doRetrieveScarpeByOutfitID(outfit.getId()));
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return outfit;
    }

    /**
     * recupera una maglia dal DB che è stata scelta per comporre un outfit
     * @param outfitID di cui si vuole avere la maglia
     * @return una maglia con tutti i campi settati compresa la chiave
     */
    private Maglia doRetrieveMagliaByOutfitID(int outfitID) {

        Maglia maglia = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1,outfitID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idCapoAbbigliamento = resultSet.getInt("IDcapoAbbigliamento");
                maglia = capoAbbigliamentoDAO.doRetrieveMagliaByIdCapoAbbigliamento(idCapoAbbigliamento);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return maglia;
    }

    /**
     * recupera pantaloni dal DB che sono stati scelti per comporre un outfit
     * @param outfitID di cui si vogliono avere i pantaloni
     * @return pantaloni con tutti i campi settati compresa la chiave
     */
    private Pantaloni doRetrievePantaloneByOutfitID(int outfitID) {

        Pantaloni pantaloni = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1,outfitID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idCapoAbbigliamento = resultSet.getInt("IDcapoAbbigliamento");
                pantaloni = capoAbbigliamentoDAO.doRetrievePantaloniByIdCapoAbbigliamento(idCapoAbbigliamento);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return pantaloni;
    }

    /**
     * recupera scarpe dal DB che sono state scelte per comporre un outfit
     * @param outfitID di cui si vuole avere la maglia
     * @return una maglia con tutti i campi settati compresa la chiave
     */
    private Scarpe doRetrieveScarpeByOutfitID(int outfitID) {

        Scarpe scarpe = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1,outfitID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idCapoAbbigliamento = resultSet.getInt("IDcapoAbbigliamento");
                scarpe = capoAbbigliamentoDAO.doRetrieveScarpeByIdCapoAbbigliamento(idCapoAbbigliamento);
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return scarpe;
    }

    /**
     * salva una maglia nel DB, rappresenta la scelta dell'utente che ha composto un outfit
     * @param capoAbbigliamentoID che si vuole salvare
     * @param outfitID a cui appartiene
     * @return true se è stato possibile salvare, false altrimenti
     */
    private boolean doSaveComporreCapoAbbigliamentoByOutfitID(int capoAbbigliamentoID, int outfitID) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Comporre (IDoutfit, IDcapoAbbigliamento) VALUES(?,?)");
            preparedStatement.setInt(1, outfitID);
            preparedStatement.setInt(2, capoAbbigliamentoID);

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return true;
    }

    /**
     * controlla se non esiste già un capo d'abbigliamento associato a quell'outfit, chiamato tre volte permette di
     * capire se un outfit già esiste.
     * @param capoAbbigliamentoID id del capo d'abbigliamento
     * @return la chiave dell'outfit, -1 altrimenti
     */
    private int doRetrieveComporreOutfitByCapoAbbigliamentoID(int capoAbbigliamentoID){

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Comporre WHERE IDcapoAbbigliamento=?");
            preparedStatement.setInt(1, capoAbbigliamentoID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("IDoutfit");
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return -1;
    }
}
