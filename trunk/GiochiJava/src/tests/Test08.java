package tests;

import grafica.MainPanel;
import grafica.PlayersPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rete.Client;
import rete.MessageInterpreter;
import managers.MatchManager;
import managers.TurnManager;

public class Test08 {

	public static void main(String[] args) {
		
		MainPanel mainPanel = new MainPanel(new JPanel());
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(new PlayersPanel(mainPanel, manager, manager2));
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
	}
}
