package lab3_4.gameOfLife;

import java.util.Arrays;

public class Population {

	private double ratio;	//probability of appearance
	private int amount;		// amount of cells
	private int generation;
	private boolean[][] field;	// population field: True, False
	private boolean[][] tmp_field; // Copy matrix 
	private int[] amountHist;	// array of amounts from last generations
	
	public Population(double ratio) {
		tmp_field = new boolean[50][50]; 
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

	public void setGeneration(int generation) {
		this.generation = generation;
	}
	
	public void resetAmountHist() {
		Arrays.fill(this.amountHist, 0); 
		
	}

	public void nextGeneration() {		// Changes field according to game rules
		
		// Game Rules---
		
		
		int sum;
		
		for(int x = 1; x < 49; x++) {		// Top middle
			
			sum = 0;
			
			if(this.field[x-1][0]) sum++;
			if (this.field[x+1][0]) sum++;
			if (this.field[x-1][1]) sum++;
			if (this.field[x][1]) sum++;
			if (this.field[x+1][1]) sum++;
	
			//System.out.println(sum); //[DEBUG]
			
			if((sum <= 3 && sum >=2 && this.field[x][0] == true) || (sum == 3 && this.field[x][0] == false))
				tmp_field[x][0] = true;
			else tmp_field[x][0] = false;		
		}
		
		for(int x = 1; x < 49; x++) {		// Bottom	 middle
			
			sum = 0;
			
			if(this.field[x-1][49]) sum++;
			if (this.field[x+1][49]) sum++;
			if (this.field[x-1][48]) sum++;
			if (this.field[x][48]) sum++;
			if (this.field[x+1][48]) sum++;
	
			if((sum <= 3 && sum >=2 && this.field[x][48] == true) || (sum == 3 && this.field[x][48] == false))
				tmp_field[x][48] = true;
			else tmp_field[x][48] = false;		
		}
		
		for(int y = 1; y < 49; y++) {		// Left middle
			
			sum = 0;
			
			if(this.field[0][y-1]) sum++;
			if (this.field[0][y+1]) sum++;
			if (this.field[1][y-1]) sum++;
			if (this.field[1][y]) sum++;
			if (this.field[1][y+1]) sum++;
	
			if((sum <= 3 && sum >=2 && this.field[0][y] == true) || (sum == 3 && this.field[0][y] == false))
				tmp_field[0][y] = true;
			else tmp_field[0][y] = false;		
		}
		
		for(int y = 1; y < 49; y++) {		// Right middle
			
			sum = 0;
			
			if(this.field[49][y-1]) sum++;
			if (this.field[49][y+1]) sum++;
			if (this.field[48][y-1]) sum++;
			if (this.field[48][y]) sum++;
			if (this.field[48][y+1]) sum++;
	
			if((sum <= 3 && sum >=2 && this.field[49][y] == true) || (sum == 3 && this.field[49][y] == false))
				tmp_field[49][y] = true;
			else tmp_field[49][y] = false;		
		}
		
		
		for(int x = 1; x < 49; x++) {			// Middle
			for(int y = 1; y < 49; y++) {
				
				sum = 0;
				
				if(this.field[x-1][y]) sum++;
				if (this.field[x-1][y-1]) sum++;
				if (this.field[x-1][y+1]) sum++;
				if (this.field[x][y-1]) sum++;
				if (this.field[x][y+1]) sum++;
				if (this.field[x+1][y]) sum++;
				if (this.field[x+1][y-1]) sum++;
				if (this.field[x+1][y+1]) sum++;
				
				
				if((sum <= 3 && sum >=2 && this.field[x][y] == true) || (sum == 3 && this.field[x][y] == false))
					this.tmp_field[x][y] = true;
				else this.tmp_field[x][y] = false;			
			}
		}
		
		
		sum = 0;							// Corner Top-Left
		
		if(this.field[1][1]) sum++;
		if (this.field[0][1]) sum++;
		if (this.field[1][0]) sum++;
		
		if((sum <= 3 && sum >=2 && this.field[0][0] == true) || (sum == 3 && this.field[0][0] == false))
			tmp_field[0][0] = true;
		else tmp_field[0][0] = false;	
		
		
		sum = 0;							// Corner Top-Right
		
		if(this.field[48][0]) sum++;
		if (this.field[48][1]) sum++;
		if (this.field[49][1]) sum++;
		
		if((sum <= 3 && sum >=2 && this.field[49][0] == true) || (sum == 3 && this.field[49][0] == false))
			tmp_field[49][0] = true;
		else tmp_field[49][0] = false;	

		
		sum = 0;							// Corner Bottom-Right
		
		if(this.field[48][49]) sum++;
		if (this.field[48][48]) sum++;
		if (this.field[49][48]) sum++;
		
		if((sum <= 3 && sum >=2 && this.field[49][49] == true) || (sum == 3 && this.field[49][49] == false))
			tmp_field[49][49] = true;
		else tmp_field[49][49] = false;		
		
		
		sum = 0;							// Corner Bottom-Left
		
		if(this.field[0][48]) sum++;
		if (this.field[1][48]) sum++;
		if (this.field[1][49]) sum++;
		
		if((sum <= 3 && sum >=2 && this.field[0][49] == true) || (sum == 3 && this.field[0][49] == false))
			tmp_field[0][49] = true;
		else tmp_field[0][49] = false;	
		
		
		//------
		
		this.field = this.tmp_field;
		setAmount(calcAmount(this.field)); 
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
