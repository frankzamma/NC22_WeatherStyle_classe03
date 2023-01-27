package weatherstyle.gestionesuggerimentiia.applicationlogic.logic.algorithms;

import io.jenetics.Genotype;
import io.jenetics.IntegerChromosome;
import io.jenetics.IntegerGene;
import io.jenetics.Phenotype;
import io.jenetics.engine.Constraint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Raffaele Aurucci, Angelo Palmieri, Annalaura Miglino, Francesco Giuseppe Zammarelli
 * classe che definisce i metodi per i vincoli degli individui
 */
class ConstraintGA implements Constraint<IntegerGene, Integer> {

    /**
     * Metodo che viene chiamato per testare se i nuovi individui rispettano il vincolo
     * @param phenotype testa il fenotipo di una generica iterazione
     **/
    @Override
    public boolean test(Phenotype<IntegerGene, Integer> phenotype) {
        Genotype<IntegerGene> g = phenotype.genotype();
        if (g.get(0).gene().intValue() != g.get(1).gene().intValue()
                && g.get(0).gene().intValue() != g.get(2).gene().intValue()
                && g.get(1).gene().intValue() != g.get(2).gene().intValue()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Meteodo che viene utilizzato per riparare gli individui che non rispettano il vincolo
     * @param phenotype fenotipo di una generica iterazione
     * @param numberGeneration numero della generazione a cui appartiene l'individuo
    **/
    @Override
    public Phenotype<IntegerGene, Integer> repair(Phenotype<IntegerGene, Integer> phenotype, long numberGeneration) {
        Set<Integer> distinctValue = new HashSet<>();

        int max = phenotype.genotype().gene().max();
        int min = phenotype.genotype().gene().min();
        do{
            distinctValue.add((int) (Math.floor(Math.random() * (max + 1))));
        }while (distinctValue.size() != 3);

        ArrayList<Integer> values =  new ArrayList<>(distinctValue);
        Genotype<IntegerGene> genotype = Genotype.of(
                IntegerChromosome.of(IntegerGene.of(values.get(0),min, max)),
                IntegerChromosome.of(IntegerGene.of(values.get(1), min, max)),
                IntegerChromosome.of(IntegerGene.of(values.get(2), min, max))
        );

        return Phenotype.of(genotype,numberGeneration);
    }
}
