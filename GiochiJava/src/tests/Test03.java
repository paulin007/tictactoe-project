package tests;

import javax.swing.JFrame;

import managers.MatchManager;
import managers.PlayerSymbol;
import managers.TurnManager;
import rete.Client;
import rete.MessageInterpreter;
import trisGui.TrisPanel;
/**
 * Test sulla classe {@link TrisPanel}
 * @author Dario
 *
 */
public class Test03 {

	public static void main(String[] args) {
		
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		
		
		TrisPanel panel2 = new TrisPanel(manager, manager2);
		panel2.setMySymbol(PlayerSymbol.PLAYER1_SYMBOL.getSymbol());
		
		JFrame frame = new JFrame("Test 03");
		
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel2.createPanel());
		frame.setLocationRelativeTo(null);
	}
}
