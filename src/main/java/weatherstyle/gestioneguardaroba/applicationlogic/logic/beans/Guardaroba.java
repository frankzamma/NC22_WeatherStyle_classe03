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
        private String nome;
        private List<Maglia> maglie;
        private List<Pantaloni> pantaloni;
        private List<Scarpa> scarpe;

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
         Metodo costruttore.
         @param id costituisce l'identificativo univoco del guardaroba.
         @param nome è il nome del guardaroba.
         */
        public Guardaroba(int id, String nome) {
            this.id = id;
            this.nome = nome;
            numeroCapi = 0;
            maglie = new ArrayList<>();
            pantaloni = new ArrayList<>();
            scarpe = new ArrayList<>();
        }

        /**
         Restituisce l'ID del guardaroba su cui si effettua la chiamata.
         @return l'ID del guardaroba.
         */
        public int getId() {
            return id;
        }

        /**
         Setta l'ID del guardaroba su cui si effettua la chiamata.
         @param id sarà il nuovo ID del guardaroba.
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
         @param numeroCapi setta la quantità di capi d'abbigliamento
         presenti nel guardaroba.
         */
            public void setNumeroCapi(int numeroCapi) {
                this.numeroCapi = numeroCapi;
            }

        /**
         @return il nome del guardaroba.
         */
        public String getNome() {
                return nome;
        }

        /**
         @param nome setta il nome del guardaroba.
         */
        public void setNome(String nome) {
                this.nome = nome;
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
        public List<Scarpa> getScarpe() {
            return scarpe;
        }

        /**
         @param scarpe sarà la nuova lista di scarpe presente nel guardaroba.
         */
        public void setScarpe(List<Scarpa> scarpe) {
            this.scarpe = scarpe;
        }
}
