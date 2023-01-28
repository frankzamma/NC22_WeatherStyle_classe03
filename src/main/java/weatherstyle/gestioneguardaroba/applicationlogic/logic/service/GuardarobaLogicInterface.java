package weatherstyle.gestioneguardaroba.applicationlogic.logic.service;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.*;
import weatherstyle.utils.ErrorParameterException;

import java.util.List;

public interface GuardarobaLogicInterface {
    boolean salvaMaglia (Maglia m, int idGuardaroba) throws ErrorParameterException;
    boolean salvaPantaloni (Pantaloni p, int idGuardaroba) throws ErrorParameterException;
    boolean salvaScarpe (Scarpe s, int idGuardaroba) throws ErrorParameterException;
    List<Maglia> getMaglie (int idUtente);
    List<Pantaloni> getPantaloni (int idUtente);
    List<Scarpe> getScarpe (int idUtente);
    List<CapoAbbigliamento> getAll (int idUtente);
}
