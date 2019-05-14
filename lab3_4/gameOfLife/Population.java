package lab3_4.gameOfLife;

public class Population {

	private double ratio;
	private boolean[][] field;	// population field: True, False
	
	public Population(double ratio) {
		setRatio(ratio);
		this.field  = generateField(this.ratio);
		
	}
	
	public void setRatio(double ratio) {
		
		if (ratio <= 1 && ratio >= 0)
			this.ratio = ratio;
	}
	
	public void setField(boolean field[][]) {
		
		this.field = field;
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
				 tmp_field[x][y] = (Math.random() < ratio);
			}
		}
		return  tmp_field;
	}	
	
	
	
	public void debug() {
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

	// generate on constructor randomly
	// new population
	// calc next generation
	
}
