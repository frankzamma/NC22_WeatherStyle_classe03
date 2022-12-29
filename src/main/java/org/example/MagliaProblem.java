package org.example;

import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.solutionattribute.impl.NumberOfViolatedConstraints;

import java.util.*;

public class MagliaProblem extends AbstractIntegerProblem{
    private static final int size = 3;
    private List<Maglia> list;
    private MeteoInformation meteoInformation;
    private List<Hashtable<String, Integer>> ranges;  //si tiene traccia della corrispondenza tra intervalli di temperatura e materiali associati

    public MagliaProblem(String nomeProblema, List<Maglia> l, MeteoInformation meteoInformation){
        this.list = l;
        this.meteoInformation = meteoInformation;
        this.initTable();
        /* nome del problema */
        super.setName(nomeProblema);

        /* numero di individui per ogni popolazione di dimensione 3: x1, x2, x3 */
        super.setNumberOfVariables(size);

        /* valori assunti dagli individui in termini di limite inferiore e superiore:
        *  es: gene i-esimo: lower-bound = 0
        *                    upper-bound = list.size()
        * */
        List<Integer> lowerBound = new ArrayList<>();
        List<Integer> upperBound = new ArrayList<>();

        for(int i= 0; i < size; i++){
            lowerBound.add(0);
            upperBound.add(list.size()-1);
        }

        setVariableBounds(lowerBound, upperBound);

        /* numero di vincoli della popolazione.
        *  Nel nostro caso: individui diversi

        /* numero di funzioni di fitness da valutare */
        setNumberOfObjectives(1);
    }

    public void initTable(){
        ranges =  new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            ranges.add(new Hashtable<>());
        }

        /* mappa temperatura > 30° */
        ranges.get(0).put("cotone",9);
        ranges.get(0).put("poliestere",4);
        ranges.get(0).put("cashmere",1);
        ranges.get(0).put("lino",10);
        ranges.get(0).put("seta",10);
        ranges.get(0).put("tweed",2);
        ranges.get(0).put("velluto",3);
        ranges.get(0).put("lana", 0);
        ranges.get(0).put("raso",8);
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
        ranges.get(0).put("raso",7);
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
        ranges.get(0).put("lunga",5);
        ranges.get(0).put("corta",5);

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
        ranges.get(4).put("cotone",9);
        ranges.get(4).put("poliestere",8);
        ranges.get(4).put("cashmere",7);
        ranges.get(4).put("lino",5);
        ranges.get(4).put("seta",6);
        ranges.get(4).put("tweed",6);
        ranges.get(4).put("velluto",6);
        ranges.get(4).put("lana", 7);
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
    }


    public int searchRange(int temperaturaPercepita) {
        int range;

        if (temperaturaPercepita >= 30) {
            range = 0;
        }
        else if (temperaturaPercepita >= 25) {
            range = 1;
        }
        else if (temperaturaPercepita >=20) {
            range = 2;
        }
        else if (temperaturaPercepita >= 15) {
            range = 3;
        }
        else if (temperaturaPercepita >= 10) {
            range = 4;
        }
        else if(temperaturaPercepita >= 5){
            range = 5;
        }
        else{
            range = 6;
        }

        return range;
    }

    /* integerSolution: x1, x2, x3 */
    @Override
    public void evaluate(IntegerSolution integerSolution) {

        int punteggio = 0;

        for(int i = 0; i < size; i++)
            punteggio += this.valutazioneMaglia(this.list.get(integerSolution.getVariable(i)) , meteoInformation);

        punteggio = punteggio/4;
        integerSolution.getObjectives()[0] = punteggio * (-1.0);
        
        /* Codice costraint */
        // rappresentano la lista di individui
        List<Integer> list = integerSolution.getVariables();

        //vincolo che sono diversi gli elementi tra loro
        if( (list.get(0)  == list.get(1)) || (list.get(0) == list.get(2)) || (list.get(1) == list.get(2)) )
            integerSolution.getObjectives()[0] = 0;


    }

    public int valutazioneMaglia(Maglia maglia, MeteoInformation meteoInformation){
        int punteggio = 0;
        punteggio += this.valutazioneMateriale(maglia, meteoInformation);
        punteggio += this.valutazioneColore(maglia, meteoInformation);
        punteggio += this.valutazioneManica(maglia, meteoInformation);
        punteggio += this.valutazioneStagione(maglia);
        return punteggio;
    }

    public int valutazioneMateriale(Maglia maglia, MeteoInformation meteoInformation) {
        /* Valutazione della maglia inserita dall'utente sulla base delle regole descritte su Drive */
        int temperaturaPercepita =  meteoInformation.getTemperaturaPercepita();
        int range = this.searchRange(temperaturaPercepita);
        return ranges.get(range).get(maglia.getMateriale());
    }

    public int valutazioneColore(Maglia m, MeteoInformation meteoInformation){
        /*
        * colore chiaro: +10
		  colore scuro:  +2
		  colore a metà: +6;
        * */
        int voto = 0;
        if(meteoInformation.getMeteo().equalsIgnoreCase("soleggiato")){
            switch (m.getColore()) {
                case "chiaro" -> voto = 10;
                case "scuro" -> voto = 2;
                case "colorato" -> voto = 6;
            }
        }
        return voto;
    }

    public int valutazioneManica(Maglia maglia, MeteoInformation meteoInformation) {
        int temperaturaPercepita = meteoInformation.getTemperaturaPercepita();
        int range = this.searchRange(temperaturaPercepita);
        return ranges.get(range).get(maglia.getLunghezzaManica());
    }

    private String getStagione(){
        GregorianCalendar data = new GregorianCalendar();
        String seasons[] = {
                "inverno", "inverno", "primavera", "primavera", "primavera", "estate",
                "estate", "estate", "autunno", "autunno", "autunno", "inverno"
       };
       return seasons[data.get(Calendar.MONTH)];
    }

    public int valutazioneStagione (Maglia maglia){
        int value;

        if(getStagione().equalsIgnoreCase(maglia.getStagione())){
            value = 10;
        }
        else if(maglia.getStagione().contains(getStagione())){
            value = 7;
        }
        else if(maglia.getStagione().equalsIgnoreCase("all")){
            value = 5;
        }
        else
            value = 0;

        return value;
    }

}



