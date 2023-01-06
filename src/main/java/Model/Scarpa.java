package Model;

public class Scarpa extends CapoAbbigliamento{

    private String collo;
    private Boolean antiscivolo;
    private Boolean impermeabile;

    public Scarpa(String collo, Boolean antiscivolo, Boolean impermeabile) {
        this.collo = collo;
        this.antiscivolo = antiscivolo;
        this.impermeabile = impermeabile;
    }

    public Scarpa(String materiale, String stagione, String collo, Boolean antiscivolo, Boolean impermeabile) {
        super(materiale, stagione);
        this.collo = collo;
        this.antiscivolo = antiscivolo;
        this.impermeabile = impermeabile;
    }

    public String getCollo() {
        return collo;
    }

    public void setCollo(String collo) {
        this.collo = collo;
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
