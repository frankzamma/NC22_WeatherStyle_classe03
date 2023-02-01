package Model;

public abstract class CapoAbbigliamentoLegacy {
    private String stagione, colore;

    public CapoAbbigliamentoLegacy() {
    }

    public CapoAbbigliamentoLegacy(String stagione,String colore) {
        this.stagione = stagione;
        this.colore = colore;
    }

    public CapoAbbigliamentoLegacy(String stagione) {
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
