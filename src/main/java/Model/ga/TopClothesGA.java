package Model.ga;

import Model.CapoAbbigliamento;
import Model.Evaluator;
import Model.MeteoInformation;
import io.jenetics.*;
import io.jenetics.engine.Constraint;
import io.jenetics.engine.Engine;
import io.jenetics.util.Factory;

import java.util.List;

public class TopClothesGA {

    private static final int populationSize = 10;
    private Engine<IntegerGene,Integer> engine;
    private List<CapoAbbigliamento> capoAbbigliamentoList;
    private Evaluator evaluator;//TODO da valutare se inserirlo come statico
    private MeteoInformation  meteoInformation;

    public TopClothesGA(List<CapoAbbigliamento> list, MeteoInformation meteoInformation) {
        this.capoAbbigliamentoList = list;
        this.meteoInformation = meteoInformation;
        this.evaluator = new Evaluator();

        /* Creazione della factory -> permette di generare la prima generazione di individui
        *  Ogni individuo è un Genotipo che ha tre cromosomi.
        *  Ogni cromosoma ha un gene di tipo Integer che ha come valore minimo 0 e come massimo list.size()-1
        *  (Il numero di capi d'abbigliamento nella lista)
        * */
        Factory<Genotype<IntegerGene>> gtf = Genotype.of(IntegerChromosome.of(0, list.size() -1),
                IntegerChromosome.of(0, list.size() - 1) , IntegerChromosome.of(0, list.size() -1));

        //Vincolo per le nuove generazioni
        Constraint<IntegerGene, Integer> constraint = new ClothesGAConstraint();

        //Operatore di selezione
        Selector<IntegerGene, Integer> selector =  new RouletteWheelSelector<>();
        //Operatore di crossover
        Alterer<IntegerGene, Integer> crossover =  new SinglePointCrossover<>();
        //Operatore di mutazione
        Alterer<IntegerGene, Integer> mutation =  new GaussianMutator<>();

        //Setup dell'algoritmo genetico
        engine =  Engine.builder(this::eval, gtf)//Viene passato la funzione di fitness e la factory
                .selector(selector)
                .populationSize(populationSize)
                .alterers(crossover, mutation)
                .constraint(constraint)
                .build();
    }

    private int eval(Genotype<IntegerGene> gt) {
        int punteggio = 0;

        if(gt.get(0).gene().intValue() == gt.get(1).gene().intValue()
                || gt.get(0).gene().intValue() == gt.get(2).gene().intValue()
                || gt.get(1).gene().intValue() == gt.get(2).gene().intValue()){
            punteggio = 0;
        }else{
            for(int i = 0; i < gt.length(); i++) {
                punteggio += evaluator.valuta(capoAbbigliamentoList.get(gt.get(i).gene().intValue()), meteoInformation);
            }
            punteggio = punteggio/3;
        }

        return punteggio;
    }
}
