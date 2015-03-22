package ga_swing;

public class Population {

    Individual[] individuals;
    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        if (initialise) {
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        //int index = 0;
        for (int i=0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                //System.out.println("fittest.getFitness() = " + fittest.getFitness() + " < " + "getIndividual(i).getFitness() = " + getIndividual(i).getFitness());
                fittest = getIndividual(i);
                //index = i;
            }
        }
        //System.out.println("index " +index  + " was choosen in tournament with bigest fitness " +fittest.getFitness() + " equal to his " + getIndividual(index).getFitness() );
        return fittest;
    }

    /* Public methods */
    // Get population size
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
