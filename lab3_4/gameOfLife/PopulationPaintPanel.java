package lab3_4.gameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PopulationPaintPanel extends JPanel{
	
	Population population;
	int size = 8;
	
	public PopulationPaintPanel(Population population) {
		this.population = population;
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 400); 	// Size Population Panel 
	}
	
	public void paintComponent(Graphics g) {	//, Population population
		super.paintComponent(g);
		
		
		// Scheiss drauf! Alles hier rein! -.-
		
		
		for(int x = 0; x < 50; x++) {
			for(int y = 0; y < 50; y++) {
				
				if(population.getField()[x][y])
				g.fillRect(x*size, y*size, size, size);
				
	
				
			}
			
		}
		
	}
	
	
}
