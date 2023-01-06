package Model;

public class Pantalone extends CapoAbbigliamento{
    private String lunghezza;

    public Pantalone(){

    }

    public Pantalone(String materiale, String stagione, String colore, String lunghezza){
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
