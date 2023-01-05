package Model;

public abstract class CapoAbbigliamento {
    private String materiale, stagione, colore;

    public CapoAbbigliamento() {
    }

    public CapoAbbigliamento(String materiale, String stagione, String colore) {
        this.materiale = materiale;
        this.stagione = stagione;
        this.colore = colore;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getStagione() {
        return stagione;
    }

    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }
}
