package Model;

public abstract class CapoAbbigliamento {
    private String stagione, colore;

    public CapoAbbigliamento() {
    }

    public CapoAbbigliamento(String stagione, String colore) {
        this.stagione = stagione;
        this.colore = colore;
    }

    public CapoAbbigliamento(String stagione) {
        this.stagione = stagione;
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
