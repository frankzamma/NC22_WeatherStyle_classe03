package Model;

public abstract class CapoAbbigliamento {
    private String materiale, stagione, colore;
    private Integer id;

    public CapoAbbigliamento() {
    }

    public CapoAbbigliamento(Integer id, String materiale, String stagione, String colore) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
