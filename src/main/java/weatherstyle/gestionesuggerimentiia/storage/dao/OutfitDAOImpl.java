package weatherstyle.gestionesuggerimentiia.storage.dao;


import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
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
    public Pantaloni doSearchPantaloneByOutfitID(int outfitID) {
        return null;
    }

    @Override
    public Scarpe doSearchScarpeByOutfitID(int outfitID) {
        return null;
    }
}
