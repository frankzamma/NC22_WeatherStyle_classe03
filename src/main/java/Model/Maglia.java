package Model;

public class Maglia extends CapoAbbigliamento{
    private String lunghezzaManica;
    private String materiale;

    public Maglia() {
    }

    public Maglia(String materiale, String stagione, String colore, String lunghezzaManica) {
        super(stagione, colore);
        this.materiale = materiale;
        this.lunghezzaManica = lunghezzaManica;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getLunghezzaManica() {
        return lunghezzaManica;
    }

    public void setLunghezzaManica(String lunghezzaManica) {
        this.lunghezzaManica = lunghezzaManica;
    }
}
