package Model;

import java.util.List;

public class GuardarobaLegacy {

    private List<MagliaLegacy> magliaList;
    private List<PantaloniLegacy> pantaloniList;
    private List<ScarpaLegacy> scarpaList;

    public GuardarobaLegacy() {
    }

    public List<MagliaLegacy> getMagliaList() {
        return magliaList;
    }

    public void setMagliaList(List<MagliaLegacy> magliaList) {
        this.magliaList = magliaList;
    }

    public List<PantaloniLegacy> getPantaloneList() {
        return pantaloniList;
    }

    public void setPantaloneList(List<PantaloniLegacy> pantaloniList) {
        this.pantaloniList = pantaloniList;
    }

    public List<ScarpaLegacy> getScarpaList() {
        return scarpaList;
    }

    public void setScarpaList(List<ScarpaLegacy> scarpaList) {
        this.scarpaList = scarpaList;
    }

    public boolean addCapoAbbigliamento(CapoAbbigliamentoLegacy capoAbbigliamento) {
        if (this.magliaList == null || this.pantaloniList == null || this.scarpaList == null) {
            return false;
        }
        if (capoAbbigliamento instanceof MagliaLegacy) {
            this.magliaList.add((MagliaLegacy) capoAbbigliamento);
        } else if (capoAbbigliamento instanceof PantaloniLegacy) {
            this.pantaloniList.add((PantaloniLegacy) capoAbbigliamento);
        } else {
            this.scarpaList.add((ScarpaLegacy) capoAbbigliamento);
        }

        return true;
    }
}
