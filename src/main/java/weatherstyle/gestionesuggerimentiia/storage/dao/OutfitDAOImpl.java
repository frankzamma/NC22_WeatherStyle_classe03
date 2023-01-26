package weatherstyle.gestionesuggerimentiia.storage.dao;


import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOInterface;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutfitDAOImpl implements OutfitDAOInterface {

    private final CapoAbbigliamentoDAOInterface capoAbbigliamentoDAO = new CapoAbbigliamentoDAOImpl();

    @Override
    public boolean doSaveOutfit(Outfit outfit) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Outfit (nome) VALUES(?)");
            preparedStatement.setString(1, outfit.getNome());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int idOutfit = resultSet.getInt(1);
            outfit.setId(idOutfit);

            if (doSaveMagliaByOutfitID(outfit.getMaglia(), outfit.getId())
                    && doSavePantaloniByOutfitID(outfit.getPantaloni(), outfit.getId())
                    && doSaveScarpeByOutfitID(outfit.getScarpe(), outfit.getId())){
                return true;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return true;
    }

    @Override
    public Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID) {

        Outfit outfit = new Outfit();

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT o.ID, o.nome " +
                        "FROM Outfit o join Suggerimento s on o.ID = s.IDoutfit " +
                        "where s.ID=?");
            preparedStatement.setInt(1, suggerimentoID);

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


    private Maglia doRetrieveMagliaByOutfitID(int outfitID) {

        Maglia maglia = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1, outfitID);

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


    private Pantaloni doRetrievePantaloneByOutfitID(int outfitID) {

        Pantaloni pantaloni = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1, outfitID);

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


    private Scarpe doRetrieveScarpeByOutfitID(int outfitID) {

        Scarpe scarpe = null;

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT IDcapoAbbigliamento FROM Comporre WHERE IDoutfit=?");
            preparedStatement.setInt(1, outfitID);

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


    private boolean doSaveMagliaByOutfitID(Maglia maglia, Integer outfitID) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Comporre (IDoutfit, IDcapoAbbigliamento) VALUES(?,?)");
            preparedStatement.setInt(1, outfitID);
            preparedStatement.setInt(2, maglia.getId());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return true;
    }


    private boolean doSavePantaloniByOutfitID(Pantaloni pantaloni, Integer outfitID) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Comporre (IDoutfit, IDcapoAbbigliamento) VALUES(?,?)");
            preparedStatement.setInt(1, outfitID);
            preparedStatement.setInt(2, pantaloni.getId());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return true;
    }


    private boolean doSaveScarpeByOutfitID(Scarpe scarpe, Integer outfitID) {

        try (Connection connection = ConnectionPool.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Comporre (IDoutfit, IDcapoAbbigliamento) VALUES(?,?)");
            preparedStatement.setInt(1, outfitID);
            preparedStatement.setInt(2, scarpe.getId());

            if (preparedStatement.executeUpdate() != 1) {
                return false;
            }

        } catch (SQLException sql) {
            throw new RuntimeException();
        }

        return true;
    }
}
