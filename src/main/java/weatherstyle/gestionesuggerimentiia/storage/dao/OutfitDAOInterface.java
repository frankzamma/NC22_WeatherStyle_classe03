package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;

public interface OutfitDAOInterface {

    boolean doSaveOutfit(Outfit outfit);
    Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID);
    Maglia doSearchMagliaByOutfitID(int outfitID);
    Pantaloni doSearchPantaloneByOutfitID(int outfitID);
    Scarpe doSearchScarpeByOutfitID(int outfitID);

}
