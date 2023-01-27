package weatherstyle.gestioneambiente.applicationlogic.logic.service;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

public interface RichiestaPromozioneLogicInterface {

    RichiestaPromozione ottieniRichiestaPromozionePerIdUtente(int idUtente);
    boolean salvaRichiestaPromozione(RichiestaPromozione richiestaPromozione);
    List<RichiestaPromozione> ottieniListaRichiestePromozione();
    List<RichiestaPromozione> ottieniListaRichiestePromozionePerStato(String stato);
    boolean aggiornaStatoRichiestaPromozione(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin);
    RichiestaPromozione ottieniRichiestaPromozionePerId(int idRichiestaPromozione);

}
