package Model;

public class MagliaLegacy extends CapoAbbigliamentoLegacy {
    private String lunghezzaManica;
    private String materiale;

    public MagliaLegacy() {
    }

    public MagliaLegacy(String materiale,String stagione,String colore,String lunghezzaManica) {
        super(stagione,colore);
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

    @Override
    public String toString() {
        return "Maglia[" + super.getColore() + ", " + super.getStagione() + ", "
                + ", " + lunghezzaManica + ", " + materiale
                + "]\n";
    }
}
