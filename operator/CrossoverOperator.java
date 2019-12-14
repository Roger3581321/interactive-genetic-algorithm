package interactive_genetic_algorithm.operator;

import interactive_genetic_algorithm.Constants;
import interactive_genetic_algorithm.Individual;

import java.util.Random;


public class CrossoverOperator {
	
	// crossover procedure
	// step 1	select crossover point
	// step 2	swap genes
	public static Individual[] crossover(Individual i1, Individual i2) {
		Individual[] offsprings = new Individual[2]; 
		Random r = new Random();
		
		// randomly select
		int crossPoint = r.nextInt(Constants.GENE_LEN);
		int[] tmpGenes = new int[Constants.GENE_LEN];
		
		if(i1 == null || i2 == null) {
			return offsprings;
		}
		
		// inialize the temp
		for(int i = 0; i < Constants.GENE_LEN; i++) {
			tmpGenes[i] = 0;
		}
		
		// deep copy
		offsprings[0] = new Individual(i1.getFitness(), i1.getGenes());
		offsprings[1] = new Individual(i2.getFitness(), i2.getGenes());
		for(int i = 0; i <= crossPoint; i++) {
			tmpGenes[i] = offsprings[0].getGenes()[i];
			offsprings[0].getGenes()[i] = offsprings[1].getGenes()[i];
			offsprings[1].getGenes()[i] = tmpGenes[i];
		}
		return offsprings;
	}
	
	public static void main(String args[]) {
		while (true) {
			int i = new Random().nextInt(Constants.GENE_LEN);
			System.out.println(i);
		}
	}
}
