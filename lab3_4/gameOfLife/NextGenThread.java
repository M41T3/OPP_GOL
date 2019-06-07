package lab3_4.gameOfLife;

public class NextGenThread extends Thread{

	//public Population population;
	//private PopulationPaintPanel populationPanel;
	//private PopulationTextPanel textPanel;
	//private PopulationHistPanel histPanel;
	private Population population;
	
	
	public NextGenThread(Population population, PopulationTextPanel textPanel, PopulationPaintPanel populationPanel, PopulationHistPanel histPanel) {
		
		this.population = population;
		//this.populationPanel = populationPanel;
		//this.textPanel = textPanel;
		//this.histPanel = histPanel;
	}
	
	public void run() {
		
		try {
			System.out.println("sleep");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Exception in NextGen!!:");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println(" population gen: " + population.getGeneration());
	
		
	}
	
	
}
