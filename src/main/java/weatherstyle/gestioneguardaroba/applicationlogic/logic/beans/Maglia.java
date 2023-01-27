package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

/**
 Un oggetto <code>Maglia</code> rappresenta un tipo di capo d'abbigliamento.
 Oltre agli attributi della superclasse <code>CapoAbbigliamento</code>,
 considera anche la lunghezza della manica e il materiale di cui è costituita.
 */

public class Maglia extends CapoAbbigliamento {
    private String lunghezzaManica;
    private String materiale;

    /**
     * Costruttore vuoto.
     */
    public Maglia() {

    }

    /**
     * Metodo costruttore.
     * @param id rappresenta l'ID della maglia.
     * @param nome è il nome dato alla maglia.
     * @param dirImmagine è la directory in cui è presente
     *                    un'immagine della maglia.
     * @param stagione è la stagione in cui viene indossata
     *                 la maglia.
     * @param colore rappresenta il colore della maglia.
     * @param lunghezzaManica è la lunghezza della manica della maglia.
     * @param materiale è il materiale di cui è costituita la maglia.
     */
    public Maglia(int id,String nome,String dirImmagine,String stagione,
                  String colore,String lunghezzaManica,String materiale) {
        super(id,nome,dirImmagine,stagione,colore);
        this.lunghezzaManica = lunghezzaManica;
        this.materiale = materiale;
    }

    /**
     * Permette di ottenere la lunghezza della manica.
     * @return la lunghezza della manica.
     */
    public String getLunghezzaManica() {
        return lunghezzaManica;
    }

    /**
     * Modifica la lunghezza della manica.
     * @param lunghezzaManica sarà la nuova lunghezza della manica.
     */
    public void setLunghezzaManica(String lunghezzaManica) {
        this.lunghezzaManica = lunghezzaManica;
    }

    /**
     * Restituisce il materiale di cui è costituita la maglia.
     * @return il materiale di cui è costituita la maglia.
     */
    public String getMateriale() {
        return materiale;
    }

    /**
     * Modifica il materiale di cui è costituita la maglia.
     * @param materiale sarà il nuovo materiale della maglia.
     */
    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    /**
     * Permette di trasformare l'oggetto in stringa.
     * @return la stringa che descrive la maglia.
     */
    @Override
    public String toString() {
        return "Maglia: "
                + "ID=" + super.getId() + ", "
                + "nome=" + super.getNome() + ", "
                + "stagione=" + super.getStagione() + ", "
                + "colore=" + super.getColore() + ", "
                + "lunghezzaManica=" + lunghezzaManica + ", "
                + "materiale=" + materiale + ".";
    }
}
