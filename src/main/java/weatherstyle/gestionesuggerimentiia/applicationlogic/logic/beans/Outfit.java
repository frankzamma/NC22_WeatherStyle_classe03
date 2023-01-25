package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.beans;

public class Outfit {

    private int id;
    private String nome;
    private Maglia maglia;
    private Pantalone pantalone;
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

    public Pantalone getPantalone() {
        return pantalone;
    }

    public void setPantalone(Pantalone pantalone) {
        this.pantalone = pantalone;
    }

    public Scarpa getScarpa() {
        return scarpa;
    }

    public void setScarpa(Scarpa scarpa) {
        this.scarpa = scarpa;
    }
}
