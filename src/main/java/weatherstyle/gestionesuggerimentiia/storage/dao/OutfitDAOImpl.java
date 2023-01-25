package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;

public class OutfitDAOImpl implements OutfitDAOInterface {

    @Override
    public boolean doSaveOutfit(Outfit outfit) {
        return false;
    }

    @Override
    public Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID) {
        return null;
    }

    @Override
    public Maglia doSearchMagliaByOutfitID(int outfitID) {
        return null;
    }

    @Override
    public Pantalone doSearchPantaloneByOutfitID(int outfitID) {
        return null;
    }

    @Override
    public Scarpe doSearchScarpeByOutfitID(int outfitID) {
        return null;
    }
}
