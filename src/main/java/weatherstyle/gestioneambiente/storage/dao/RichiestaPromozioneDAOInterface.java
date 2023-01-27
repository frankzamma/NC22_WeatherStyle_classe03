package weatherstyle.gestioneambiente.storage.dao;

import weatherstyle.gestioneambiente.applicationlogic.logic.beans.RichiestaPromozione;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Admin;

import java.util.List;

public interface RichiestaPromozioneDAOInterface {

    boolean doSaveRichiestaPromozione(RichiestaPromozione richiestaPromozione);
    List<RichiestaPromozione> doRetrieveAll();
    boolean doUpdateStatoById(RichiestaPromozione richiestaPromozione,String nuovoStato,Admin admin);
    List<RichiestaPromozione> doRetrieveRichiestaPromozioneByStato(String stato);
    RichiestaPromozione doRetrieveByIdUtente(int idUtente);
    RichiestaPromozione doRetrieveById(int idRichiestaPromozione);

}
