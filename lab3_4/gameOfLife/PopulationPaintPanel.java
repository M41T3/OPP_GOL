package lab3_4.gameOfLife;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PopulationPaintPanel extends JPanel{
	
	Population population;
	int size = 8;			// Size of Pixel
	
	public PopulationPaintPanel(Population population) {	// Constructor
		this.population = population;
	}

	public Dimension getPreferredSize() {
		return new Dimension(408, 408); 	// Size Population Panel 
	}
	
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		
		// Draw here
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 50; y++) {
				
				if(population.getField()[x][y])
				g.fillRect(x*size, y*size, size, size);
				
				
				
			}
		}
	}
}
