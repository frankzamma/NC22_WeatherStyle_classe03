package Model;

public class Scarpa extends CapoAbbigliamento{

    private String tipo;
    private Boolean antiscivolo;
    private Boolean impermeabile;

    public Scarpa(String tipo, Boolean antiscivolo, Boolean impermeabile) {
        this.tipo = tipo;
        this.antiscivolo = antiscivolo;
        this.impermeabile = impermeabile;
    }

    public Scarpa(String materiale, String stagione, String colore, String tipo, Boolean antiscivolo, Boolean impermeabile) {
        super(materiale, stagione,colore);
        this.tipo = tipo;
        this.antiscivolo = antiscivolo;
        this.impermeabile = impermeabile;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getAntiscivolo() {
        return antiscivolo;
    }

    public void setAntiscivolo(Boolean antiscivolo) {
        this.antiscivolo = antiscivolo;
    }

    public Boolean getImpermeabile() {
        return impermeabile;
    }

    public void setImpermeabile(Boolean impermeabile) {
        this.impermeabile = impermeabile;
    }
}
