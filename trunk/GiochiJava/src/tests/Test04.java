package tests;

import javax.swing.JFrame;

import managers.MatchManager;
import managers.TurnManager;
import rete.Client;
import rete.MessageInterpreter;
import forza4Gui.Forza4Panel;

public class Test04 {
public static void main(String[] args) {
		
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		Forza4Panel panel2 = new Forza4Panel(manager, manager2);
		panel2.setMySymbol("G1");
	
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(panel2.createPanel());
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(3);
		frame.setLocation(100, 100);
		
		
	}
}
