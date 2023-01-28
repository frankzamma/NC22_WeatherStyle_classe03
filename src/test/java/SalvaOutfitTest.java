import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicService;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SalvaOutfitTest {

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
        Outfit outfit = new Outfit();
        outfit.setMaglia(null);
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());

        Mockito.when(outfitDAO.doSaveOutfit(outfit)).thenReturn(false);

        suggerimentoLogicService = new SuggerimentoLogicImpl(suggerimentoDAO, outfitDAO);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaOutfit(outfit));

        assertEquals("Outfit non contiene maglia", e.getMessage());
    }

    @Test
    public void pantaloniNotSelected(){
        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(null);
        outfit.setScarpe(new Scarpe());

        Mockito.when(outfitDAO.doSaveOutfit(outfit)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaOutfit(outfit));

        assertEquals("Outfit non contiene pantaloni", e.getMessage());
    }

    @Test
    public void scarpeNotSelected(){
        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(null);

        Mockito.when(outfitDAO.doSaveOutfit(outfit)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaOutfit(outfit));

        assertEquals("Outfit non contiene scarpe", e.getMessage());
    }

    @Test
    public void nameOutfitNotValid(){
        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());
        outfit.setNome("SuperMegaBellissimoFantasticoOutfitCreatoProprioInQuestoMomento");

        Mockito.when(outfitDAO.doSaveOutfit(outfit)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaOutfit(outfit));

        assertEquals("Outfit lunghezza nome deve essere tra 1 e 30 caratteri", e.getMessage());
    }

    @Test
    public void salvaOutfitOK(){
        Outfit outfit = new Outfit();
        outfit.setMaglia(new Maglia());
        outfit.setPantaloni(new Pantaloni());
        outfit.setScarpe(new Scarpe());
        outfit.setNome("Il mio primo outfit");

        Mockito.when(outfitDAO.doSaveOutfit(outfit)).thenReturn(true);

        assertTrue(suggerimentoLogicService.salvaOutfit(outfit));
    }

}
