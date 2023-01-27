package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

/**
 Un oggetto <code>Scarpa</code> rappresenta un tipo di capo d'abbigliamento.
 Oltre agli attributi della superclasse <code>CapoAbbigliamento</code>,
 considera anche il tipo di scarpa, e se è antiscivolo e/o impermeabile.
 */

public class Scarpe extends CapoAbbigliamento{
    private String tipo;
    private boolean antiscivolo;
    private boolean impermeabile;

    /**
     * Costruttore vuoto.
     */
    public Scarpe() {

    }

    /**
     * Metodo costruttore.
     * @param id rappresenta l'ID delle scarpe.
     * @param nome è il nome dato alle scarpe.
     * @param dirImmagine è la directory in cui è presente
     *                    un'immagine delle scarpe.
     * @param stagione è la stagione in cui vengono indossate
     *                 le scarpe.
     * @param colore rappresenta il colore delle scarpe.
     * @param tipo è il tipo di scarpa.
     * @param antiscivolo rappresenta il fatto che la scarpa sia antiscivolo.
     * @param impermeabile definisce l'impermeabilità della scarpa.
     */
    public Scarpe(int id,String nome,String dirImmagine,String stagione,
                  String colore,String tipo,boolean antiscivolo,boolean impermeabile) {
        super(id,nome,dirImmagine,stagione,colore);
        this.tipo = tipo;
        this.antiscivolo = antiscivolo;
        this.impermeabile = impermeabile;
    }

    /**
     * Permette di ottenere il tipo di scarpa.
     * @return il tipo di scarpa.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica il tipo di scarpa.
     * @param tipo sarà il nuovo tipo di scarpa.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Verifica se la scarpa è antiscivolo.
     * @return vero o falso a seconda che la scarpa sia antiscivolo o meno.
     */
    public boolean isAntiscivolo() {
        return antiscivolo;
    }

    /**
     * Modifica il fatto che una scarpa sia antiscivolo o meno.
     * @param antiscivolo setta se la scarpa è antiscivolo.
     */
    public void setAntiscivolo(boolean antiscivolo) {
        this.antiscivolo = antiscivolo;
    }

    /**
     * Verifica se la scarpa è impermeabile.
     * @return vero o falso a seconda che la scarpa sia impermeabile o meno.
     */
    public boolean isImpermeabile() {
        return impermeabile;
    }

    /**
     * Modifica il fatto che una scarpa sia impermeabile o meno.
     * @param impermeabile setta se la scarpa è impermeabile.
     */
    public void setImpermeabile(boolean impermeabile) {
        this.impermeabile = impermeabile;
    }

    /**
     * Permette di trasformare l'oggetto in stringa.
     * @return la stringa che descrive la scarpa.
     */
    @Override
    public String toString() {
        return "Scarpa: "
                + "ID=" + super.getId() + ", "
                + "nome=" + super.getNome() + ", "
                + "stagione=" + super.getStagione() + ", "
                + "colore=" + super.getColore() + ", "
                + "tipo=" + tipo + ", "
                + "antiscivolo=" + antiscivolo + ", "
                + "impermeabile=" + impermeabile + ".";
    }
}
