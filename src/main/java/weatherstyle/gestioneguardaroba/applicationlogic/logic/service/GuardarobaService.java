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

public class GuardarobaService implements GuardarobaLogicServiceInterface {

    CapoAbbigliamentoDAOInterface dao = new CapoAbbigliamentoDAOImpl();
    List<String> colori = Arrays.asList("chiaro", "scuro", "colorato");
    List<String> stagioni = Arrays.asList("inverno", "estate", "autunno", "primavera", "autunno_inverno", "primavera_estate", "all");
    List<String> materiali = Arrays.asList("cotone", "poliestere", "lana", "velluto", "tweed", "raso", "seta", "lino", "cashmere");
    List<String> tipiScarpe = Arrays.asList("stivaletto alla caviglia", "scarpa da ginnastica", "scarpa classica", "scarpe con tacchi", "scarpe aperte", "anfibi", "stivali");

    @Override
    public boolean salvaMaglia(Maglia m, int idGuardaroba) throws ErrorParameterException {
        try{

            controlli(m);
            if ((m.getLunghezzaManica()!=null) && ((m.getLunghezzaManica().equals("lunga")) || (m.getLunghezzaManica().equals("corta")))){
                if ((m.getMateriale()!=null) && (materiali.contains(m.getMateriale()))){
                    dao.doSaveMaglia(m, idGuardaroba);
                }
            }
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty()){
                if ((m.getLunghezzaManica()==null) || ((!m.getLunghezzaManica().equals("lunga")) || (!m.getLunghezzaManica().equals("corta"))))
                    errorPar.add("Errore lunghezza manica");
                if ((m.getMateriale()==null) || (!materiali.contains(m.getMateriale())))
                    errorPar.add("Errore materiale");
            }

            if (!errorPar.isEmpty())
                throw new ErrorParameterException();
        }
        return true;
    }

    @Override
    public boolean salvaPantaloni(Pantaloni p, int idGuardaroba) throws ErrorParameterException {
        try{
            controlli(p);

            if ((p.getLunghezza()!=null) && ((p.getLunghezza().equals("lunga")) || (p.getLunghezza().equals("corta")) || (p.getLunghezza().equals("media")))){
                if ((p.getMateriale()!=null) && (materiali.contains(p.getMateriale()))){
                    dao.doSavePantaloni(p, idGuardaroba);
                }
            }
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty()){
                if ((p.getLunghezza()==null) || ((!p.getLunghezza().equals("lunga")) || (!p.getLunghezza().equals("corta")) || (!p.getLunghezza().equals("media"))))
                    errorPar.add("Errore lunghezza pantaloni");

                if ((p.getMateriale()==null) || (!materiali.contains(p.getMateriale())))
                    errorPar.add("Errore materiale");
            }

            if (!errorPar.isEmpty())
                throw new ErrorParameterException();
        }

        return true;
    }

    @Override
    public boolean salvaScarpe(Scarpe s, int idGuardaroba) throws ErrorParameterException{
        try{
            controlli(s);
            if ((s.getTipo()!=null) && (tipiScarpe.contains(s.getTipo()))){
                if ((s.isAntiscivolo()==true) || (s.isAntiscivolo()==false)){
                    if ((s.isImpermeabile()==true) || (s.isImpermeabile()==false)){
                        dao.doSaveScarpe(s, idGuardaroba);
                    }
                }
            }
        }catch (ErrorParameterException e){
            List<String> errorPar = e.getErrorParameter();

            if (!errorPar.isEmpty()){
                if ((s.getTipo()==null) || (!tipiScarpe.contains(s.getTipo())))
                    errorPar.add("Errore nel tipo di scarpe");

                if ((s.isAntiscivolo()!=true) && (s.isAntiscivolo()!=false))
                    errorPar.add("Errore nell'attributo ANTISCIVOLO");

                if ((s.isImpermeabile()!=true) && (s.isImpermeabile()!=false))
                    errorPar.add("Errore nell'attributo IMPERMEABILE");
            }

            if (!errorPar.isEmpty())
                throw new ErrorParameterException();
        }
        return true;
    }

    @Override
    public List<Maglia> getMaglie(int idUtente) {
        GuardarobaDAOInterface daoG = new GuardarobaDAOImpl();

        Guardaroba g = daoG.doRetrieveGuardarobaById(idUtente);

        CapoAbbigliamentoDAOInterface daoC = new CapoAbbigliamentoDAOImpl();

        return daoC.doRetrieveMaglieByIdGuardaroba(g.getId());

    }

    @Override
    public List<Pantaloni> getPantaloni(int idUtente) {
        GuardarobaDAOInterface daoG = new GuardarobaDAOImpl();

        Guardaroba g = daoG.doRetrieveGuardarobaById(idUtente);

        CapoAbbigliamentoDAOInterface daoC = new CapoAbbigliamentoDAOImpl();

        return daoC.doRetrievePantaloniByIdGuardaroba(g.getId());

    }

    @Override
    public List<Scarpe> getScarpe(int idUtente) {
        GuardarobaDAOInterface daoG = new GuardarobaDAOImpl();

        Guardaroba g = daoG.doRetrieveGuardarobaById(idUtente);

        CapoAbbigliamentoDAOInterface daoC = new CapoAbbigliamentoDAOImpl();

        return daoC.doRetrieveScarpeByIdGuardaroba(g.getId());

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


    public void controlli (CapoAbbigliamento c) throws ErrorParameterException{
        List<String> errorParameter =  new ArrayList<>();

        if ((c.getNome()==null) || ((c.getNome().length()>255) || (c.getNome().length()<=0))){
            errorParameter.add("Errore nel nome");
        }

        if ((c.getColore()==null) || (!colori.contains(c.getColore()))){
            errorParameter.add("Errore nel colore");
        }

        if ((c.getStagione()==null) && (!stagioni.contains(c.getStagione()))){
            errorParameter.add("Errore nella stagione");
        }

        if(c.getDirImmagine()==null){
            errorParameter.add("Errore nella directory immagine");
        }

        if (!errorParameter.isEmpty())
            throw new ErrorParameterException(errorParameter);
    }
}
