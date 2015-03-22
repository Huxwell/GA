package ga_swing;

public class Algorithm {

    private static double uniformRate = 0.5;
    public static double mutationRate = 0.015;
    public static int tournamentSize = 5;
    public static boolean elitism = true;
    public static double crossoverRate = 1.0;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);
        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
        }
        int offset;
        if (elitism) {
            offset = 1;
        } else {
            offset = 0;
        }
        // Loop over the population size and create new individuals with crossover

        for (int i = offset; i < pop.size(); i++) {
            if (((double) i / pop.size()) <= crossoverRate) {
                // if(true){

                Individual indiv1 = tournamentSelection(pop);
                Individual indiv2 = tournamentSelection(pop);
                //if(indiv1 == indiv2) System.out.println("=======same==========");
                Individual newIndiv = crossover(indiv1, indiv2);
                newPopulation.saveIndividual(i, newIndiv);
                System.out.println("CROSSOVER " + ((double)i / pop.size())
                        + " <= " + crossoverRate);
            } else {
                newPopulation.saveIndividual(i, pop.getIndividual(i));
                System.out.println("NO CROSSOVER " + ((double)i / pop.size())
                        + " >= " + crossoverRate);
            }
        }
        // Mutate population
        main.modeGenes = 2;
        for (int i = offset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }
        main.modeGenes = 1;
        for (int i = offset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        // Loop through genes
        main.modeGenes = 2;
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        main.modeGenes = 1;
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        System.out.println("we are in mode: " + main.modeGenes);
        System.out.println("crossover between " + indiv1.toString() + " and " + indiv2.toString());
        System.out.println("crossover effect:" + newSol.toString());

        main.crossoverCount++;

        return newSol;
    }

    private static void mutate(Individual indiv) {
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    private static Individual tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        Individual fittest = tournament.getFittest();
        return fittest;
    }
}
