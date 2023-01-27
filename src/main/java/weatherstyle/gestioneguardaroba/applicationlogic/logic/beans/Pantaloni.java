package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

/**
 Un oggetto <code>Pantaloni</code> rappresenta un tipo di capo d'abbigliamento.
 Oltre agli attributi della superclasse <code>CapoAbbigliamento</code>,
 considera anche la lunghezza del pantalone e il materiale di cui è costituita.
 */

public class Pantaloni extends CapoAbbigliamento {
    private String lunghezza;
    private String materiale;

    /**
     * Costruttore vuoto.
     */
    public Pantaloni() {

    }

    /**
     * Metodo costruttore.
     * @param id rappresenta l'ID dei pantaloni.
     * @param nome è il nome dato ai pantaloni.
     * @param dirImmagine è la directory in cui è presente
     *                    un'immagine dei pantaloni.
     * @param stagione è la stagione in cui vengono indossati
     *                 i pantaloni.
     * @param colore rappresenta il colore dei pantaloni.
     * @param lunghezza è la lunghezza dei pantaloni.
     * @param materiale è il materiale di cui sono costituiti i pantaloni.
     */
    public Pantaloni(int id,String nome,String dirImmagine,String stagione,
                     String colore,String lunghezza,String materiale) {
        super(id,nome,dirImmagine,stagione,colore);
        this.lunghezza = lunghezza;
        this.materiale = materiale;
    }

    /**
     * Permette di ottenere la lunghezza dei pantaloni.
     * @return la lunghezza dei pantaloni.
     */
    public String getLunghezza() {
        return lunghezza;
    }

    /**
     * Modifica la lunghezza dei pantaloni.
     * @param lunghezza sarà la nuova lunghezza dei pantaloni.
     */
    public void setLunghezza(String lunghezza) {
        this.lunghezza = lunghezza;
    }

    /**
     * Restituisce il materiale di cui sono costituiti i pantaloni.
     * @return il materiale di cui sono costituiti i pantaloni.
     */
    public String getMateriale() {
        return materiale;
    }

    /**
     * Modifica il materiale di cui sono costituiti i pantaloni.
     * @param materiale sarà il nuovo materiale dei pantaloni.
     */
    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    /**
     * Permette di trasformare l'oggetto in stringa.
     * @return la stringa che descrive i pantaloni.
     */
    @Override
    public String toString() {
        return "Pantaloni: "
                + "ID=" + super.getId() + ", "
                + "nome=" + super.getNome() + ", "
                + "stagione=" + super.getStagione() + ", "
                + "colore=" + super.getColore() + ", "
                + "lunghezza=" + lunghezza + ", "
                + "materiale=" + materiale + ".";
    }
}
