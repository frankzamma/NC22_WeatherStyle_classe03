package weatherstyle.gestioneguardaroba.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.utils.ErrorParameterException;

public interface CapoAbbigliamentoLogicServiceInterface{
    public boolean salvaMaglia (Maglia m) throws ErrorParameterException;
    public boolean salvaPantaloni (Pantaloni p) throws ErrorParameterException;
    public boolean salvaScarpe (Scarpe s) throws ErrorParameterException;
}
