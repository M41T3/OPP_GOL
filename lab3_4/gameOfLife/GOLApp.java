package lab3_4.gameOfLife;

import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GOLApp implements ActionListener {
	
	private JButton newButton, nextButton, startButton;
	private PopulationPaintPanel populationPanel;
	
	public Population population;
	public double ratio;
	
		
	public GOLApp(Population population, double ratio) {
		this.population = population; 
		this.ratio = ratio;
		
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(416, 500);
		frame.setResizable(false);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		populationPanel = new PopulationPaintPanel(this.population);
		
		//this.populationGraphics = populationPanel.getGraphics();	// ???
		
		contentPane.add(populationPanel);
		
		Container buttonContainer = new Container(); // Container oder JPanel?
		buttonContainer.setLayout(new BoxLayout(buttonContainer,BoxLayout.X_AXIS));
		
		//buttonContainer.setSize(400, 40);//?
		
		newButton = new JButton("Neue Population");
		nextButton = new JButton("Nächste Generation");
		startButton = new JButton("Start");
		
		newButton.addActionListener(this);
		nextButton.addActionListener(this);
		startButton.addActionListener(this);
		
		buttonContainer.add(newButton);
		buttonContainer.add(nextButton);
		buttonContainer.add(startButton);
		
		contentPane.add(buttonContainer);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == startButton) {
			
			//while(true) {
				// fkt(matrix) -> return new matrix
				// delay(1s)
			//}
			
		}else if (event.getSource() == newButton) {
			this.population.setField(Population.generateField(ratio));
			populationPanel.repaint();
		
		}else if (event.getSource() == nextButton) {
				// fkt(matrix) -> return new matrix
		}
	}
	
	
	
	public static void main(String[] args) {
		double ratio = 0.5;
		
		Population population = new Population(ratio);
		population.debug();
		
		new GOLApp(population, ratio);	// Do Frame
		
		
	}

	

}
