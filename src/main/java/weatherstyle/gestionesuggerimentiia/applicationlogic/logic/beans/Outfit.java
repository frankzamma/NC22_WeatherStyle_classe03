package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;

public class Outfit {

    private int id;
    private String nome;
    private Maglia maglia;
    private Pantaloni pantaloni;
    private Scarpe scarpe;

    public Outfit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Maglia getMaglia() {
        return maglia;
    }

    public void setMaglia(Maglia maglia) {
        this.maglia = maglia;
    }

    public Pantaloni getPantaloni() {
        return pantaloni;
    }

    public void setPantaloni(Pantaloni pantalone) {
        this.pantaloni = pantalone;
    }

    public Scarpe getScarpe() {
        return scarpe;
    }

    public void setScarpe(Scarpe scarpe) {
        this.scarpe = scarpe;
    }
}
