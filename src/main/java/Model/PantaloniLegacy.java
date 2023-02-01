package Model;

public class PantaloniLegacy extends CapoAbbigliamentoLegacy {
    private String lunghezza, materiale;

    public PantaloniLegacy() {

    }

    public PantaloniLegacy(String materiale,String stagione,String colore,String lunghezza) {
        super(stagione,colore);
        this.materiale = materiale;
        this.lunghezza = lunghezza;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(String lunghezza) {
        this.lunghezza = lunghezza;
    }

    @Override
    public String toString() {
        return "Pantaloni[" + super.getStagione() + ", " + super.getColore() + ", "
                + lunghezza + ", " +  materiale + "]\n";
    }
}
