package Model;

public class ScarpaLegacy extends CapoAbbigliamentoLegacy {

    private String tipo;
    private Boolean antiscivolo;
    private Boolean impermeabile;

    public ScarpaLegacy() {

    }

    public ScarpaLegacy(String stagione,String colore,String tipo,Boolean antiscivolo,Boolean impermeabile) {
        super(stagione,colore);
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

    public Boolean getImpermeabile() {
        return impermeabile;
    }

    public void setImpermeabile(Boolean impermeabile) {
        this.impermeabile = impermeabile;
    }

    public Boolean getAntiscivolo() {
        return antiscivolo;
    }

    public void setAntiscivolo(Boolean antiscivolo) {
        this.antiscivolo = antiscivolo;
    }

    @Override
    public String toString() {
        return "Scarpa["
                + super.getColore()
                + ", " + super.getStagione()
                + ", " + tipo
                + ", " + (antiscivolo ? "Con Antiscivolo" : "Senza Antiscivolo")
                + ", " + (impermeabile ? "Impermeabile" : "Non Impermeabile")
                + "\n";
    }
}
