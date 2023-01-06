package Model;

import java.util.*;

public class Evaluator {
    private static List<Hashtable<String, Integer>> ranges;
    private static List<Hashtable<String, Integer>> stagionalita;

    public Evaluator(){
      initTable();
    }

    private static void initTable(){
        ranges =  new ArrayList<>();

        for(int i = 0; i < 7; i++) {
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
        ranges.get(0).put("lana", 0);
        ranges.get(0).put("raso",9);

        // valutazione lunghezza maglie/pantaloni
        ranges.get(0).put("lunga",0);
        ranges.get(0).put("media",0);
        ranges.get(0).put("corta",10);

        // scarpe
        ranges.get(0).put("cuoio",5);
        ranges.get(0).put("camoscio",2);
        ranges.get(0).put("gomma",3);
        ranges.get(0).put("pelle",4);
        ranges.get(0).put("tessuto",9);
        ranges.get(0).put("ecopelle",6);
        ranges.get(0).put("tela",10);
        ranges.get(0).put("eva",8);

        // valutazione collo alto/basso scarpe
        ranges.get(0).put("alto",2);
        ranges.get(0).put("basso",8);



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
        ranges.get(1).put("cuoio",5);
        ranges.get(1).put("camoscio",2);
        ranges.get(1).put("gomma",4);
        ranges.get(1).put("pelle",3);
        ranges.get(1).put("tessuto",10);
        ranges.get(1).put("ecopelle",6);
        ranges.get(1).put("tela",9);
        ranges.get(1).put("eva",8);

        // valutazione collo alto/basso scarpe
        ranges.get(1).put("alto",3);
        ranges.get(1).put("basso",7);



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
        ranges.get(2).put("cuoio",6);
        ranges.get(2).put("camoscio",3);
        ranges.get(2).put("gomma",5);
        ranges.get(2).put("pelle",4);
        ranges.get(2).put("tessuto",5);
        ranges.get(2).put("ecopelle",7);
        ranges.get(2).put("tela",8);
        ranges.get(2).put("eva",9);

        // valutazione collo alto/basso scarpe
        ranges.get(2).put("alto",3);
        ranges.get(2).put("basso",7);



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
        ranges.get(3).put("cuoio",7);
        ranges.get(3).put("camoscio",4);
        ranges.get(3).put("gomma",6);
        ranges.get(3).put("pelle",6);
        ranges.get(3).put("tessuto",5);
        ranges.get(3).put("ecopelle",6);
        ranges.get(3).put("tela",7);
        ranges.get(3).put("eva",9);

        // valutazione collo alto/basso scarpe
        ranges.get(3).put("alto",4);
        ranges.get(3).put("basso",6);



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
        ranges.get(4).put("cuoio",7);
        ranges.get(4).put("camoscio",5);
        ranges.get(4).put("gomma",3);
        ranges.get(4).put("pelle",6);
        ranges.get(4).put("tessuto",3);
        ranges.get(4).put("ecopelle",4);
        ranges.get(4).put("tela",2);
        ranges.get(4).put("eva",8);

        // valutazione collo alto/basso scarpe
        ranges.get(4).put("alto",5);
        ranges.get(4).put("basso",5);



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
        ranges.get(5).put("cuoio",7);
        ranges.get(5).put("camoscio",9);
        ranges.get(5).put("gomma",2);
        ranges.get(5).put("pelle",8);
        ranges.get(5).put("tessuto",2);
        ranges.get(5).put("ecopelle",3);
        ranges.get(5).put("tela",1);
        ranges.get(5).put("eva",8);

        // valutazione collo alto/basso scarpe
        ranges.get(5).put("alto",7);
        ranges.get(5).put("basso",3);



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
        ranges.get(6).put("cuoio",8);
        ranges.get(6).put("camoscio",10);
        ranges.get(6).put("gomma",3);
        ranges.get(6).put("pelle",10);
        ranges.get(6).put("tessuto",2);
        ranges.get(6).put("ecopelle",4);
        ranges.get(6).put("tela",1);
        ranges.get(6).put("eva",6);

        // valutazione collo alto/basso scarpe
        ranges.get(6).put("alto",9);
        ranges.get(6).put("basso",1);


        stagionalita = new ArrayList<>();
        for(int i = 0; i < 4;i++ ){
            stagionalita.add(new Hashtable<>());
        }

        //stagione inverno
        stagionalita.get(0).put("inverno", 5);
        stagionalita.get(0).put("autunno", 4);
        stagionalita.get(0).put("primavera", 3);
        stagionalita.get(0).put("estate", 0);
        stagionalita.get(0).put("primavera_estate", 1);
        stagionalita.get(0).put("autunno_inverno", 2);
        stagionalita.get(0).put("all", 3);

        //primavera
        stagionalita.get(1).put("primavera", 5);
        stagionalita.get(1).put("estate", 3);
        stagionalita.get(1).put("autunno", 2);
        stagionalita.get(1).put("inverno", 0);
        stagionalita.get(1).put("primavera_estate", 4);
        stagionalita.get(1).put("autunno_inverno", 1);
        stagionalita.get(1).put("all", 3);

        //stagione estate
        stagionalita.get(2).put("estate", 5);
        stagionalita.get(2).put("autunno", 2);
        stagionalita.get(2).put("inverno", 0);
        stagionalita.get(2).put("primavera", 3);
        stagionalita.get(2).put("primavera_estate", 4);
        stagionalita.get(2).put("autunno_inverno", 1);
        stagionalita.get(2).put( "all", 3);

        // stagione autunno
        stagionalita.get(3).put("autunno", 5);
        stagionalita.get(3).put("inverno", 2);
        stagionalita.get(3).put("primavera", 3);
        stagionalita.get(3).put("estate", 0);
        stagionalita.get(3).put("primavera_estate", 1);
        stagionalita.get(3).put("autunno_inverno", 4);
        stagionalita.get(3).put("all", 3);
    }

    public int valuta(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation){
        if(capoAbbigliamento.getClass().equals(Maglia.class) || capoAbbigliamento.getClass().equals(Pantalone.class)){
            return valutazioneTopOrBottom(capoAbbigliamento, meteoInformation);
        }else{
            return valutazioneShoes(capoAbbigliamento, meteoInformation);
        }
    }

    private int valutazioneShoes(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation){
        int punteggio = 0;
        punteggio += valutazioneMateriale(capoAbbigliamento, meteoInformation);
        punteggio += valutazioneStagione(capoAbbigliamento);
        punteggio += valutazioneAntiscivolo((Scarpa)capoAbbigliamento, meteoInformation);
        punteggio += valutazioneImpermeabilita((Scarpa)capoAbbigliamento, meteoInformation);
        punteggio += valutazioneCollo((Scarpa)capoAbbigliamento, meteoInformation);
        return punteggio;
    }

    private int valutazioneTopOrBottom(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation){
        int punteggio = 0;
        punteggio += valutazioneMateriale(capoAbbigliamento, meteoInformation);
        punteggio += valutazioneColore(capoAbbigliamento, meteoInformation);
        punteggio += valutazioneLunghezza(capoAbbigliamento, meteoInformation);
        punteggio += valutazioneStagione(capoAbbigliamento);
        return punteggio;
    }

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
        else if (temperaturaPercepita > 5){
            range = 5;
        }
        else{
            range = 6;
        }

        return range;
    }

