package weatherstyle.gestioneguardaroba.applicationlogic.logic.beans;

import java.util.ArrayList;
import java.util.List;

/**
Un oggetto <code>Guardaroba</code> rappresenta un insieme di
 capi d'abbigliamento.
Ha un nome, ed è possibile anche tenere traccia di quanti capi contiene.
 */

public class Guardaroba {
        private int id;
        private int numeroCapi;
        private List<Maglia> maglie;
        private List<Pantaloni> pantaloni;
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

        public Guardaroba(int id) {
            this.id = id;
            numeroCapi = 0;
            maglie = new ArrayList<>();
            pantaloni = new ArrayList<>();
            scarpe = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

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
         @param numeroCapi setta la quantità di capi d'abbigliamento
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
         @param maglie sarà la nuova lista di maglie presente nel guardaroba.
         */
        public void setMaglie(List<Maglia> maglie) {
                this.maglie = maglie;
        }

        /**
         @return la lista di pantaloni nel guardaroba.
         */
        public List<Pantaloni> getPantaloni() {
                return pantaloni;
        }

        /**
         @param pantaloni sarà la nuova lista di pantaloni presente
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
         @param scarpe sarà la nuova lista di scarpe presente nel guardaroba.
         */
        public void setScarpe(List<Scarpe> scarpe) {
            this.scarpe = scarpe;
        }
}
