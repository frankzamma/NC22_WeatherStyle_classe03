import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Suggerimento;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicService;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import static org.junit.jupiter.api.Assertions.*;

public class SalvaSuggerimentoTest {

    private static SuggerimentoLogicService suggerimentoLogicService;
    private static SuggerimentoDAOImpl suggerimentoDAO;
    private static OutfitDAOImpl outfitDAO;

    @BeforeAll
    public static void init(){
        suggerimentoDAO = Mockito.mock(SuggerimentoDAOImpl.class);
        outfitDAO = Mockito.mock(OutfitDAOImpl.class);
        suggerimentoLogicService = new SuggerimentoLogicImpl(suggerimentoDAO, outfitDAO);
    }

    @Test
    public void magliaNotSelected(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(null);
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaSuggerimento(suggerimento));

        assertEquals("Outfit non contiene maglia", e.getMessage());
    }

    @Test
    public void pantaloniNotSelected(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(null);
        outfit.setScarpe(new Scarpe());

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaSuggerimento(suggerimento));

        assertEquals("Outfit non contiene pantaloni", e.getMessage());
    }

    @Test
    public void scarpeNotSelected(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(null);

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaSuggerimento(suggerimento));

        assertEquals("Outfit non contiene scarpe", e.getMessage());
    }

    @Test
    public void nameOutfitEmpty(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());
        outfit.setNome("");

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaSuggerimento(suggerimento));

        assertEquals("Outfit lunghezza nome deve essere tra 1 e 30 caratteri", e.getMessage());
    }

    @Test
    public void nameOutfitNotValid(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());
        outfit.setNome("SuperMegaBellissimoFantasticoOutfitCreatoProprioInQuestoMomento");

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaSuggerimento(suggerimento));

        assertEquals("Outfit lunghezza nome deve essere tra 1 e 30 caratteri", e.getMessage());
    }

    @Test
    public void salvaSuggerimentiOK(){
        Suggerimento suggerimento = new Suggerimento();
        suggerimento.setCitta(new Citta());
        suggerimento.setOutfit(new Outfit());
        suggerimento.setUtente(new Utente());
        suggerimento.setMeteoDailyMin(new MeteoDailyMin());

        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());
        outfit.setNome("Il mio primo outfit");

        suggerimento.setOutfit(outfit);

        Mockito.when(suggerimentoDAO.doSaveSuggerimento(suggerimento)).thenReturn(true);

        assertTrue(suggerimentoLogicService.salvaSuggerimento(suggerimento));
    }

}
