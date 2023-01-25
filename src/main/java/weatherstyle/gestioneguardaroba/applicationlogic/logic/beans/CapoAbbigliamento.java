package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

/**
 Un oggetto <code>CapoAbbigliamento</code> rappresenta un capo
 d'abbigliamento.
 Ha un ID, un nome, una directory per visualizzare le immagini,
 una stagione in cui è ideale indossarlo e un colore.
 */

public class CapoAbbigliamento {
    private int id;
    private String nome;
    private String dirImmagine;
    private String stagione;
    private String colore;

    /**
     Costruttore vuoto. Inizializza il numero di capi a zero e
     crea le tre liste: maglie, pantaloni e scarpe.
     */
    public CapoAbbigliamento() {

    }

    /**
     Metodo costruttore.
     * @param id rappresenta l'identificativo univoco del capo.
     * @param nome è il nome del capo.
     * @param dirImmagine rappresenta il path in cui vi è l'immagine del capo.
     * @param stagione rappresenta la stagione in cui viene indossato il capo.
     * @param colore è il colore del capo.
     */
    public CapoAbbigliamento(int id, String nome, String dirImmagine,
                             String stagione, String colore) {
        this.id = id;
        this.nome = nome;
        this.dirImmagine = dirImmagine;
        this.stagione = stagione;
        this.colore = colore;
    }

    /**
     * Restituisce l'ID del capo.
     * @return ID del capo.
     */
    public int getId() {
        return id;
    }

    /**
     * Setta l'ID del capo.
     * @param id rappresenta il nuovo ID del capo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permette di ottenere il nome del capo.
     * @return nome del capo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica il nome del capo.
     * @param nome sarà il nuovo nome del capo d'abbigliamento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Permette di ottenere la directory della path in cui vi è l'immagine
     * del capo.
     * @return la directory in cui è memorizzata l'immagine del capo.
     */
    public String getDirImmagine() {
        return dirImmagine;
    }

    /**
     * Viene modificata la path in cui è memorizzata l'immagine del capo.
     * @param dirImmagine è la nuova directory del capo.
     */
    public void setDirImmagine(String dirImmagine) {
        this.dirImmagine = dirImmagine;
    }

    /**
     * Restituisce la stagione in cui il capo viene indossato.
     * @return la stagione in questione.
     */
    public String getStagione() {
        return stagione;
    }

    /**
     * Modifica la stagione in cui può essere indossato il capo.
     * @param stagione è la nuova stagione in cui viene indossato il capo.
     */
    public void setStagione(String stagione) {
        this.stagione = stagione;
    }

    /**
     * Visualizza il colore del capo.
     * @return il colore del capo.
     */
    public String getColore() {
        return colore;
    }

    /**
     * Modifica il colore del capo.
     * @param colore sarà il nuovo colore del capo.
     */
    public void setColore(String colore) {
        this.colore = colore;
    }
}
