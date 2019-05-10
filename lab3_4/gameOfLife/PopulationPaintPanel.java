package lab3_4.gameOfLife;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PopulationPaintPanel extends JPanel{

	
	public Dimension getPreferredSize() {
		return new Dimension(300, 300); 	// Size Population Panel 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw
		
		g.drawString("Population Panel", 100, 100);
	
		
	}
	
}