    private int valutazioneMateriale(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation) {
        /* Valutazione della maglia inserita dall'utente sulla base delle regole descritte su Drive */
        int temperaturaPercepita = (int) meteoInformation.getTemperaturaPercepita();
        int range = searchRange(temperaturaPercepita);

        int voto = 0;

        //try-catch aggiunto per debug, successivamente può essere rimosso
        try{
            voto = ranges.get(range).get(capoAbbigliamento.getMateriale());
        }catch(NullPointerException e){
            System.out.println(capoAbbigliamento.getMateriale());
            e.printStackTrace();
        }

        return  voto;
    }

    private int valutazioneColore(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation){
        int voto;

        int i = searchRange((int) meteoInformation.getTemperaturaPercepita());

        if (capoAbbigliamento.getColore().equalsIgnoreCase("chiaro") && meteoInformation.getMeteo().equalsIgnoreCase("soleggiato") && i<=2){
            voto=10;
        }else if(capoAbbigliamento.getColore().equalsIgnoreCase("scuro") && meteoInformation.getMeteo().equalsIgnoreCase("soleggiato") && i<=2){
            voto=0;
        }else{
            voto=5;
        }

        return voto;
    }

    private int valutazioneLunghezza(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation) {
        int temperaturaPercepita = (int) meteoInformation.getTemperaturaPercepita();
        int range = searchRange(temperaturaPercepita);
        if(capoAbbigliamento.getClass().equals(Maglia.class)){
            Maglia maglia = (Maglia) capoAbbigliamento;
            return ranges.get(range).get(maglia.getLunghezzaManica());
        }

        else
            if(capoAbbigliamento.getClass().equals(Pantalone.class)) {
                Pantalone pantalone = (Pantalone) capoAbbigliamento;
                return ranges.get(range).get(pantalone.getLunghezza());
            }

            return 0;
    }

    private String getStagione(){
        GregorianCalendar data = new GregorianCalendar();
        String[] seasons = {
                "inverno", "inverno", "primavera", "primavera", "primavera", "estate",
                "estate", "estate", "autunno", "autunno", "autunno", "inverno"
        };
        return seasons[data.get(Calendar.MONTH)];
    }

    private int valutazioneStagione (CapoAbbigliamento capoAbbigliamento){
        String stagionePrevisione = getStagione();
        int i = -1;
        switch (stagionePrevisione){
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

    private int valutazioneAntiscivolo(Scarpa scarpa, MeteoInformation meteoInformation){
        return meteoInformation.getMeteo().equalsIgnoreCase("pioggia") && scarpa.getAntiscivolo() ? 5: 0;
    }

    private int valutazioneImpermeabilita(Scarpa scarpa, MeteoInformation meteoInformation){
        return meteoInformation.getMeteo().equalsIgnoreCase("pioggia") && scarpa.getAntiscivolo() ? 7: 0;
    }

    private int valutazioneCollo(Scarpa scarpa, MeteoInformation meteoInformation){
        int temperaturaPercepita = (int) meteoInformation.getTemperaturaPercepita();
        int range = searchRange(temperaturaPercepita);
        return ranges.get(range).get(scarpa.getCollo());
    }

}
