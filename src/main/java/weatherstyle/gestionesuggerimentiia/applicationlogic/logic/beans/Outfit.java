package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;


import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpa;

public class Outfit {

    private int id;
    private String nome;
    private Maglia maglia;
    private Pantaloni pantalone;
    private Scarpa scarpa;

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

    public Pantaloni getPantalone() {
        return pantalone;
    }

    public void setPantaloni(Pantaloni pantalone) {
        this.pantalone = pantalone;
    }

    public Scarpa getScarpa() {
        return scarpa;
    }

    public void setScarpa(Scarpa scarpa) {
        this.scarpa = scarpa;
    }
}
