package Logic.ga;

import Model.CapoAbbigliamento;
import Model.MeteoInformation;

import io.jenetics.*;
import io.jenetics.engine.Constraint;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

import java.util.ArrayList;
import java.util.List;

public class GenericGA {

    private static final int populationSize = 10;
    private Engine<IntegerGene,Integer> engine;
    private List<CapoAbbigliamento> listaCapi;
    private static final Evaluator evaluator = new Evaluator();
    private MeteoInformation meteoInformation;

    public GenericGA(List<? extends  CapoAbbigliamento> list, MeteoInformation meteoInformation) {
        this.listaCapi = (List<CapoAbbigliamento>) list;
        this.meteoInformation = meteoInformation;

        /*  La Factory permette di generare la prima generazione di individui, ovvero stabilendo come saranno fatti.
         *  Ogni individuo è un Genotipo definito a partire dalla sua caratteristica ereditaria più piccola
         *  ovvero geni di tipo intero, ed ha tre cromosomi.
         *  Ogni cromosoma ha un gene di tipo Integer che ha come valore minimo 0 e come massimo list.size()-1
         *  (Il numero di capi d'abbigliamento nella lista)
         * */
        Factory<Genotype<IntegerGene>> gtf = Genotype.of(IntegerChromosome.of(0, list.size() -1),
                IntegerChromosome.of(0, list.size() - 1) , IntegerChromosome.of(0, list.size() -1));

        // Vincoli per le nuove generazioni d'individui
        Constraint<IntegerGene, Integer> constraint = new ClothesGAConstraint();

        // Definiamo attraverso il constraint una generazione iniziale pseudo-casuale che rispetta i vincoli
        gtf = constraint.constrain(gtf);

        // Operatore di selezione, l'operatore assegna una probabilità di selezione agli individui andando a considerare
        // nel calcolo il valore di fitness, selezionerà alla fine n individui
        Selector<IntegerGene, Integer> selector =  new RouletteWheelSelector<>();

        // Operatore di crossover, l'operatore opererà in maniera simile al single point crossover, ma utilizzerà
        // per default due punti di crossover in maniera casuale, con una probabilità di 0.25
        Alterer<IntegerGene, Integer> crossover =  new MultiPointCrossover<>(0.25);

        // Operatore di mutazione, l'operatore cambierà un gene prendendo un numero dalla distribuzione di Gauss
        // calcolata partendo dal valore corrente del gene
        Alterer<IntegerGene, Integer> mutation =  new GaussianMutator<>();

        //Setup dell'algoritmo genetico
        engine =  Engine.builder(this::eval, gtf)
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
                punteggio += evaluator.valuta(listaCapi.get(gt.get(i).gene().intValue()), meteoInformation);
            }
            punteggio = punteggio/3;
        }

        return punteggio;
    }

    public List<CapoAbbigliamento> getBestResult(){
        Phenotype<IntegerGene, Integer> best =
                engine.stream().limit(100).collect(EvolutionResult.toBestPhenotype());

        Genotype<IntegerGene> bestGt =  best.genotype();

        List<CapoAbbigliamento> list =  new ArrayList<>();

        list.add(listaCapi.get(bestGt.get(0).gene().intValue()));
        list.add(listaCapi.get(bestGt.get(1).gene().intValue()));
        list.add(listaCapi.get(bestGt.get(2).gene().intValue()));

        return list;
    }
}
