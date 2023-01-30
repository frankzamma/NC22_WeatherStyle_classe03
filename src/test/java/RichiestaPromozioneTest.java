import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.RichiestaPromozioneLogicImpl;
import weatherstyle.gestioneambiente.storage.dao.RichiestaPromozioneDAOImpl;
import weatherstyle.gestioneambiente.storage.dao.RichiestaPromozioneDAOInterface;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RichiestaPromozioneTest {

    private static RichiestaPromozioneDAOInterface richiestaPromozioneDAO;
    private static RichiestaPromozioneLogicImpl richiestaPromozioneLogic;

    @BeforeAll
    public static void init(){
        richiestaPromozioneDAO = Mockito.mock(RichiestaPromozioneDAOImpl.class);
        richiestaPromozioneLogic =  new RichiestaPromozioneLogicImpl(richiestaPromozioneDAO);
    }

    @Test
    public void motivazioneNonPresente(){
        RichiestaPromozione richiestaPromozione =  new RichiestaPromozione();
        Utente u =  new Utente();

        u.setId(1);
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEcologista(false);

        richiestaPromozione.setUtente(u);
        richiestaPromozione.setEsperienze("Aiuto per Legambiente nella pulizia dei parchi pubblici.");
        richiestaPromozione.setTematiche(null);

        Mockito.when(richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->richiestaPromozioneLogic.salvaRichiestaPromozione(richiestaPromozione));

        assertEquals("Mancano le tematiche.", e.getMessage());

    }

    @Test
    public void esperienzeNonPresenti(){
        RichiestaPromozione richiestaPromozione =  new RichiestaPromozione();
        Utente u =  new Utente();

        u.setId(1);
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEcologista(false);

        richiestaPromozione.setUtente(u);
        richiestaPromozione.setEsperienze("");
        richiestaPromozione.setTematiche("Pulizia di spiagge, pulizia di aree pubbliche, tutela del patrimonio naturale");

        Mockito.when(richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->richiestaPromozioneLogic.salvaRichiestaPromozione(richiestaPromozione));

        assertEquals("La lunghezza della stringa esperienze non è valida.", e.getMessage());

    }

    @Test
    public void esperienzeTooLong(){
        RichiestaPromozione richiestaPromozione =  new RichiestaPromozione();
        Utente u =  new Utente();

        u.setId(1);
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEcologista(false);

        richiestaPromozione.setUtente(u);
        richiestaPromozione.setEsperienze("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
                "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        richiestaPromozione.setTematiche("Pulizia di spiagge, " +
                "pulizia di aree pubbliche, tutela del patrimonio naturale");

        Mockito.when(richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione)).thenReturn(false);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->richiestaPromozioneLogic.salvaRichiestaPromozione(richiestaPromozione));

        assertEquals("La lunghezza della stringa esperienze non è valida.", e.getMessage());

    }

    @Test
    public void parametriCorretti(){
        RichiestaPromozione richiestaPromozione =  new RichiestaPromozione();
        Utente u =  new Utente();

        u.setId(1);
        u.setNome("Mario");
        u.setCognome("Rossi");
        u.setEcologista(false);

        richiestaPromozione.setUtente(u);
        richiestaPromozione.setEsperienze(
                "Aiuto per Legambiente nella pulizia dei parchi " +
                        "pubblici pulizia di aree pubbliche, tutela del patrimonio naturale");
        richiestaPromozione.setTematiche("Pulizia di spiagge, " +
                "pulizia di aree pubbliche, tutela del patrimonio naturale");

        Mockito.when(richiestaPromozioneDAO.doSaveRichiestaPromozione(richiestaPromozione)).thenReturn(true);


        Assertions.assertTrue(richiestaPromozioneLogic.salvaRichiestaPromozione(richiestaPromozione));


    }


}
