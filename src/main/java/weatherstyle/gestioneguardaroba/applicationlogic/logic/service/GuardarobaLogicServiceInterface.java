package weatherstyle.gestioneguardaroba.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*;
import weatherstyle.utils.ErrorParameterException;

import java.util.List;

public interface GuardarobaLogicServiceInterface {
    public boolean salvaMaglia (Maglia m, int idGuardaroba) throws ErrorParameterException;
    public boolean salvaPantaloni (Pantaloni p, int idGuardaroba) throws ErrorParameterException;
    public boolean salvaScarpe (Scarpe s, int idGuardaroba) throws ErrorParameterException;
    public List<Maglia> getMaglie (int idUtente);
    public List<Pantaloni> getPantaloni (int idUtente);
    public List<Scarpe> getScarpe (int idUtente);
}
