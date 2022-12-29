package org.example;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.singleobjective.geneticalgorithm.GeneticAlgorithmBuilder;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.crossover.impl.NPointCrossover;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.JMetalLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("MaglieList");

        Scanner sc =  new Scanner(f);
        ArrayList<Maglia> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] tmp = s.split(",");

            list.add(new Maglia(tmp[0], tmp[1], tmp[2], tmp[3]));
        }

        for(Maglia maglia: list)
            System.out.println(maglia);

        MeteoInformation meteo = new MeteoInformation(25, "nuvoloso");

        double crossoverProbability = 0.8;
        double mutationProbability = 0.01;
        int maxEvaluations = 1000;
        int populationSize = 10;


        BinaryTournamentSelection<IntegerSolution> selection = new BinaryTournamentSelection<>();
        IntegerNPointCrossover crossover = new IntegerNPointCrossover(crossoverProbability, 1);

        // With 0.01 probability a gene is mutated: a randomly-chosen gene is copied from the left side (0.5) or right side (0.5)
        IntegerPolynomialMutation mutation = new IntegerPolynomialMutation(mutationProbability, 0);

        Problem<IntegerSolution> problem = new MagliaProblem("MaglieProblem", list, meteo);


        Algorithm<IntegerSolution> sga = new GeneticAlgorithmBuilder<>(problem, crossover, mutation)
                .setPopulationSize(populationSize)
                .setMaxEvaluations(maxEvaluations)
                .setSelectionOperator(selection)
                .build();

        AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(sga).execute();
        IntegerSolution bestIndividual = sga.getResult();

        JMetalLogger.logger.info(String.format("Problem: %s", problem.getName()));
        JMetalLogger.logger.info(String.format("Solution: %s", bestIndividual.getVariables()));
        JMetalLogger.logger.info(String.format("Evaluation: %s", Arrays.toString(bestIndividual.getObjectives())));
        JMetalLogger.logger.info(String.format("Total execution time: %s ms", algorithmRunner.getComputingTime()));

        List<Integer> list1 = bestIndividual.getVariables();

        for(Integer integer: list1){
            System.out.println(list.get(integer));
        }


    }
}