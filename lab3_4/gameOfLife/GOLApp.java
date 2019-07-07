package lab3_4.gameOfLife;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GOLApp implements ActionListener {
	
	private JButton newButton, nextButton, startButton;
	private PopulationPaintPanel populationPanel;
	private PopulationTextPanel textPanel;
	private PopulationHistPanel histPanel;
	
	public Population population;
	double ratio = 0.2;	// Set probability
	
	Container contentPane;
		
	public GOLApp() {	// Constructor
		population = new Population(ratio); // Generate new Population instance
		
		JFrame frame = new JFrame("Game of Life");			// Create frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(408, 570);
		frame.setResizable(false);
		
		contentPane = frame.getContentPane();		// Create contentpane to put stuff in there
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		populationPanel = new PopulationPaintPanel(population);	// Add PopulationPanel to contentpane
		contentPane.add(populationPanel);
		
		newButton = new JButton  ("   Neue Population   ");
		nextButton = new JButton ("  Naechste Generation ");
		startButton = new JButton("        Start        ");
		newButton.addActionListener(this);
		nextButton.addActionListener(this);
		startButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(); // Container or JPanel?	// Add Container woth buttons to contentpane
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(newButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(startButton);
		contentPane.add(buttonPanel);
		
		textPanel = new PopulationTextPanel(population);	// Add textPanel to contentpane
		contentPane.add(textPanel);
	
		histPanel = new PopulationHistPanel(this.population);	// Add HistPanel to contentpane
		contentPane.add(histPanel);
		
		//frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {		// Events if button is pressed
		if (event.getSource() == startButton) {
			NextGenThread thread = new NextGenThread(population, textPanel, populationPanel, histPanel);
			thread.start();
			
			
		}else if (event.getSource() == newButton) {

			this.population.setGeneration(0);
			this.population.resetAmountHist();
			this.population.setField(Population.generateField(ratio));
			populationPanel.repaint();
			textPanel.repaint();
			histPanel.repaint();
		
		}else if (event.getSource() == nextButton) {
			
			if(this.population.getGeneration() == 399) {
				this.population.setGeneration(0);
				this.population.resetAmountHist();
			}
			
			population.nextGeneration();
			populationPanel.repaint();
			textPanel.repaint();
			histPanel.repaint();
		}
	}
	
	
	public static void main(String[] args) {	// ################# MAIN ###############
		new GOLApp();	// Do Frame and start App
	}
}
