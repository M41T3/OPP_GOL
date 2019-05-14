package lab3_4.gameOfLife;

import java.util.Arrays;

public class Population {

	private double ratio;	//probability of appearance
	private int amount;		// amount of cells
	private int generation;
	private boolean[][] field;	// population field: True, False
	private int[] amountHist;	// array of amounts from last generations
	
	public Population(double ratio) {
		setRatio(ratio);
		this.field  = generateField(this.ratio);
		this.setAmount(calcAmount(this.field));
		this.amountHist = new int[400];
		Arrays.fill(amountHist, 0);
		this.setAmountHist(getAmount(), getGeneration());
	}
	
	public void setRatio(double ratio) {
		
		if (ratio <= 1 && ratio >= 0)
			this.ratio = ratio;
	}
	
	public void setField(boolean field[][]) {		// new field is set -> update amount, amountHist
		this.field = field;
		this.setAmount(calcAmount(this.field));
		this.setAmountHist(getAmount(), getGeneration());
		//System.out.println(getAmount()); //[DEBUG]
	}
	
	public boolean[][] getField() {
		return this.field;
	}
	
	public double getRatio() {
		return this.ratio;
	}
	
	public static boolean[][] generateField(double ratio){ 
		
		boolean[][] tmp_field = new boolean[50][50];
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 50; y++) {
				 tmp_field[x][y] = (Math.random() < ratio);	// generates doubles between 0 and 1. To get probability multiply with ratio
			}
		}
		return  tmp_field;
	}	
	
	public int calcAmount(boolean field[][]) {
		int counter = 0;
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 50; y++) {
				
				if(this.field[x][y]) // Counts every cell
					counter++;
			}
		}
		return counter;
	}
	
	public int getAmount() {
		return amount;
	}

	private void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	public int getGeneration() {
		return generation;
	}

	private void setGeneration(int generation) {
		this.generation = generation;
	}

	public void nextGeneration() {		// Changes field according to game rules
		
		// Game Rules
		
		setAmount(calcAmount(this.field)); // not done yet
		setGeneration(++this.generation);
		this.setAmountHist(getAmount(), getGeneration());
		//System.out.println(getGeneration()); //[DEBUG]
	}
	
	public int[] getAmountHist() {
		return amountHist;
	}

	public void setAmountHist(int amount, int generation) {	// Add value to history array
		this.amountHist[generation] = amount;
	}
	
	public void debug() {									// Debug-Method [DEBUG]
		System.out.println("Ratio = " + this.ratio + "\n");
		System.out.println("Population-Matrix: \n");
		
		int n;
		int counter = 0;
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 50; y++) {
				
				if(this.field[x][y]) { 
					n = 1;
					counter++;
				}
				else n = 0;
				
				System.out.print(n + " ");
			}
			System.out.println(" ");
		}
		System.out.println("Verhältnis = " + counter + " / 2500");
	}	
}
