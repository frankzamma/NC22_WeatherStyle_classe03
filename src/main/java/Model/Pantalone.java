package Model;

public class Pantalone extends CapoAbbigliamento{
    private String lunghezza, materiale;

    public Pantalone(){

    }

    public Pantalone(String materiale, String stagione, String colore, String lunghezza){
        super (stagione,colore);
        this.materiale = materiale;
        this.lunghezza = lunghezza;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(String lunghezza) {
        this.lunghezza = lunghezza;
    }

    @Override
    public String toString() {
        return "Pantalone[" +
                "stagione = "+ super.getStagione() +
                "colore = "+ super.getColore() +
                "lunghezza = " + lunghezza +
                ", materiale = " + materiale +
                ']';
    }
}
