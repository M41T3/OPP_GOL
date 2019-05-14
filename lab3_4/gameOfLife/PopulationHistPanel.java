package lab3_4.gameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PopulationHistPanel extends JPanel{

	Population population;
	
	public PopulationHistPanel(Population population) {
		this.population = population;
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 60); 	// Size Population Panel 
	}
	
	public void paintComponent(Graphics g) {	//, Population population
		super.paintComponent(g);
		
		//g.setColor(Color.RED);
		
		for(int a = 0; a < 400; a++) {
			
			g.setColor(Color.RED);
			
			if(a == population.getGeneration()) {
				
				System.out.println("a = " + a + " gen = " + population.getGeneration());
				
				g.setColor(Color.BLUE);
				
				g.drawLine(a, 60, a,60 - (int)(this.population.getAmountHist()[a]/18));		// thick stroke
				g.drawLine(a+1, 60, a+1,60 - (int)(this.population.getAmountHist()[a]/18));
			}
			
			g.drawLine(a, 60, a,60 - (int)(this.population.getAmountHist()[a]/18));	// Show Hist
		}
	}	
}

