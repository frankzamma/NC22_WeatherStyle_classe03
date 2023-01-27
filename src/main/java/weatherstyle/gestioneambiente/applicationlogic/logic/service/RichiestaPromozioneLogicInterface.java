package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

public interface RichiestaPromozioneLogicInterface {

    RichiestaPromozione ottieniRichiestaPromozionePerIdUtente(int idUtente);
    boolean salvaRichiestaPromozione(RichiestaPromozione richiestaPromozione);
    List<RichiestaPromozione> ottieniListaRichiestePromozioni();
    List<RichiestaPromozione> ottieniListaRichiestePromozioniPerStato(String stato);
    boolean aggiornaStatoRichiestaPromozionePerId(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin);

}
