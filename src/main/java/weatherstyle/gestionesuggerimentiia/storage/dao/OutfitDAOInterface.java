package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;

public interface OutfitDAOInterface {

    boolean doSaveOutfit(Outfit outfit);
    Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID);
    Maglia doSearchMagliaByOutfitID(int outfitID);
    Pantalone doSearchPantaloneByOutfitID(int outfitID);
    Scarpe doSearchScarpeByOutfitID(int outfitID);

}
