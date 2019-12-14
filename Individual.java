package interactive_genetic_algorithm;

public class Individual {	
	// give relative marks from 0 to 10, 0 indicates disgusting, 10 indicates favorite
	private int   fitness  			 = 0;
	private int[] genes 			 = new int[Constants.GENE_LEN];
	
	public Individual() {}
	
	public Individual(int fitness, int[] genes) {
		this.fitness = fitness;
		this.genes = genes;
	}
	
	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public int calFit() {
		return fitness;
	}
	
	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
}
