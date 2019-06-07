package lab3_4.gameOfLife;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GOLApp implements ActionListener {
	
	private JButton newButton, nextButton, startButton;
	private PopulationPaintPanel populationPanel;
	private PopulationTextPanel textPanel;
	private PopulationHistPanel histPanel;
	
	public Population population;
	public double ratio;
	
		
	public GOLApp(Population population, double ratio) {	// Constructor
		this.population = population; 
		this.ratio = ratio;
		
		JFrame frame = new JFrame("Game of Life");			// Create frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(408, 570);
		frame.setResizable(false);
		
		Container contentPane = frame.getContentPane();		// Create contentpane to put stuff in there
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		populationPanel = new PopulationPaintPanel(this.population);	// Add PopulationPanel to contentpane
		contentPane.add(populationPanel);
		
		Container buttonContainer = new Container(); // Container or JPanel?	// Add Container woth buttons to contentpane
		buttonContainer.setLayout(new BoxLayout(buttonContainer,BoxLayout.X_AXIS));
		
		newButton = new JButton  ("   Neue Population   ");
		nextButton = new JButton ("  Naechste Generation ");
		startButton = new JButton("        Start        ");
	
		newButton.addActionListener(this);
		nextButton.addActionListener(this);
		startButton.addActionListener(this);
		
		buttonContainer.add(newButton);
		buttonContainer.add(nextButton);
		buttonContainer.add(startButton);
		
		contentPane.add(buttonContainer);
		
		textPanel = new PopulationTextPanel(this.population);	// Add textPanel to contentpane
		contentPane.add(textPanel);
		
		histPanel = new PopulationHistPanel(this.population);	// Add HistPanel to contentpane
		contentPane.add(histPanel);
		
		//frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public synchronized void actionPerformed(ActionEvent event) {		// Events if button is pressed
		if (event.getSource() == startButton) {
			
			//System.out.println(population.getGeneration()); //[DEBUG]
			
			while(population.getGeneration() < 399) {	//[TODO] Es liegt an der Schleife!!!!
			//for(int i = 0; i < 10; i++) {
				NextGenThread thread = new NextGenThread(population, textPanel, populationPanel, histPanel);
				
				thread.start();
				System.out.println("NextGen:");
				
				population.nextGeneration();
				try {
					System.out.println("wait for join:");
					thread.join();
					System.out.println("joined.");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				populationPanel.repaint();
				textPanel.repaint();
				histPanel.repaint();
				
				
			}	
				
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
		double ratio = 0.1;	// Set probability
		
		Population population = new Population(ratio); // Generate new Population instance
		// population.debug(); //[DEBUG]
		
		new GOLApp(population, ratio);	// Do Frame and start App
		
		
	}

	

}
