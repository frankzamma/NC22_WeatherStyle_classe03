package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.Evento;

import java.util.List;

public interface EventoLogicInterface {
    Evento ottieniEventoPerId(int idEvento);
    boolean salvaEvento(Evento evento);
    List<Evento> ottieniListaEventiFuturi();
    List<Evento> ottieniListaEventi();
}
