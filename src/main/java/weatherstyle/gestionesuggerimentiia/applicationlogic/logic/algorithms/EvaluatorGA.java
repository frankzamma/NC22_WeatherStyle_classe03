package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Raffaele Aurucci, Angelo Palmieri, Annalaura Miglino, Francesco Giuseppe Zammarelli
 * classe che effettua le valutazioni dei capi d'abbigliamento assegnando punteggi incrementali mediante
 * euristiche ben definite
 */
class EvaluatorGA {

    private static List<Hashtable<String, Integer>> ranges;
    private static List<Hashtable<String, Integer>> stagionalita;
    private static Hashtable<String, Hashtable<String, Integer>> valutazioneTipoScarpa;

    public EvaluatorGA() {
      initTable();
    }

    /**
     * Inizializza delle tabelle hash per definire i punteggi necessari nelle varie valutazioni.
     */
    private static void initTable() {
        ranges =  new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            ranges.add(new Hashtable<>());
        }

        // -------- mappa temperatura > 30° --------

        // maglie e pantaloni
        ranges.get(0).put("cotone",9);
        ranges.get(0).put("poliestere",4);
        ranges.get(0).put("cashmere",1);
        ranges.get(0).put("lino",10);
        ranges.get(0).put("seta",9);
        ranges.get(0).put("tweed",2);
        ranges.get(0).put("velluto",3);
        ranges.get(0).put("lana",0);
        ranges.get(0).put("raso",9);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(0).put("lunga",0);
        ranges.get(0).put("media",0);
        ranges.get(0).put("corta",10);

        // scarpe
        ranges.get(0).put("inverno",0);
        ranges.get(0).put("autunno",1);
        ranges.get(0).put("primavera",2);
        ranges.get(0).put("estate",5);
        ranges.get(0).put("primavera_estate",4);
        ranges.get(0).put("autunno_inverno",1);
        ranges.get(0).put("all",3);



        // -------- mappa 25° < temperatura <= 30° --------

        // maglie e pantaloni
        ranges.get(1).put("cotone",10);
        ranges.get(1).put("poliestere",5);
        ranges.get(1).put("cashmere",1);
        ranges.get(1).put("lino",9);
        ranges.get(1).put("seta",8);
        ranges.get(1).put("tweed",2);
        ranges.get(1).put("velluto",3);
        ranges.get(1).put("lana",0);
        ranges.get(1).put("raso",7);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(1).put("lunga",1);
        ranges.get(1).put("media",2);
        ranges.get(1).put("corta",9);

        // scarpe
        ranges.get(1).put("inverno",0);
        ranges.get(1).put("autunno",1);
        ranges.get(1).put("primavera",3);
        ranges.get(1).put("estate",5);
        ranges.get(1).put("primavera_estate",4);
        ranges.get(1).put("autunno_inverno",1);
        ranges.get(1).put("all",3);



        // -------- mappa 20° < temperatura <= 25° --------

        // maglie e pantaloni
        ranges.get(2).put("cotone",10);
        ranges.get(2).put("poliestere",7);
        ranges.get(2).put("cashmere",2);
        ranges.get(2).put("lino",8);
        ranges.get(2).put("seta",9);
        ranges.get(2).put("tweed",2);
        ranges.get(2).put("velluto",4);
        ranges.get(2).put("lana",1);
        ranges.get(2).put("raso",6);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(2).put("lunga",3);
        ranges.get(2).put("media",4);
        ranges.get(2).put("corta",6);

        // scarpe
        ranges.get(2).put("inverno",0);
        ranges.get(2).put("autunno",2);
        ranges.get(2).put("primavera",5);
        ranges.get(2).put("estate",4);
        ranges.get(2).put("primavera_estate",4);
        ranges.get(2).put("autunno_inverno",1);
        ranges.get(2).put("all",3);



        // -------- mappa 15° < temperatura <= 20° --------

        ranges.get(3).put("cotone",10);
        ranges.get(3).put("poliestere",8);
        ranges.get(3).put("cashmere",5);
        ranges.get(3).put("lino",6);
        ranges.get(3).put("seta",7);
        ranges.get(3).put("tweed",6);
        ranges.get(3).put("velluto",5);
        ranges.get(3).put("lana",4);
        ranges.get(3).put("raso",4);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(3).put("lunga",4);
        ranges.get(3).put("media",5);
        ranges.get(3).put("corta",3);

        // scarpe
        ranges.get(3).put("inverno",4);
        ranges.get(3).put("autunno",5);
        ranges.get(3).put("primavera",4);
        ranges.get(3).put("estate",3);
        ranges.get(3).put("primavera_estate",3);
        ranges.get(3).put("autunno_inverno",4);
        ranges.get(3).put("all",3);



