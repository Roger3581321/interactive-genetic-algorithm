package interactive_genetic_algorithm.operator;

import interactive_genetic_algorithm.Constants;
import interactive_genetic_algorithm.Individual;

import java.util.ArrayList;
import java.util.Random;

// mutate randomly
public class MutationOperator {
	public int mBit1 = 0;
	public int mBit2 = 0;
	public int mBit3 = 0;
	public int mBit4 = 0;
	public int mBit5 = 0;

	// mutate method
	public static void mutate(Individual individual) {
		Random r = new Random();
		// select mutation points
		int[] genes = individual.getGenes();
		ArrayList<Integer> mPos = new ArrayList<Integer>(Constants.M_LEN);
		// randomly generated among 5 positions
		int mBit1 = r.nextInt(Constants.GENE_LEN_PER_PART);
		int mBit2 = r.nextInt(Constants.GENE_LEN_PER_PART) + 4;
		int mBit3 = r.nextInt(Constants.GENE_LEN_PER_PART) + 8;
		int mBit4 = r.nextInt(Constants.GENE_LEN_PER_PART) + 12;
		int mBit5 = r.nextInt(Constants.GENE_LEN_PER_PART) + 16;
		
		mPos.add(mBit1);
		mPos.add(mBit2);
		mPos.add(mBit3);
		mPos.add(mBit4);
		mPos.add(mBit5);

		// reverse the gene
		if(genes != null && genes.length == Constants.GENE_LEN) {
			for(int i : mPos) {
				if (genes[i] == 0) {
					genes[i] = 1;
				} else {
					genes[i] = 0;
				}
			}
		}
		return;
	}
}
