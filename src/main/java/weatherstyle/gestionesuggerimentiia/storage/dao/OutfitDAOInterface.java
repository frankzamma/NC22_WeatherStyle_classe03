package weatherstyle.gestionesuggerimentiia.storage.dao;

import weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans.Outfit;

/**
 * @author Raffaele Aurucci
 * interfaccia che definisce i metodi che deve avere OutfitDAO
 */
public interface OutfitDAOInterface {

    boolean doSaveOutfit(Outfit outfit);
    Outfit doRetrieveOutfitBySuggerimentoID(int suggerimentoID);

}