        // -------- mappa 10° < temperatura <= 15° --------

        ranges.get(4).put("cotone",8);
        ranges.get(4).put("poliestere",8);
        ranges.get(4).put("cashmere",7);
        ranges.get(4).put("lino",5);
        ranges.get(4).put("seta",6);
        ranges.get(4).put("tweed",6);
        ranges.get(4).put("velluto",6);
        ranges.get(4).put("lana",8);
        ranges.get(4).put("raso",3);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(4).put("lunga",9);
        ranges.get(4).put("media",4);
        ranges.get(4).put("corta",1);

        // scarpe
        ranges.get(4).put("inverno",5);
        ranges.get(4).put("autunno",5);
        ranges.get(4).put("primavera",3);
        ranges.get(4).put("estate",1);
        ranges.get(4).put("primavera_estate",2);
        ranges.get(4).put("autunno_inverno",4);
        ranges.get(4).put("all",3);



        // -------- mappa 5° < temperatura <= 10° --------

        ranges.get(5).put("cotone",8);
        ranges.get(5).put("poliestere",8);
        ranges.get(5).put("cashmere",8);
        ranges.get(5).put("lino",2);
        ranges.get(5).put("seta",4);
        ranges.get(5).put("tweed",7);
        ranges.get(5).put("velluto",8);
        ranges.get(5).put("lana",9);
        ranges.get(5).put("raso",2);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(5).put("lunga",10);
        ranges.get(5).put("media",0);
        ranges.get(5).put("corta",0);

        // scarpe
        ranges.get(5).put("inverno",5);
        ranges.get(5).put("autunno",4);
        ranges.get(5).put("primavera",1);
        ranges.get(5).put("estate",0);
        ranges.get(5).put("primavera_estate",0);
        ranges.get(5).put("autunno_inverno",4);
        ranges.get(5).put("all",3);



        // -------- mappa temperatura <= 5° --------

        ranges.get(6).put("cotone",8);
        ranges.get(6).put("poliestere",8);
        ranges.get(6).put("cashmere",10);
        ranges.get(6).put("lino",0);
        ranges.get(6).put("seta",3);
        ranges.get(6).put("tweed",8);
        ranges.get(6).put("velluto",9);
        ranges.get(6).put("lana",10);
        ranges.get(6).put("raso",1);

        // valutazione lunghezza maglia/pantalone
        ranges.get(6).put("lunga",10);
        ranges.get(6).put("media",0);
        ranges.get(6).put("corta",0);

        // scarpe
        ranges.get(6).put("inverno",5);
        ranges.get(6).put("autunno",3);
        ranges.get(6).put("primavera",1);
        ranges.get(6).put("estate",0);
        ranges.get(6).put("primavera_estate",0);
        ranges.get(6).put("autunno_inverno",3);
        ranges.get(6).put("all",3);


