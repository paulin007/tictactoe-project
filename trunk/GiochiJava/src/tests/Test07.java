package tests;

import java.util.Timer;
import java.util.TimerTask;
import forza4Gui.Forza4Panel;
import grafica.MainPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import managers.MatchManager;
import managers.PlayerSymbol;
import managers.TurnManager;
import rete.Client;
import rete.MessageInterpreter;
import trisGui.TrisPanel;
/**
 * Test sulla classe {@link MainPanel}
 * @author Dario
 *
 */
public class Test07 {

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		
		final MainPanel mainPanel = new MainPanel(panel);
		MatchManager manager = new MatchManager(new Client(), new MessageInterpreter());
		TurnManager manager2 = new TurnManager();
		
		mainPanel.addGames(new TrisPanel(manager, manager2));
		mainPanel.addGames(new Forza4Panel(manager, manager2));
		mainPanel.setGame("forza4");
		mainPanel.setGames();
		mainPanel.setGamePanel(PlayerSymbol.PLAYER1_SYMBOL.getSymbol());
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				mainPanel.setGame("tris");
				mainPanel.setGamePanel(PlayerSymbol.PLAYER1_SYMBOL.getSymbol());
				System.out.println("fatto");
			}
		};
		timer.schedule(task, 5000);
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
	}
}
