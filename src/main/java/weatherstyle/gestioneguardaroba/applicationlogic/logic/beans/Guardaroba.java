package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

import java.util.ArrayList;
import java.util.List;

/**
 @author Annalaura Miglino
Un oggetto <code>Guardaroba</code> rappresenta un insieme di
 capi d'abbigliamento.
Ha un nome, ed è possibile anche tenere traccia di quanti e quali capi contiene.
 */

public class Guardaroba {
    /**
     * Identificativo del guardaroba.
     */
    private int id;
    /**
     * Numero di capi nel guardaroba.
     */
    private int numeroCapi;
    /**
     * Lista di maglie nel guardaroba.
     */
    private List<Maglia> maglie;
    /**
     * Lista di pantaloni nel guardaroba.
     */
    private List<Pantaloni> pantaloni;
    /**
     * Lista di scarpe nel guardaroba.
     */
    private List<Scarpe> scarpe;

    /**
     Costruttore vuoto. Inizializza il numero di capi a zero e
     crea le tre liste: maglie, pantaloni e scarpe.
     */
    public Guardaroba() {
        numeroCapi = 0;
        maglie = new ArrayList<>();
        pantaloni = new ArrayList<>();
        scarpe = new ArrayList<>();
    }

    /**
     * Inizializza un guardaroba, settando il numero di capi a zero e
     * creando le tre liste vuote di maglie, pantaloni e scarpe.
     * @param id indica l'ID che deve assumere il guardaroba.
     */
    public Guardaroba(int id) {
        this.id = id;
        numeroCapi = 0;
        maglie = new ArrayList<>();
        pantaloni = new ArrayList<>();
        scarpe = new ArrayList<>();
    }

    /**
     * @return l'ID del guardaroba.
     */
    public int getId() {
            return id;
        }

    /**
     * Setta l'ID del guardaroba.
      * @param id sarà il nuovo ID del guardaroba.
     */
    public void setId(int id) {
            this.id = id;
        }

    /**
     @return il numero di capi d'abbigliamento presenti nel guardaroba.
     */
    public int getNumeroCapi() {
            return numeroCapi;
        }

    /**
     @param numeroCapi sarà la quantità di capi d'abbigliamento
     presenti nel guardaroba.
     */
    public void setNumeroCapi(int numeroCapi) {
            this.numeroCapi = numeroCapi;
        }

    /**
    @return la lista di maglie presenti nel guardaroba.
    */
    public List<Maglia> getMaglie() {
        return maglie;
    }

    /**
     @param maglie setta una nuova lista di maglie presente nel guardaroba.
     */
    public void setMaglie(List<Maglia> maglie) {
            this.maglie = maglie;
    }

    /**
     @return la lista di pantaloni presenti nel guardaroba.
     */
    public List<Pantaloni> getPantaloni() {
            return pantaloni;
    }

    /**
     @param pantaloni setta una nuova lista di pantaloni
     nel guardaroba.
     */
    public void setPantaloni(List<Pantaloni> pantaloni) {
        this.pantaloni = pantaloni;
    }

    /**
     @return la lista di scarpe nel guardaroba.
     */
    public List<Scarpe> getScarpe() {
        return scarpe;
    }

    /**
     @param scarpe setta una nuova lista di scarpe nel guardaroba.
     */
    public void setScarpe(List<Scarpe> scarpe) {
            this.scarpe = scarpe;
        }
}
