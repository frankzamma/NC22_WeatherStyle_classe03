package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;
import weatherstyle.gestioneambiente.storage.dao.EventoDAOInterface;
import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestionecitta.storage.service.InfoCittaService;

import java.sql.Timestamp;
import java.util.List;

public class EventoLogicService implements EventoLogicInterface{
    private final EventoDAOInterface eventoDAO;
    private final InfoCittaService infoCitta;

    public EventoLogicService(EventoDAOInterface eventoDAO,InfoCittaService infoCitta) {
        this.eventoDAO = eventoDAO;
        this.infoCitta = infoCitta;
    }

    @Override
    public Evento ottieniEventoPerId(int idEvento) {
        return eventoDAO.doRetrieveById(idEvento);
    }

    @Override
    public boolean salvaEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Errore, evento null.");
        }

        if (evento.getNome() == null || (evento.getNome().length() < 1 || evento.getNome().length() > 40)) {
            throw new IllegalArgumentException("Lunghezza nome Evento non valida.");
        }

        List<Citta> list = infoCitta.getCittaByName(evento.getLuogo());
        if (list == null) {
            throw new IllegalArgumentException("Luogo evento inesistente.");
        }

        if (evento.getDataOraEvento().before(new Timestamp(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Data nel passato.");
        }

        if (evento.getDescrizione() == null || (evento.getDescrizione().length() < 1 || evento.getDescrizione().length() > 255)) {
            throw new IllegalArgumentException("Lunghezza descrizione evento non valida.");
        }

        if (evento.getAltreInformazioni() == null || (evento.getAltreInformazioni().length() < 1 || evento.getAltreInformazioni().length() > 255)) {
            throw new IllegalArgumentException("Lunghezza altre informazioni evento non valida.");
        }

        return eventoDAO.doSaveEvento(evento);
    }

    @Override
    public List<Evento> ottieniListaEventiFuturi() {
        return eventoDAO.doRetrieveAfterCurrentDate();
    }

    @Override
    public List<Evento> ottieniListaEventi() {
        return eventoDAO.doRetrieveAll();
    }
}
