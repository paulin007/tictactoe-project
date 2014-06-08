package tests;

import grafica.StatisticPanel;
import javax.swing.JFrame;
import rete.Client;
import rete.StatisticInterpreter;

public class Test11 {

	public static void main(String[] args) {
		
		StatisticPanel panel = new StatisticPanel(new StatisticInterpreter(), new Client());
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
	}
}
