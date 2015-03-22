package ga_swing;

public class Individual {

    static int defaultGeneLength = 16;
    private byte[] genes = new byte[defaultGeneLength];
    private byte[] genes2 = new byte[defaultGeneLength];
    public double x1, x2;
    // Cache
    private double fitness = 0;

    // Create a random individual
    public void generateIndividual() {
        genes[0] = 1;
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }

        genes2[0] = 0;
        for (int i = 1; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes2[i] = gene;
        }
        System.out.println("generating " + this.toString() + " " + this.getFenotype());// + " and " + feno2);
    }

    public byte getGene(int index) {
        if (main.modeGenes == 1) {
            return genes[index];
        } else {
            return genes2[index];
        }
    }

    public double getFenotype() {
        return ((double) Integer.parseInt(this.toString(), 2) / 1000) - 10;
    }

    public void setGene(int index, byte value) {
        if (main.modeGenes == 1) {
            genes[index] = value;
        } else {
            genes2[index] = value;
        }
        fitness = 0;
    }

    public int size() {
        return genes.length;
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = calcFitness();
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }

    double calcFitness() {
        int remMode = main.modeGenes;
        double fitness = 0;
        main.modeGenes = 1;
        
        x1 = Coding.binDecode(this.toString());
        main.modeGenes = 2;
        
        x2 = Coding.binDecode(this.toString());

        System.out.println("x1:" + x1 + "  x2:" + x2);
        double y = Coding.evalY(x1, x2);
        fitness = -y;
        System.out.println("fittnes:" + fitness);
        main.modeGenes = remMode;
        return fitness;
    }

}
