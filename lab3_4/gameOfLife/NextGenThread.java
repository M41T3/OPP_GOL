package lab3_4.gameOfLife;

public class NextGenThread extends Thread{


	private PopulationPaintPanel populationPanel;
	private PopulationTextPanel textPanel;
	private PopulationHistPanel histPanel;
	private Population population;
	
	
	public NextGenThread(Population population, PopulationTextPanel textPanel, PopulationPaintPanel populationPanel, PopulationHistPanel histPanel){
		this.population = population;
		this.textPanel = textPanel;
		this.histPanel = histPanel;
		this.populationPanel = populationPanel;

	}
	
	public void run() {
		
		while(population.getGeneration() < 399){
			population.nextGeneration();
			System.out.println("@GOLApp: Generation: " + population.getGeneration());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//textPanel.validate();
			textPanel.repaint();
			histPanel.repaint();
			populationPanel.repaint();
			//textPanel.revalidate();
			System.out.println("nach repaint.");
		}	
	
		
	}
	
	
}
