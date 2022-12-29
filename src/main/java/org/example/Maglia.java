package org.example;

public class Maglia {
    private String materiale, stagione, lunghezzaManica, colore;

    public Maglia() {
    }

    public Maglia(String materiale, String stagione, String colore, String lunghezzaManica) {
        this.materiale = materiale;
        this.stagione = stagione;
        this.lunghezzaManica = lunghezzaManica;
        this.colore =  colore;
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

    public String getLunghezzaManica() {
        return lunghezzaManica;
    }

    public void setLunghezzaManica(String lunghezzaManica) {
        this.lunghezzaManica = lunghezzaManica;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "Maglia{" +
                "materiale='" + materiale + '\'' +
                ", stagione='" + stagione + '\'' +
                ", lunghezzaManica='" + lunghezzaManica + '\'' +
                ", colore='" + colore + '\'' +
                '}';
    }
}
