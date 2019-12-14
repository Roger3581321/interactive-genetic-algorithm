package interactive_genetic_algorithm.operator;

import interactive_genetic_algorithm.Constants;
import interactive_genetic_algorithm.Population;

// use the elite model combined with routte wheel
// select the top elite to reserve
// and select the top 2 and 3 to mate by routte wheel, replace the bottom
public class SelectionOperator {
	
	public static int selectElite() {
		return Constants.ELITE_NUM;
	}
	
	public static int[] selectByRoutteWheel(Population p) {
		double[] pFitness = new double[Constants.SIZE];
		double fitnessSum = 0;
		int[] fittests = new int[2];
	
		// calculate the fitness sum but does not include the elite
		for(int i = 1; i < p.group.size(); i++) {
			fitnessSum += p.group.get(i).getFitness();
		}
		
		// initialize pFitness
		int eliteIndex = selectElite();
		for(int i = 0; i < p.group.size(); i++) {
			// skip the elite
			if (i > p.group.size() - 1 - eliteIndex) {
				pFitness[i] = 0;				
			} else {
				pFitness[i] = p.group.get(i).getFitness() / fitnessSum;				
			}
		}
		int ret1 = routteWheel(pFitness);
		int ret2 = routteWheel(pFitness);
		while (ret1 == ret2) {
			ret2 = routteWheel(pFitness);
		}
		
		fittests[0] = ret1;
		fittests[1] = ret2;
		return fittests;
	}

	// routte wheel algorithm
	private static int routteWheel(double[] pFitness) {
		double r 		 = Math.random();
		double spinwheel = 0;
		int index = 0;
		
		// spin the wheel
		for(int i = 0; i < pFitness.length; i++) {
			spinwheel += pFitness[i];
			if(r < spinwheel) {
				index = i;
				break;
			}
		}
		return index;
	}
}
