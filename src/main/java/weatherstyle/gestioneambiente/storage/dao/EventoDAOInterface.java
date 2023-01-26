package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;

import java.util.List;

public interface EventoDAOInterface {
    Evento doRetrieveById(int idEvento);
    boolean doSaveEvento(Evento evento);
    List<Evento> doRetrieveAfterCurrentDate();
    List<Evento> doRetrieveAll();
}
