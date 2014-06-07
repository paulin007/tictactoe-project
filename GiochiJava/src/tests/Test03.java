package tests;

import javax.swing.JFrame;

import managers.MatchManager;
import managers.TurnManager;
import rete.Client;
import rete.MessageInterpreter;
import trisGui.TrisPanel;

public class Test03 {

	public static void main(String[] args) {
		
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		
		
		TrisPanel panel2 = new TrisPanel(manager, manager2);
		panel2.setMySymbol("G1");
		
		JFrame frame = new JFrame("Test 03");
		
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(3);
		
		frame.getContentPane().add(panel2.createPanel());
		frame.setLocationRelativeTo(null);
	}
}
