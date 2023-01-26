package weatherstyle.gestioneguardaroba.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;

public interface CapoAbbigliamentoDAOInterface {

    Maglia doRetrieveMagliaByIdCapoAbbigliamento(int idCapoAbbigliamento);
    Pantaloni doRetrievePantaloniByIdCapoAbbigliamento(int idCapoAbbigliamento);
    Scarpe doRetrieveScarpeByIdCapoAbbigliamento(int idCapoAbbigliamento);
}
