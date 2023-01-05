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

        /* mappa temperatura > 30° */
        ranges.get(0).put("cotone",9);
        ranges.get(0).put("poliestere",4);
        ranges.get(0).put("cashmere",1);
        ranges.get(0).put("lino",10);
        ranges.get(0).put("seta",9);
        ranges.get(0).put("tweed",2);
        ranges.get(0).put("velluto",3);
        ranges.get(0).put("lana", 0);
        ranges.get(0).put("raso",9);
        ranges.get(0).put("lunga",0);
        ranges.get(0).put("corta",10);

        /* mappa 25° < temperatura <= 30° */
        ranges.get(1).put("cotone",10);
        ranges.get(1).put("poliestere",5);
        ranges.get(1).put("cashmere",1);
        ranges.get(1).put("lino",9);
        ranges.get(1).put("seta",8);
        ranges.get(1).put("tweed",2);
        ranges.get(1).put("velluto",3);
        ranges.get(1).put("lana",0);
        ranges.get(1).put("raso",7);
        ranges.get(1).put("lunga",2);
        ranges.get(1).put("corta",8);

        /* mappa 20° < temperatura <= 25° */
        ranges.get(2).put("cotone",10);
        ranges.get(2).put("poliestere",7);
        ranges.get(2).put("cashmere",2);
        ranges.get(2).put("lino",8);
        ranges.get(2).put("seta",9);
        ranges.get(2).put("tweed",2);
        ranges.get(2).put("velluto",4);
        ranges.get(2).put("lana", 1);
        ranges.get(2).put("raso",6);
        ranges.get(2).put("lunga",5);
        ranges.get(2).put("corta",5);

        /* mappa 15° < temperatura <= 20°  */
        ranges.get(3).put("cotone",10);
        ranges.get(3).put("poliestere",8);
        ranges.get(3).put("cashmere",5);
        ranges.get(3).put("lino",6);
        ranges.get(3).put("seta",7);
        ranges.get(3).put("tweed",6);
        ranges.get(3).put("velluto",5);
        ranges.get(3).put("lana", 4);
        ranges.get(3).put("raso",4);
        ranges.get(3).put("lunga",8);
        ranges.get(3).put("corta",2);

        /* mappa 10° < temperatura <= 15°  */
        ranges.get(4).put("cotone",8);
        ranges.get(4).put("poliestere",8);
        ranges.get(4).put("cashmere",7);
        ranges.get(4).put("lino",5);
        ranges.get(4).put("seta",6);
        ranges.get(4).put("tweed",6);
        ranges.get(4).put("velluto",6);
        ranges.get(4).put("lana", 8);
        ranges.get(4).put("raso",3);
        ranges.get(4).put("lunga",9);
        ranges.get(4).put("corta",1);

        /* mappa 5° < temperatura <= 10°  */
        ranges.get(5).put("cotone",8);
        ranges.get(5).put("poliestere",8);
        ranges.get(5).put("cashmere",8);
        ranges.get(5).put("lino",2);
        ranges.get(5).put("seta",4);
        ranges.get(5).put("tweed",7);
        ranges.get(5).put("velluto",8);
        ranges.get(5).put("lana", 9);
        ranges.get(5).put("raso",2);
        ranges.get(5).put("lunga",10);
        ranges.get(5).put("corta",0);

        /* mappa temperatura <= 5°  */
        ranges.get(6).put("cotone",8);
        ranges.get(6).put("poliestere",8);
        ranges.get(6).put("cashmere",10);
        ranges.get(6).put("lino",0);
        ranges.get(6).put("seta",3);
        ranges.get(6).put("tweed",8);
        ranges.get(6).put("velluto",9);
        ranges.get(6).put("lana", 10);
        ranges.get(6).put("raso",1);
        ranges.get(6).put("lunga",10);
        ranges.get(6).put("corta",0);


        stagionalita = new ArrayList<>();
        for(int i = 0; i < 4;i++ ){
            stagionalita.add(new Hashtable<>());
        }

        //TODO normalizzare i valori da 0 a 5
        //stagione inverno
        stagionalita.get(0).put("inverno", 10);
        stagionalita.get(0).put("autunno", 7);
        stagionalita.get(0).put("primavera", 4);
        stagionalita.get(0).put("estate", 0);
        stagionalita.get(0).put("primavera_estate", 0);
        stagionalita.get(0).put("autunno_inverno", 8);
        stagionalita.get(0).put("all", 5);

        //primavera
        stagionalita.get(1).put("primavera", 10);
        stagionalita.get(1).put("estate", 7);
        stagionalita.get(1).put("autunno", 5);
        stagionalita.get(1).put("inverno", 3);
        stagionalita.get(1).put("primavera_estate", 8);
        stagionalita.get(1).put("autunno_inverno",2);
        stagionalita.get(1).put("all", 5);
        //stagione estate
        stagionalita.get(2).put("estate", 10);
        stagionalita.get(2).put("autunno", 4);
        stagionalita.get(2).put("inverno", 0);
        stagionalita.get(2).put("primavera", 7);
        stagionalita.get(2).put("primavera_estate", 8);
        stagionalita.get(2).put("autunno_inverno", 0);
        stagionalita.get(2).put( "all", 5);
        // stagione autunno
        stagionalita.get(3).put("autunno", 10);
        stagionalita.get(3).put( "inverno", 7);
        stagionalita.get(3).put("primavera", 5);
        stagionalita.get(3).put("estate",3);
        stagionalita.get(3).put("primavera_estate", 2);
        stagionalita.get(3).put("autunno_inverno", 8);
        stagionalita.get(3).put("all",5);
    }

    public int valuta(CapoAbbigliamento capoAbbigliamento, MeteoInformation meteoInformation){
        if(capoAbbigliamento.getClass().equals(Maglia.class)){
            return valutazioneMaglia((Maglia) capoAbbigliamento, meteoInformation);
        }else{
            //TODO completare con gli altri capi d'abbigliamento

            return 0;
        }
    }

    private int valutazioneMaglia(Maglia maglia, MeteoInformation meteoInformation){
        int punteggio = 0;
        punteggio += valutazioneMateriale(maglia, meteoInformation);
        punteggio += valutazioneColore(maglia, meteoInformation);
        punteggio += valutazioneManica(maglia, meteoInformation);
        punteggio += valutazioneStagione(maglia);
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

    private int valutazioneMateriale(Maglia maglia, MeteoInformation meteoInformation) {
        /* Valutazione della maglia inserita dall'utente sulla base delle regole descritte su Drive */
        int temperaturaPercepita = (int) meteoInformation.getTemperaturaPercepita();
        int range = searchRange(temperaturaPercepita);

        int voto = 0;

        //try-catch aggiunto per debug, successivamente può essere rimosso
        try{
            voto = ranges.get(range).get(maglia.getMateriale());
        }catch(NullPointerException e){
            System.out.println(maglia.getMateriale());
            e.printStackTrace();
        }

        return  voto;
    }

    private int valutazioneColore(Maglia m, MeteoInformation meteoInformation){
        int voto;

        int i = searchRange((int) meteoInformation.getTemperaturaPercepita());

        if (m.getColore().equalsIgnoreCase("chiaro") && meteoInformation.getMeteo().equalsIgnoreCase("soleggiato") && i<=2){
            voto=10;
        }else if(m.getColore().equalsIgnoreCase("scuro") && meteoInformation.getMeteo().equalsIgnoreCase("soleggiato") && i<=2){
            voto=0;
        }else{
            voto=5;
        }

        return voto;
    }

    private int valutazioneManica(Maglia maglia, MeteoInformation meteoInformation) {
        int temperaturaPercepita = (int) meteoInformation.getTemperaturaPercepita();
        int range = searchRange(temperaturaPercepita);
        return ranges.get(range).get(maglia.getLunghezzaManica());
    }

    private String getStagione(){
        GregorianCalendar data = new GregorianCalendar();
        String[] seasons = {
                "inverno", "inverno", "primavera", "primavera", "primavera", "estate",
                "estate", "estate", "autunno", "autunno", "autunno", "inverno"
        };
        return seasons[data.get(Calendar.MONTH)];
    }

    private int valutazioneStagione (Maglia maglia){
        //TODO aggiornare per utilizzarla con la nuova hashmap
        String stagionePrevisione = getStagione();

        if(maglia.getStagione().equalsIgnoreCase(stagionePrevisione))
            return 10;
        if(maglia.getStagione().contains(stagionePrevisione) )
            return 7;
        if((maglia.getStagione().equalsIgnoreCase("estate") && stagionePrevisione.equalsIgnoreCase("inverno")) ||
                (maglia.getStagione().equalsIgnoreCase("inverno") && stagionePrevisione.equalsIgnoreCase("estate")) ||
                (maglia.getStagione().equalsIgnoreCase("primavera_estate") && stagionePrevisione.equalsIgnoreCase("inverno")) ||
                (maglia.getStagione().equalsIgnoreCase("autunno_inverno") && stagionePrevisione.equalsIgnoreCase("estate")))
            return 0;
        else //controlli
            return 4;
    }

}
