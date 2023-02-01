package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;

/**
 * @author Raffaele Aurucci
 * classe che rappresenta un outfit costruito da un utente dopo aver ottenuto i suggerimenti dal sistema
 */
public class Outfit {

    /**
     * id outfit
     */
    private Integer id;

    /**
     * nome outfit dato dall'utente
     */
    private String nome;

    /**
     * maglia scelta dall'utente
     */
    private Maglia maglia;

    /**
     * pantaloni scelti dall'utente
     */
    private Pantaloni pantaloni;

    /**
     * scarpe scelte dall'utente
     */
    private Scarpe scarpe;

    public Outfit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Outfit{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", maglia=" + maglia
                + ", pantaloni=" + pantaloni
                + ", scarpe=" + scarpe
                + '}';
    }
}
