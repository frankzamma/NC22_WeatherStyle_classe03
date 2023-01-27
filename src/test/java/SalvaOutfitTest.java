
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicImpl;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.service.SuggerimentoLogicService;
import weatherstyle.gestionesuggerimentiia.storage.dao.OutfitDAOImpl;
import weatherstyle.gestionesuggerimentiia.storage.dao.SuggerimentoDAOImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SalvaOutfitTest {

    private SuggerimentoLogicService suggerimentoLogicService;

    @Test
    public void outfitNull(){
        SuggerimentoDAOImpl suggerimentoDAO = Mockito.mock(SuggerimentoDAOImpl.class);
        OutfitDAOImpl outfitDAO = Mockito.mock(OutfitDAOImpl.class);

        Mockito.when(outfitDAO.doSaveOutfit(new Outfit())).thenReturn(false);

        suggerimentoLogicService = new SuggerimentoLogicImpl(suggerimentoDAO, outfitDAO);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> suggerimentoLogicService.salvaOutfit(null));

        assertEquals("Outfit non può essere null", e.getMessage());
    }

    public void maglieORPantaloniORScarpeNull(){

    }

    public void magliaNotValid(){

    }

    public void pantaloniNotValid(){

    }

    public void scarpeNotValid(){

    }

    public void nameOutfitNotValid(){

    }

    public void salvaOutfitOK(){

    }

}
