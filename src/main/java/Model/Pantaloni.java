package Model;

public class Pantaloni extends CapoAbbigliamento{
    private String lunghezza;

    public Pantaloni(){

    }

    public Pantaloni (String materiale, String stagione, String colore, String lunghezza){
        super (materiale,stagione,colore);
        this.lunghezza = lunghezza;
    }

    public String getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(String lunghezza) {
        this.lunghezza = lunghezza;
    }
}