        stagionalita = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stagionalita.add(new Hashtable<>());
        }

        // stagione inverno
        stagionalita.get(0).put("inverno",6);
        stagionalita.get(0).put("autunno",4);
        stagionalita.get(0).put("primavera",2);
        stagionalita.get(0).put("estate",0);
        stagionalita.get(0).put("primavera_estate",1);
        stagionalita.get(0).put("autunno_inverno",5);
        stagionalita.get(0).put("all",3);

        // stagione primavera
        stagionalita.get(1).put("primavera",6);
        stagionalita.get(1).put("estate",4);
        stagionalita.get(1).put("autunno",2);
        stagionalita.get(1).put("inverno",0);
        stagionalita.get(1).put("primavera_estate",5);
        stagionalita.get(1).put("autunno_inverno",1);
        stagionalita.get(1).put("all",3);

        // stagione estate
        stagionalita.get(2).put("estate",6);
        stagionalita.get(2).put("autunno",2);
        stagionalita.get(2).put("inverno",0);
        stagionalita.get(2).put("primavera",4);
        stagionalita.get(2).put("primavera_estate",5);
        stagionalita.get(2).put("autunno_inverno",1);
        stagionalita.get(2).put("all",3);

        // stagione autunno
        stagionalita.get(3).put("autunno",6);
        stagionalita.get(3).put("inverno",4);
        stagionalita.get(3).put("primavera",2);
        stagionalita.get(3).put("estate",0);
        stagionalita.get(3).put("primavera_estate",1);
        stagionalita.get(3).put("autunno_inverno",5);
        stagionalita.get(3).put("all",3);


        // mappe valutazioni tipo di scarpe rispetto alle previsioni meteo

        valutazioneTipoScarpa = new Hashtable<>();

        Hashtable<String, Integer> hashTablePioggia = new Hashtable<>();
        hashTablePioggia.put("stivaletto alla caviglia",10);
        hashTablePioggia.put("scarpa da ginnastica",10);
        hashTablePioggia.put("scarpa classica",10);
        hashTablePioggia.put("scarpe con tacchi",10);
        hashTablePioggia.put("scarpe aperte",10);
        hashTablePioggia.put("anfibi",10);
        hashTablePioggia.put("stivali",10);

        Hashtable<String, Integer> hashTableSoleggiato = new Hashtable<>();
        hashTableSoleggiato.put("stivaletto alla caviglia",3);
        hashTableSoleggiato.put("scarpa da ginnastica",8);
        hashTableSoleggiato.put("scarpa classica",7);
        hashTableSoleggiato.put("scarpe con tacchi",7);
        hashTableSoleggiato.put("scarpe aperte",9);
        hashTableSoleggiato.put("anfibi",3);
        hashTableSoleggiato.put("stivali",3);

        Hashtable<String, Integer> hashTableNuvoloso = new Hashtable<>();
        hashTableNuvoloso.put("stivaletto alla caviglia",4);
        hashTableNuvoloso.put("scarpa da ginnastica",8);
        hashTableNuvoloso.put("scarpa classica",8);
        hashTableNuvoloso.put("scarpe con tacchi",5);
        hashTableNuvoloso.put("scarpe aperte",2);
        hashTableNuvoloso.put("anfibi",4);
        hashTableNuvoloso.put("stivali",4);

        Hashtable<String, Integer> hashTableNeve = new Hashtable<>();
        hashTableNeve.put("stivaletto alla caviglia",8);
        hashTableNeve.put("scarpa da ginnastica",5);
        hashTableNeve.put("scarpa classica",6);
        hashTableNeve.put("scarpe con tacchi",1);
        hashTableNeve.put("scarpe aperte",0);
        hashTableNeve.put("anfibi",9);
        hashTableNeve.put("stivali",10);

        valutazioneTipoScarpa.put("pioggia",hashTablePioggia);
        valutazioneTipoScarpa.put("soleggiato",hashTableSoleggiato);
        valutazioneTipoScarpa.put("nuvoloso",hashTableNuvoloso);
        valutazioneTipoScarpa.put("neve",hashTableNeve);

    }

    /**
     * Questo metodo serve a valutare le istanze di capi d’abbigliamento
     * @param capoAbbigliamento maglia | pantaloni | scarpe
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio maglia | pantaloni | scarpe
     */
    public int valuta(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        if (capoAbbigliamento.getClass().equals(Maglia.class) || capoAbbigliamento.getClass().equals(Pantaloni.class)) {
            return valutazioneMagliaOrPantaloni(capoAbbigliamento,meteoDailyMin);
        } else {
            return valutazioneScarpe(capoAbbigliamento,meteoDailyMin);
        }
    }

    /**
     * Questo metodo permette di valutare le scarpe.
     * @param capoAbbigliamento scarpa
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio finale scarpe
     */
    private int valutazioneScarpe(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        int punteggio = 0;

        if (!"soleggiato".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())
                || ("soleggiato".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())
                && meteoDailyMin.getTemperaturaPercepitaMedia() > 20)) {
            punteggio += valutazioneTipoScarpa((Scarpe) capoAbbigliamento,meteoDailyMin);
        }

        punteggio += valutazioneTemperatura(capoAbbigliamento,meteoDailyMin);
        punteggio += valutazioneStagionePrevisione(capoAbbigliamento,meteoDailyMin);
        punteggio += valutazioneColore(capoAbbigliamento,meteoDailyMin);

        if ("pioggia".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())
                || "neve".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())) {
            punteggio += valutazionePioggia((Scarpe) capoAbbigliamento);
        }

        return punteggio;
    }

    /**
     * Questo metodo permette di valutare le maglie o i pantaloni a seconda del tipo di capo.
     * @param capoAbbigliamento maglia | pantaloni
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio maglia | pantaloni
     */
    private int valutazioneMagliaOrPantaloni(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        int punteggio = 0;
        punteggio += valutazioneTemperatura(capoAbbigliamento,meteoDailyMin);
        punteggio += valutazioneColore(capoAbbigliamento,meteoDailyMin);
        punteggio += valutazioneLunghezza(capoAbbigliamento,meteoDailyMin);
        punteggio += valutazioneStagionePrevisione(capoAbbigliamento,meteoDailyMin);
        return punteggio;
    }

    /**
     * Questo metodo permette di ottenere l’indice da una lista di tabelle hash con punteggi definiti rispetto ai range
     * di temperatura.
     * @param temperaturaPercepita dalla quale si vuole ottenere il punteggio
     * @return indice
     */
    private int searchRange(int temperaturaPercepita) {
        int range;

        if (temperaturaPercepita > 30) {
            range = 0;
        }
        else if (temperaturaPercepita > 25) {
            range = 1;
        }
        else if (temperaturaPercepita > 20) {
            range = 2;
        }
        else if (temperaturaPercepita > 15) {
            range = 3;
        }
        else if (temperaturaPercepita > 10) {
            range = 4;
        }
        else if (temperaturaPercepita > 5) {
            range = 5;
        }
        else {
            range = 6;
        }

        return range;
    }

    /**
     * Questo metodo permette di valutare un capo d’abbigliamento rispetto alla temperatura.
     * @param capoAbbigliamento maglia | pantaloni | scarpe
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio
     */
    private int valutazioneTemperatura(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        int temperaturaPercepita = (int) meteoDailyMin.getTemperaturaPercepitaMedia();
        int range = searchRange(temperaturaPercepita);

        int voto;

        if (capoAbbigliamento.getClass().equals(Maglia.class)) {
            voto = ranges.get(range).get(((Maglia) capoAbbigliamento).getMateriale());
        } else if (capoAbbigliamento.getClass().equals(Pantaloni.class)) {
            voto = ranges.get(range).get(((Pantaloni) capoAbbigliamento).getMateriale());
        } else {
            voto = ranges.get(range).get(capoAbbigliamento.getStagione());
        }

        return voto;
    }

    /**
     * Questo metodo permette di valutare il colore di un capo d’abbigliamento.
     * @param capoAbbigliamento maglia | pantaloni | scarpe
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio
     */
    private int valutazioneColore(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        int voto;

        int i = searchRange((int) meteoDailyMin.getTemperaturaPercepitaMedia());

        if ("chiaro".equalsIgnoreCase(capoAbbigliamento.getColore())
                && "soleggiato".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())
                && i <= 2) {
            voto = 10;
        } else if ("scuro".equalsIgnoreCase(capoAbbigliamento.getColore())
                    && "soleggiato".equalsIgnoreCase(meteoDailyMin.getMeteoStringMin())
                    && i <= 2) {
                voto = 0;
        } else {
            voto = 5;
        }

        return voto;
    }

    /**
     * Questo metodo permette di valutare la lunghezza delle maniche di una maglia o di un pantalone.
     * @param capoAbbigliamento maglia | pantaloni
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio maglia | pantaloni
     */
    private int valutazioneLunghezza(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        int temperaturaPercepita = (int) meteoDailyMin.getTemperaturaPercepitaMedia();
        int range = searchRange(temperaturaPercepita);

        if (capoAbbigliamento.getClass().equals(Maglia.class)) {
            Maglia maglia = (Maglia) capoAbbigliamento;
            return ranges.get(range).get(maglia.getLunghezzaManica());
        }

        else if (capoAbbigliamento.getClass().equals(Pantaloni.class)) {
            Pantaloni pantaloni = (Pantaloni) capoAbbigliamento;
            return ranges.get(range).get(pantaloni.getLunghezza());
        }

        return 0;
    }

    /**
     * Questo metodo permette di valutare un capo d’abbigliamento rispetto alla stagione della previsione.
     * @param capoAbbigliamento maglia | pantaloni | scarpe
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio maglia | pantaloni | scarpe
     */
    private int valutazioneStagionePrevisione(CapoAbbigliamento capoAbbigliamento,MeteoDailyMin meteoDailyMin) {
        String stagionePrevisione = meteoDailyMin.getStagionePrevisione();

        int i = -1;

        switch (stagionePrevisione) {
            case "inverno": i = 0;
                break;
            case "primavera": i = 1;
                break;
            case "estate": i = 2;
                break;
            case "autunno": i = 3;
                break;
        }
        return  stagionalita.get(i).get(capoAbbigliamento.getStagione());
    }

    /**
     * Questo metodo permette di valutare le scarpe rispetto alla pioggia.
     * @param scarpe scarpe
     * @return punteggio scarpa
     */
    private int valutazionePioggia(Scarpe scarpe) {
        if (scarpe.isAntiscivolo() && scarpe.isImpermeabile()) {
            return 5;
        } else if (scarpe.isAntiscivolo()) {
            return 3;
        } else if (scarpe.isImpermeabile()) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * Questo metodo permette di valutare le scarpe rispetto alla loro tipologia.
     * @param scarpe scarpe
     * @param meteoDailyMin informazioni meteorologiche
     * @return punteggio
     */
    private int valutazioneTipoScarpa(Scarpe scarpe,MeteoDailyMin meteoDailyMin) {
        return valutazioneTipoScarpa.get(meteoDailyMin.getMeteoStringMin()).get(scarpe.getTipo());
    }

}
