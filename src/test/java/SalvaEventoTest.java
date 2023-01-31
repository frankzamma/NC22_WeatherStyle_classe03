import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicImpl;
import weatherstyle.gestioneambiente.applicationlogic.logic.service.EventoLogicInterface;
import weatherstyle.gestioneambiente.storage.dao.EventoDAOImpl;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.service.InfoCittaImpl;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalvaEventoTest {
    private static EventoLogicInterface eventoLogic;
    private static EventoDAOImpl eventoDAO;
    private static InfoCittaImpl infoCitta;

    @BeforeAll
    public static void init() {
        eventoDAO = Mockito.mock(EventoDAOImpl.class);
        infoCitta = Mockito.mock(InfoCittaImpl.class);
        eventoLogic = new EventoLogicImpl(eventoDAO,infoCitta);
    }

    @Test
    public void lunghezzaNomeEventoTroppoLunga() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge per salvaguardare la flora" +
                "e la fauna che negli ultimi anni stanno subendo gravi danni.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2006, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza nome Evento non valida.", e.getMessage());
    }

    @Test
    public void lunghezzaNomeEventoTroppoCorta() {
        Evento evento = new Evento();
        evento.setNome("");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza nome Evento non valida.", e.getMessage());
    }

    @Test
    public void luogoInesistente() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Pincopallo");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(new ArrayList<>());
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Luogo evento inesistente.", e.getMessage());
    }

    @Test
    public void dataOraNelPassato() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2006, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Data nel passato.", e.getMessage());
    }

    @Test
    public void lunghezzaDescrizioneTroppoCorta() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza descrizione evento non valida.", e.getMessage());
    }

    @Test
    public void lunghezzaDescrizioneTroppoLunga() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi" +
                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
                " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
                " deserunt mollit anim id est laborum.");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza descrizione evento non valida.", e.getMessage());
    }

    @Test
    public void lunghezzaAltreInformazioniTroppoCorta() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza altre informazioni evento non valida.", e.getMessage());
    }

    @Test
    public void lunghezzaAltreInformazioniTroppoLunga() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!.");
        evento.setAltreInformazioni("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
                " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi" +
                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
                " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
                " deserunt mollit anim id est laborum.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(false);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eventoLogic.salvaEvento(evento));
        assertEquals("Lunghezza altre informazioni evento non valida.", e.getMessage());
    }

    @Test
    public void salvaEventoCorrettamente() {
        Evento evento = new Evento();
        evento.setNome("Organizzazione pulizia spiagge.");
        evento.setLuogo("Salerno");
        Timestamp dataOraEvento = new Timestamp
                (new GregorianCalendar
                        (2023, Calendar.FEBRUARY,12, 9, 0).getTimeInMillis());
        evento.setDataOraEvento(dataOraEvento);
        evento.setDescrizione("Vi attendiamo tutti sul lungomare di Salerno nella data " +
                "e ora indicata, c’è bisogno di tutti voi!");
        evento.setAltreInformazioni("Munirsi di guanti.");
        Utente utente = new Utente();
        utente.setEcologista(true);
        evento.setUtente(utente);

        Citta citta = new Citta();
        List<Citta> list = new ArrayList<>();
        list.add(citta);
        Mockito.when(infoCitta.getCittaByName(evento.getLuogo())).thenReturn(list);
        Mockito.when(eventoDAO.doSaveEvento(evento)).thenReturn(true);
        assertTrue(eventoLogic.salvaEvento(evento));
    }
}
