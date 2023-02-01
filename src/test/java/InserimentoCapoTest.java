import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicImpl;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.service.GuardarobaLogicInterface;
import weatherstyle.gestioneguardaroba.storage.dao.CapoAbbigliamentoDAOImpl;
import weatherstyle.gestioneguardaroba.storage.dao.GuardarobaDAOImpl;
import weatherstyle.utils.ErrorParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class InserimentoCapoTest {
    private static CapoAbbigliamentoDAOImpl capoAbbigliamentoDAO;
    private static GuardarobaLogicInterface guardarobaLogic;
    private static GuardarobaDAOImpl guardarobaDAO;

    @BeforeAll
    public static void init() {
        capoAbbigliamentoDAO = Mockito.mock(CapoAbbigliamentoDAOImpl.class);
        guardarobaDAO = Mockito.mock(GuardarobaDAOImpl.class);
        guardarobaLogic = new GuardarobaLogicImpl(capoAbbigliamentoDAO, guardarobaDAO);
    }

    @Test
    public void lunghezzaNomeCortaMaglie (){
        Maglia m = new Maglia();

        m.setNome("");
        m.setMateriale("poliestere");
        m.setColore("chiaro");
        m.setStagione("estate");
        m.setLunghezzaManica("corta");
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaMaglia(m, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel nome"));
    }

    @Test
    public void materialeNullMaglie (){
        Maglia m = new Maglia();

        m.setNome("T-shirt Adidas");
        m.setMateriale(null);
        m.setColore("chiaro");
        m.setStagione("estate");
        m.setLunghezzaManica("corta");
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaMaglia(m, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore materiale"));
    }

    @Test
    public void coloreNullMaglie(){
        Maglia m = new Maglia();

        m.setNome("T-shirt Adidas");
        m.setMateriale("poliestere");
        m.setColore(null);
        m.setStagione("estate");
        m.setLunghezzaManica("corta");
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaMaglia(m, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel colore"));
    }

    @Test
    public void stagioneNullMaglie (){
        Maglia m = new Maglia();

        m.setNome("T-shirt Adidas");
        m.setMateriale("poliestere");
        m.setColore("chiaro");
        m.setStagione(null);
        m.setLunghezzaManica("corta");
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaMaglia(m, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nella stagione"));
    }

    @Test
    public void lunghezzaManicaErrataMaglia(){
        Maglia m = new Maglia();

        m.setNome("T-shirt Adidas");
        m.setMateriale("poliestere");
        m.setColore("chiaro");
        m.setStagione("estate");
        m.setLunghezzaManica(null);
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaMaglia(m, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore lunghezza manica"));
    }

    @Test
    public void magliaCorretto() throws ErrorParameterException {
        Maglia m = new Maglia();

        m.setNome("T-shirt Adidas");
        m.setMateriale("poliestere");
        m.setColore("chiaro");
        m.setStagione("estate");
        m.setLunghezzaManica("corta");
        m.setDirImmagine("/images/maglia.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSaveMaglia(m, 1)).thenReturn(true);

        assertTrue(guardarobaLogic.salvaMaglia(m,1));
    }

    @Test
    public void nomePantaloniErrato (){
        Pantaloni p = new Pantaloni();

        p.setNome(null);
        p.setLunghezza("corta");
        p.setColore("chiaro");
        p.setMateriale("poliestere");
        p.setStagione("estate");
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaPantaloni(p, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel nome"));
    }

    @Test
    public void materialePantaloniErrato(){
        Pantaloni p = new Pantaloni();

        p.setNome("Jeans Alcott");
        p.setLunghezza("corta");
        p.setColore("chiaro");
        p.setMateriale(null);
        p.setStagione("estate");
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaPantaloni(p, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore materiale"));
    }

    @Test
    public void colorePantaloniErrato(){
        Pantaloni p = new Pantaloni();

        p.setNome("Jeans Alcott");
        p.setLunghezza("corta");
        p.setColore(null);
        p.setMateriale("cotone");
        p.setStagione("estate");
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaPantaloni(p, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel colore"));
    }

    @Test
    public void stagionePantaloniErrato(){
        Pantaloni p = new Pantaloni();

        p.setNome("Jeans Alcott");
        p.setLunghezza("corta");
        p.setColore("chiaro");
        p.setMateriale("cotone");
        p.setStagione(null);
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaPantaloni(p, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nella stagione"));
    }

    @Test
    public void lunghezzaPantaloniErrato(){
        Pantaloni p = new Pantaloni();

        p.setNome("Jeans Alcott");
        p.setLunghezza(null);
        p.setColore("chiaro");
        p.setMateriale("cotone");
        p.setStagione("estate");
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaPantaloni(p, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore lunghezza"));
    }

    @Test
    public void pantaloniCorretto() throws ErrorParameterException {
        Pantaloni p = new Pantaloni();

        p.setNome("Jeans Alcott");
        p.setLunghezza("corta");
        p.setColore("chiaro");
        p.setMateriale("cotone");
        p.setStagione("estate");
        p.setDirImmagine("/images/pantaloni.jpg");

        Mockito.when(capoAbbigliamentoDAO.doSavePantaloni(p, 1)).thenReturn(true);

        assertTrue(guardarobaLogic.salvaPantaloni(p,1));
    }

    @Test
    public void nomeErratoScarpe(){
        Scarpe s = new Scarpe();

        s.setNome("");
        s.setColore("chiaro");
        s.setStagione("estate");
        s.setDirImmagine("/images/scarpe.jpg");
        s.setTipo("scarpa da ginnastica");
        s.setImpermeabile(false);
        s.setAntiscivolo(false);

        Mockito.when(capoAbbigliamentoDAO.doSaveScarpe(s, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaScarpe(s, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel nome"));
    }

    @Test
    public void coloreErratoScarpe(){
        Scarpe s = new Scarpe();

        s.setNome("Scarpe Adidas");
        s.setColore(null);
        s.setStagione("estate");
        s.setDirImmagine("/images/scarpe.jpg");
        s.setTipo("scarpa da ginnastica");
        s.setImpermeabile(false);
        s.setAntiscivolo(false);

        Mockito.when(capoAbbigliamentoDAO.doSaveScarpe(s, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaScarpe(s, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel colore"));
    }

    @Test
    public void stagioneErrataScarpe(){
        Scarpe s = new Scarpe();

        s.setNome("Scarpe Adidas");
        s.setColore("chiaro");
        s.setStagione(null);
        s.setDirImmagine("/images/scarpe.jpg");
        s.setTipo("scarpa da ginnastica");
        s.setImpermeabile(false);
        s.setAntiscivolo(false);

        Mockito.when(capoAbbigliamentoDAO.doSaveScarpe(s, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaScarpe(s, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nella stagione"));
    }

    @Test
    public void tipoErratoScarpe(){
        Scarpe s = new Scarpe();

        s.setNome("Scarpe Adidas");
        s.setColore("chiaro");
        s.setStagione("estate");
        s.setDirImmagine("/images/scarpe.jpg");
        s.setTipo(null);
        s.setImpermeabile(false);
        s.setAntiscivolo(false);

        Mockito.when(capoAbbigliamentoDAO.doSaveScarpe(s, 1)).thenReturn(false);
        ErrorParameterException e = assertThrows(ErrorParameterException.class,
                () -> guardarobaLogic.salvaScarpe(s, 1));
        assertEquals(true, e.getErrorParameter().contains("Errore nel tipo di scarpe"));
    }

    @Test
    public void scarpeCorretto() throws ErrorParameterException {
        Scarpe s = new Scarpe();

        s.setNome("Scarpe Adidas");
        s.setColore("chiaro");
        s.setStagione("estate");
        s.setDirImmagine("/images/scarpe.jpg");
        s.setTipo("scarpa da ginnastica");
        s.setImpermeabile(false);
        s.setAntiscivolo(false);

        Mockito.when(capoAbbigliamentoDAO.doSaveScarpe(s, 1)).thenReturn(true);

        assertTrue(guardarobaLogic.salvaScarpe(s,1));
    }

}
