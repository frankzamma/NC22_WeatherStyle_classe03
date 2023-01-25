package Model;

import java.util.List;

public class Guardaroba {

    private List<Maglia> magliaList;
    private List<Pantaloni> pantaloniList;
    private List<Scarpa> scarpaList;

    public Guardaroba() {
    }

    public List<Maglia> getMagliaList() {
        return magliaList;
    }

    public void setMagliaList(List<Maglia> magliaList) {
        this.magliaList = magliaList;
    }

    public List<Pantaloni> getPantaloneList() {
        return pantaloniList;
    }

    public void setPantaloneList(List<Pantaloni> pantaloniList) {
        this.pantaloniList = pantaloniList;
    }

    public List<Scarpa> getScarpaList() {
        return scarpaList;
    }

    public void setScarpaList(List<Scarpa> scarpaList) {
        this.scarpaList = scarpaList;
    }

    public boolean addCapoAbbigliamento(CapoAbbigliamento capoAbbigliamento){
        if (this.magliaList == null || this.pantaloniList == null || this.scarpaList == null){
            return false;
        }
        if (capoAbbigliamento instanceof Maglia)
            this.magliaList.add((Maglia) capoAbbigliamento);
        else if (capoAbbigliamento instanceof Pantaloni)
            this.pantaloniList.add((Pantaloni) capoAbbigliamento);
        else
            this.scarpaList.add((Scarpa) capoAbbigliamento);

        return true;
    }
}
