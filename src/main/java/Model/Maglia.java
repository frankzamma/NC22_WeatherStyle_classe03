package Model;

public class Maglia extends CapoAbbigliamento{
    private String lunghezzaManica;

    public Maglia() {
    }

    public Maglia(Integer id, String materiale, String stagione, String colore, String lunghezzaManica) {
        super(id, materiale, stagione, colore);
        this.lunghezzaManica = lunghezzaManica;
    }

    public String getLunghezzaManica() {
        return lunghezzaManica;
    }

    public void setLunghezzaManica(String lunghezzaManica) {
        this.lunghezzaManica = lunghezzaManica;
    }
}
