package lab3_4.gameOfLife;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PopulationTextPanel extends JPanel{

	Population population;
	
	public PopulationTextPanel(Population population) {
		this.population = population;
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 40); 	// Size Population Panel 
	}
	
	public void paintComponent(Graphics g) {	//, Population population
		super.paintComponent(g);

		g.drawString("Generation: " + population.getGeneration(), 5, 20);	
		g.drawString("Population: " + population.getAmount(), 5, 35);	
			
	}
	
}

