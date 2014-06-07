package tests;

import javax.swing.JFrame;

import managers.MatchManager;
import managers.PlayerSymbol;
import managers.TurnManager;
import rete.Client;
import rete.MessageInterpreter;
import forza4Gui.Forza4Panel;
/**
 * Test sulla classe {@link Forza4Panel}
 * @author Dario
 *
 */
public class Test04 {
public static void main(String[] args) {
		
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		Forza4Panel panel2 = new Forza4Panel(manager, manager2);
		panel2.setMySymbol(PlayerSymbol.PLAYER1_SYMBOL.getSymbol());
	
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(panel2.createPanel());
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		
		
	}
}
