package weatherstyle.gestioneguardaroba.applicationlogic.logic.service;

/**
 * @author Annalaura Miglino
 */

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOInterface;
import weatherstyle.gestioneguardaroba.storage.dao.GuardarobaDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.GuardarobaDAOInterface;
import weatherstyle.utils.ErrorParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuardarobaLogicImpl implements GuardarobaLogicInterface {

    /**
     * Gestisce i capi d'abbigliamento nel database.
     */
    private CapoAbbigliamentoDAOImpl capoDAO = new CapoAbbigliamentoDAOImpl();
    /**
     * Gestisce il guardaroba nel database.
     */
    private GuardarobaDAOImpl guardarobaDAO = new GuardarobaDAOImpl();

    /**
     * Lista in cui vengono elencati tutti i valori che puà assumere l'attributo <code>colore</code>.
     */
    List<String> colori = Arrays.asList("chiaro", "scuro", "colorato");
    /**
     * Lista in cui vengono elencati tutti i valori che puà assumere l'attributo <code>stagione</code>.
     */
    List<String> stagioni = Arrays.asList("inverno", "estate", "autunno", "primavera", "autunno_inverno", "primavera_estate", "all");
    /**
     * Lista in cui vengono elencati tutti i valori che puà assumere l'attributo <code>materiale</code>.
     */
    List<String> materiali = Arrays.asList("cotone", "poliestere", "lana", "velluto", "tweed", "raso", "seta", "lino", "cashmere");
    /**
     * Lista in cui vengono elencati tutti i valori che puà assumere l'attributo <code>tipo</code> per le scarpe .
     */
    List<String> tipiScarpe = Arrays.asList("stivaletto alla caviglia", "scarpa da ginnastica", "scarpa classica", "scarpe con tacchi", "scarpe aperte", "anfibi", "stivali");

    /**
     * Costruttore.
     * @param capoAbbigliamentoDAO gestisce i capi d'abbigliamento nel database.
     * @param guardarobaDAO getisce il guardaroba nel database.
     */
    public GuardarobaLogicImpl(CapoAbbigliamentoDAOImpl capoAbbigliamentoDAO, GuardarobaDAOImpl guardarobaDAO) {
        this.capoDAO = capoAbbigliamentoDAO;
        this.guardarobaDAO = guardarobaDAO;
    }

    /**
     * Costruttore vuoto.
     */
    public GuardarobaLogicImpl (){

    }

    @Override
    public boolean salvaMaglia(Maglia m, int idGuardaroba) throws ErrorParameterException {
        try{

            controlliMaglia(m);
            capoDAO.doSaveMaglia(m, idGuardaroba);
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty())
                throw new ErrorParameterException(errorPar);
        }
        return true;
    }

    @Override
    public boolean salvaPantaloni(Pantaloni p, int idGuardaroba) throws ErrorParameterException {
        try{
            controlliPantaloni(p);
            capoDAO.doSavePantaloni(p, idGuardaroba);
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty())
                throw new ErrorParameterException(errorPar);
        }

        return true;
    }

    @Override
    public boolean salvaScarpe(Scarpe s, int idGuardaroba) throws ErrorParameterException{
        try{
            controlliScarpe(s);
            capoDAO.doSaveScarpe(s, idGuardaroba);
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty())
                throw new ErrorParameterException(errorPar);
        }
        return true;
    }

    @Override
    public List<Maglia> getMaglie(int idUtente) {
        Guardaroba g = guardarobaDAO.doRetrieveGuardarobaById(idUtente);

        return capoDAO.doRetrieveMaglieByIdGuardaroba(g.getId());

    }

    @Override
    public List<Pantaloni> getPantaloni(int idUtente) {
        Guardaroba g = guardarobaDAO.doRetrieveGuardarobaById(idUtente);

        return capoDAO.doRetrievePantaloniByIdGuardaroba(g.getId());

    }

    @Override
    public List<Scarpe> getScarpe(int idUtente) {
        Guardaroba g = guardarobaDAO.doRetrieveGuardarobaById(idUtente);

        return capoDAO.doRetrieveScarpeByIdGuardaroba(g.getId());

    }

    @Override
    public List<CapoAbbigliamento> getAll(int idUtente) {
        List<Maglia> maglie = getMaglie(idUtente);
        List<Pantaloni> pantaloni = getPantaloni(idUtente);
        List<Scarpe> scarpe = getScarpe(idUtente);
        List<CapoAbbigliamento> all = new ArrayList<>();

        for (Maglia m : maglie)
            all.add(m);

        for (Pantaloni p : pantaloni)
            all.add(p);

        for (Scarpe s : scarpe)
            all.add(s);

        return all;
    }

    @Override
    public boolean aggiornaNumeroCapi(int idUtente) {
        Guardaroba g = guardarobaDAO.doRetrieveGuardarobaById(idUtente);

        int numeroCapi = guardarobaDAO.doRetrieveNumeroCapi(idUtente);

        g.setNumeroCapi(numeroCapi+1);

        return guardarobaDAO.doSaveNumeroCapi(idUtente, g.getNumeroCapi());
    }

    /**
     * Controlla se l'oggetto <code>Maglia</code> è conforme ai vincoli.
     * @param m è la maglia che bisogna controllare.
     * @throws ErrorParameterException
     */
    public void controlliMaglia (Maglia m) throws ErrorParameterException{
        List<String> errorParameter =  new ArrayList<>();

        if ((m.getNome()==null) || ((m.getNome().length()>255) || (m.getNome().length()<=0))){
            errorParameter.add("Errore nel nome");
        }

        if ((m.getColore()==null) || (!colori.contains(m.getColore()))){
            errorParameter.add("Errore nel colore");
        }

        if ((m.getStagione()==null) || (!stagioni.contains(m.getStagione()))){
            errorParameter.add("Errore nella stagione");
        }

        if(m.getDirImmagine()==null){
            errorParameter.add("Errore nella directory immagine");
        }

        if ((m.getLunghezzaManica()==null) || ((!m.getLunghezzaManica().equals("lunga")) && (!m.getLunghezzaManica().equals("corta"))))
            errorParameter.add("Errore lunghezza manica");

        if ((m.getMateriale()==null) || (!materiali.contains(m.getMateriale())))
            errorParameter.add("Errore materiale");

        if (!errorParameter.isEmpty())
            throw new ErrorParameterException(errorParameter);
    }

    /**
     * Controlla se l'oggetto <code>Pantaloni</code> è conforme ai vincoli.
     * @param p è il paio di pantaloni che bisogna verificare.
     * @throws ErrorParameterException
     */
    public void controlliPantaloni (Pantaloni p) throws ErrorParameterException{
        List<String> errorParameter =  new ArrayList<>();

        if ((p.getNome()==null) || ((p.getNome().length()>255) || (p.getNome().length()<=0))){
            errorParameter.add("Errore nel nome");
        }

        if ((p.getColore()==null) || (!colori.contains(p.getColore()))){
            errorParameter.add("Errore nel colore");
        }

        if ((p.getStagione()==null) || (!stagioni.contains(p.getStagione()))){
            errorParameter.add("Errore nella stagione");
        }

        if(p.getDirImmagine()==null){
            errorParameter.add("Errore nella directory immagine");
        }

        if ((p.getLunghezza()==null) || ((!p.getLunghezza().equals("lunga")) && (!p.getLunghezza().equals("corta")))){
            errorParameter.add("Errore lunghezza");
        }

        if ((p.getMateriale()==null) || (!materiali.contains(p.getMateriale()))){
            errorParameter.add("Errore materiale");
        }

        if (!errorParameter.isEmpty())
            throw new ErrorParameterException(errorParameter);
    }

    /**
     * Controlla se l'oggetto <code>Scarpe</code> è conforme ai vincoli.
     * @param s è il paio di scarpe da verificare.
     * @throws ErrorParameterException
     */
    public void controlliScarpe (Scarpe s) throws ErrorParameterException{
        List<String> errorParameter =  new ArrayList<>();

        if ((s.getNome()==null) || ((s.getNome().length()>255) || (s.getNome().length()<=0))){
            errorParameter.add("Errore nel nome");
        }

        if ((s.getColore()==null) || (!colori.contains(s.getColore()))){
            errorParameter.add("Errore nel colore");
        }

        if ((s.getStagione()==null) || (!stagioni.contains(s.getStagione()))){
            errorParameter.add("Errore nella stagione");
        }

        if(s.getDirImmagine()==null){
            errorParameter.add("Errore nella directory immagine");
        }

        if ((s.getTipo()==null) || (!tipiScarpe.contains(s.getTipo())))
            errorParameter.add("Errore nel tipo di scarpe");

        if ((s.isAntiscivolo()) && !(s.isAntiscivolo()))
            errorParameter.add("Errore nell'attributo antiscivolo");

        if ((s.isImpermeabile()) && !(s.isImpermeabile()))
            errorParameter.add("Errore nell'attributo impermeabile");

        if (!errorParameter.isEmpty())
            throw new ErrorParameterException(errorParameter);
    }
}
