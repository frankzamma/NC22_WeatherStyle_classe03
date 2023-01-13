package Model;

public class Scarpa extends CapoAbbigliamento{

    private String tipo;
    private Boolean antiscivolo;
    private Boolean impermeabile;

    public Scarpa(){

    }

    public Scarpa(String stagione, String colore, String tipo, Boolean antiscivolo, Boolean impermeabile) {
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
        return "Scarpa[" +
                "colore = " + super.getColore() +
                ", stagione = " + super.getStagione() +
                ", tipo = " + tipo +
                ", antiscivolo = " + antiscivolo +
                ", impermeabile = " + impermeabile +
                ']';
    }
}
