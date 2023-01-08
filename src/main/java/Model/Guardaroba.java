package Model;

import java.util.List;

public class Guardaroba {

    private List<Maglia> magliaList;
    private List<Pantalone> pantaloneList;
    private List<Scarpa> scarpaList;

    public Guardaroba() {
    }

    public List<Maglia> getMagliaList() {
        return magliaList;
    }

    public void setMagliaList(List<Maglia> magliaList) {
        this.magliaList = magliaList;
    }

    public List<Pantalone> getPantaloneList() {
        return pantaloneList;
    }

    public void setPantaloneList(List<Pantalone> pantaloneList) {
        this.pantaloneList = pantaloneList;
    }

    public List<Scarpa> getScarpaList() {
        return scarpaList;
    }

    public void setScarpaList(List<Scarpa> scarpaList) {
        this.scarpaList = scarpaList;
    }
}
