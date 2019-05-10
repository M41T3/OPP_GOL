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
	private PopulationPaintPanel population;
	
	public GOLApp() {
		JFrame frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		population = new PopulationPaintPanel();
		contentPane.add(population);
		
		Container buttonContainer = new Container(); // Container oder JPanel?
		buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.X_AXIS));
		
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
			population.setBackground(Color.RED);
		}else if (event.getSource() == newButton) {
			population.setBackground(Color.GREEN);
		}else if (event.getSource() == nextButton) {
			population.setBackground(Color.BLUE);
		}
	}
	
	public static void main(String[] args) {
		new GOLApp();

	}

	

}
