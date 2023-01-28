package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*;
import weatherstyle.utils.ConnectionPool;

import java.sql.*;

public class CapoAbbigliamentoDAOImpl implements CapoAbbigliamentoDAOInterface{

    @Override
    public CapoAbbigliamento doRetrieveCapoById(int idCapoAbbigliamento) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from CapoAbbigliamento WHERE ID = ?");

            statement.setInt(1,idCapoAbbigliamento);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                return creaCapo(res);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Maglia doRetrieveMagliaByIdCapoAbbigliamento(int idCapoAbbigliamento) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from Maglia WHERE IDcapoAbbigliamento = ?");

            statement.setInt(1,idCapoAbbigliamento);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                return creaMaglia(res);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pantaloni doRetrievePantaloniByIdCapoAbbigliamento(int idCapoAbbigliamento) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from Pantaloni WHERE IDcapoAbbigliamento = ?");

            statement.setInt(1,idCapoAbbigliamento);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                return creaPantaloni(res);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Scarpe doRetrieveScarpeByIdCapoAbbigliamento(int idCapoAbbigliamento) {
        try (Connection connection =  ConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from Scarpe WHERE IDcapoAbbigliamento = ?");

            statement.setInt(1,idCapoAbbigliamento);

            ResultSet res =  statement.executeQuery();
            if (res.next()) {
                return creaScarpe(res);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean doSaveMaglia(Maglia m) {
        try (Connection connection = ConnectionPool.getConnection()) {
            int id = doSaveCapo(m);
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into Maglia (IDcapoAbbigliamento, materiale, manica) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,id);
            statement.setString(2,m.getMateriale());
            statement.setString(3,m.getLunghezzaManica());

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
    public boolean doSavePantaloni(Pantaloni p) {
        try (Connection connection = ConnectionPool.getConnection()) {
            int id = doSaveCapo(p);
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into Pantaloni (IDcapoAbbigliamento, lunghezza, materiale) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,id);
            statement.setString(2,p.getLunghezza());
            statement.setString(3,p.getMateriale());

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
    public boolean doSaveScarpe(Scarpe s) {
        try (Connection connection = ConnectionPool.getConnection()) {
            int id = doSaveCapo(s);
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into Scarpe (IDcapoAbbigliamento, tipo, antiscivolo, impermeabile) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,id);
            statement.setString(2,s.getTipo());
            statement.setBoolean(3,s.isAntiscivolo());
            statement.setBoolean(4,s.isImpermeabile());

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
     * Questo metodo restituisce un oggetto <code>CapoAbbigliamento</code>.
     * Viene creato a partire dal risultato della query.
     */
    public CapoAbbigliamento creaCapo(ResultSet res) throws SQLException {
        CapoAbbigliamento c = new CapoAbbigliamento();

        int id = res.getInt(1);
        String nome = res.getString(2);
        String stagione = res.getString(3);
        String colore = res.getString(4);
        String immagine = res.getString(5);

        c.setId(id);
        c.setNome(nome);
        c.setStagione(stagione);
        c.setColore(colore);
        c.setDirImmagine(immagine);

        return c;
    }

    /**
     * Questo metodo restituisce un oggetto <code>Maglia</code>.
     * Viene creato a partire dal risultato della query.
     */
    public Maglia creaMaglia(ResultSet res) throws SQLException {
        Maglia m = new Maglia();

        int id =  res.getInt(1);
        String manica = res.getString(2);
        String materiale = res.getString(3);

        CapoAbbigliamento c = doRetrieveCapoById(id);

        m.setId(id);
        m.setNome(c.getNome());
        m.setDirImmagine(c.getDirImmagine());
        m.setStagione(c.getStagione());
        m.setColore(c.getColore());
        m.setLunghezzaManica(manica);
        m.setMateriale(materiale);

        return m;
    }

    /**
     * Questo metodo restituisce un oggetto <code>Pantaloni</code>.
     * Viene creato a partire dal risultato della query.
     */
    public Pantaloni creaPantaloni(ResultSet res) throws SQLException {
        Pantaloni p = new Pantaloni();

        int id =  res.getInt(1);
        String lunghezza = res.getString(2);
        String materiale = res.getString(3);

        CapoAbbigliamento c = doRetrieveCapoById(id);

        p.setId(id);
        p.setNome(c.getNome());
        p.setDirImmagine(c.getDirImmagine());
        p.setStagione(c.getStagione());
        p.setColore(c.getColore());
        p.setLunghezza(lunghezza);
        p.setMateriale(materiale);

        return p;
    }

    /**
     * Questo metodo restituisce un oggetto <code>Scarpe</code>.
     * Viene creato a partire dal risultato della query.
     */
    public Scarpe creaScarpe(ResultSet res) throws SQLException {
        Scarpe s = new Scarpe();

        int id =  res.getInt(1);
        String tipo = res.getString(2);
        boolean antiscivolo = res.getBoolean(3);
        boolean impermeabile = res.getBoolean(4);

        CapoAbbigliamento c = doRetrieveCapoById(id);

        s.setId(id);
        s.setNome(c.getNome());
        s.setDirImmagine(c.getDirImmagine());
        s.setStagione(c.getStagione());
        s.setColore(c.getColore());
        s.setTipo(tipo);
        s.setAntiscivolo(antiscivolo);
        s.setImpermeabile(impermeabile);

        return s;
    }

    /**
     * Questo metodo salva un capo d'abbigliamento nella suddetta tabella.
     * Viene integrato nei metodi di maglie, pantaloni e scarpe.
     */
    public int doSaveCapo(CapoAbbigliamento c) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement statement =  connection.prepareStatement(
                    "insert into CapoAbbigliamento (nome, stagione, colore, immagine) values (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,c.getNome());
            statement.setString(2,c.getStagione());
            statement.setString(3,c.getColore());
            statement.setString(4,c.getDirImmagine());

            int res =  statement.executeUpdate();

            if (res == 0) {
                return -1;
            } else {
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                int id =  resultSet.getInt(1);

                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
