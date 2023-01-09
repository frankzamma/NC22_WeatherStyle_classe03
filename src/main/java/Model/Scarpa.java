package Model;

public class Scarpa extends CapoAbbigliamento{

    private String tipo;
    private Boolean scivoloso;
    private Boolean impermeabile;

    public Scarpa(){

    }

    public Scarpa(String stagione, String colore, String tipo, Boolean scivoloso, Boolean impermeabile) {
        super(stagione,colore);
        this.tipo = tipo;
        this.scivoloso = scivoloso;
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

    public Boolean getScivoloso() {
        return scivoloso;
    }

    public void setScivoloso(Boolean scivoloso) {
        this.scivoloso = scivoloso;
    }
}
