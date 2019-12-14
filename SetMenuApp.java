package interactive_genetic_algorithm;

import interactive_genetic_algorithm.operator.CrossoverOperator;
import interactive_genetic_algorithm.operator.MutationOperator;
import interactive_genetic_algorithm.operator.SelectionOperator;

import java.util.Scanner;

public class SetMenuApp {
	
	public static void main(String[] args) {
		int i = 0;
		int[] mates = new int[2];
		Individual[] offsprings = new Individual[2];
		int mark = 0;
		Scanner sc = null;

		// initialize the population
		Population sets = new Population();
		sets.initialize();
				
		// evolution before checking the termination conditions
		while (i < Constants.GENERATION_NUM) {
			// evaluate fitness
			System.out.println("Start to evaulate... " + i + " Genernation");
			for (int g = 0; g < Constants.SIZE; g++) {
				Individual setMenu = sets.group.get(g);
				System.out.println("This is the " + g + " set menu");
				System.out.println("Here is setMenu...");
				for(int gene : setMenu.getGenes()) {
					System.out.print(gene);				
				}
				System.out.println("");
				System.out.println("Please refer to the map table");
				System.out.println("Give relative marks from 0 to 10, 0 indicates disgusting, 10 indicates favorite");
		        sc = new Scanner(System.in);			
				mark = sc.nextInt();
		        setMenu.setFitness(mark);
			}
			// sort all individuals by fitness
			sets.bubbleSort();
					
			// do selection
			mates = SelectionOperator.selectByRoutteWheel(sets);
			
			// do crossover
			if (Math.random() <= Constants.PC) {
				offsprings = CrossoverOperator.crossover(sets.group.get(mates[0]), sets.group.get(mates[1]));
				// replace the second lastest, the lastest individuals
				sets.group.set(0, offsprings[0]);
				sets.group.set(1, offsprings[1]);
			}
			
			// do mutation
			int eliteIndex = SelectionOperator.selectElite();
			double pm = Math.random();
			if (pm <= Constants.PM) {
				int index = 0;
				for (Individual individual : sets.group) {
					if(index < sets.group.size() - eliteIndex) {
						MutationOperator.mutate(individual);												
					}
					index++;
				}
			}
			i++;
		}
		sc.close();
		// print the best solutions
		System.out.println("Here are setMenus as the best solutions");
		for (int g = 0; g < Constants.SIZE; g++) {
			Individual setMenu = sets.group.get(g);
			for(int gene : setMenu.getGenes()) {
				System.out.print(gene);				
			}					
			System.out.println("");
		}
		return;
	}
}
