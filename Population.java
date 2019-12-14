package interactive_genetic_algorithm;

import interactive_genetic_algorithm.Constants;

import java.util.ArrayList;

public class Population {
	// list containing individuals
	public ArrayList<Individual> group = new ArrayList<Individual>(Constants.SIZE);  
	
	// initialize the population
	public void initialize() {
		// according to set menu mapping table
		Individual individual1 = new Individual(0, new int[]{0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual2 = new Individual(0, new int[]{0,0,0,1, 0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual3 = new Individual(0, new int[]{0,0,1,0, 0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual4 = new Individual(0, new int[]{0,0,1,1, 0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual5 = new Individual(0, new int[]{0,0,0,0, 0,0,0,1, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual6 = new Individual(0, new int[]{0,0,0,0, 0,0,1,0, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual7 = new Individual(0, new int[]{0,0,0,0, 0,0,1,1, 0,0,0,0, 0,0,0,0, 0,0,0,0});
		Individual individual8 = new Individual(0, new int[]{0,0,0,0, 0,0,0,0, 0,0,0,1, 0,0,0,0, 0,0,0,0});
		Individual individual9 = new Individual(0, new int[]{0,0,0,0, 0,0,0,0, 0,0,1,0, 0,0,0,0, 0,0,0,0});
		Individual individual10 = new Individual(0, new int[]{0,0,0,0, 0,0,0,0, 0,0,1,1, 0,0,0,0, 0,0,0,0});

		group.add(individual1);
		group.add(individual2);
		group.add(individual3);
		group.add(individual4);
		group.add(individual5);
		group.add(individual6);
		group.add(individual7);
		group.add(individual8);
		group.add(individual9);
		group.add(individual10);
	}

	public Individual getTheFittest() {
		if(group.get(0) != null) {
			return group.get(0);			
		} else {
			return null;
		}
	}

	public void bubbleSort() {
		Individual tmp = null;
		for(int out = Constants.SIZE - 1; out > 0; out--) {
			for(int in = 0; in < out; in++) {
				if(group.get(in).getFitness() > group.get(in + 1).getFitness()) {
					tmp = group.get(in + 1);
					group.set(in + 1, group.get(in));
					group.set(in, tmp);					
				}
			}
		}
		return;
	}
}
