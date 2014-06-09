package tests;

import forza4Gui.Forza4Panel;
import grafica.MainPanel;

import java.util.Timer;
import java.util.TimerTask;

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
		
		mainPanel.setGame("forza4");
		
		mainPanel.getGamesMap().put("tris", new TrisPanel(manager, manager2));
		mainPanel.getGamesMap().put("forza4", new Forza4Panel(manager, manager2));
		
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
