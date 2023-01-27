package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import io.jenetics.*;
import io.jenetics.engine.Constraint;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.CapoAbbigliamento;
import weatherstyle.gestionemeteo.applicationlogic.logic.beans.MeteoDailyMin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raffaele Aurucci, Angelo Palmieri, Annalaura Miglino, Francesco Giuseppe Zammarelli
 * classe che permette di fare il setup di un algoritmo genetico, lavora su una singola categoria di capi
 * d'abbigliamento per volta. Se si vogliono suggerimenti per diverse categorie è necessario istanziare una classe
 * per ogni categoria.
 * @param <T> tipo della categoria di capo d'abbigliamento, al momento è possibile lavorare solo su Maglie, Pantaloni e
 * Scarpe.
 */
class GeneticAlgorithm<T extends CapoAbbigliamento> implements ImplementorAlgorithm<T> {

    private static final int populationSize = 10;
    private static final EvaluatorGA evaluator = new EvaluatorGA();
    private List<T> capoAbbigliamentoList;
    private MeteoDailyMin meteoDailyMin;

    /**
     * metodo che ritorna i tre capi d'abbigliamento migliori mediante l'ausilio della ricerca con algoritmo genetico
     * @param capoAbbigliamentoList lista di capi d'abbigliamento da cui si vogliono ottenere i tre migliori
     * @param meteoDailyMin informazioni meteo
     * @return lista dei tre capi d'abbigliamento migliori
     */
    @Override
    public List<T> getBestThreeCapoAbbigliamento(List<T> capoAbbigliamentoList, MeteoDailyMin meteoDailyMin) {

        this.meteoDailyMin = meteoDailyMin;
        this.capoAbbigliamentoList = capoAbbigliamentoList;

        /*  La Factory permette di generare la prima generazione di individui, ovvero stabilendo come saranno fatti.
           Ogni individuo è un Genotipo definito a partire dalla sua caratteristica ereditaria più piccola
           ovvero geni di tipo intero, ed ha tre cromosomi.
           Ogni cromosoma ha un gene di tipo Integer che ha come valore minimo 0 e come massimo list.size()-1
           (Il numero di capi d'abbigliamento nella lista)
         */
        Factory<Genotype<IntegerGene>> gtf = Genotype.of(IntegerChromosome.of(0,capoAbbigliamentoList.size() - 1),
                IntegerChromosome.of(0,capoAbbigliamentoList.size() - 1),
                IntegerChromosome.of(0,capoAbbigliamentoList.size() - 1));

        // Vincoli per le nuove generazioni d'individui
        Constraint<IntegerGene, Integer> constraint = new ConstraintGA();

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

        // Setup dell'algoritmo genetico
        Engine<IntegerGene, Integer> engine = Engine.builder(this::eval,gtf)
                .selector(selector)
                .populationSize(populationSize)
                .alterers(crossover,mutation)
                .constraint(constraint)
                .build();

        // Si ottiene il miglior fenotipo dalle prime 100 evoluzioni
        Phenotype<IntegerGene, Integer> best =
                engine.stream().limit(100).collect(EvolutionResult.toBestPhenotype());

        // Si ottiene il genotipo
        Genotype<IntegerGene> bestGt =  best.genotype();
        List<T> bestList =  new ArrayList<>();

        // Si aggiungono alla lista i tre capi migliori
        bestList.add(capoAbbigliamentoList.get(bestGt.get(0).gene().intValue()));
        bestList.add(capoAbbigliamentoList.get(bestGt.get(1).gene().intValue()));
        bestList.add(capoAbbigliamentoList.get(bestGt.get(2).gene().intValue()));

        return bestList;
    }

    /**
     * rappresenta la funzione di fitness
     * @param genotype individuo passato in input dall'algoritmo genetico
     * @return il punteggio rispetto all'individuo
     */
    private int eval(Genotype<IntegerGene> genotype) {
        int punteggio = 0;

        if (genotype.get(0).gene().intValue() == genotype.get(1).gene().intValue()
                || genotype.get(0).gene().intValue() == genotype.get(2).gene().intValue()
                || genotype.get(1).gene().intValue() == genotype.get(2).gene().intValue()) {
            punteggio = 0;
        } else {
            for (int i = 0; i < genotype.length(); i++) {
                punteggio += evaluator.valuta((CapoAbbigliamento) capoAbbigliamentoList
                        .get(genotype.get(i).gene().intValue()), meteoDailyMin);
            }
            punteggio = punteggio / 3;
        }

        return punteggio;
    }
}
