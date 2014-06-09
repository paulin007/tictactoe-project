package tests;

import forza4Gui.Forza4Panel;
import grafica.MainPanel;
import grafica.MenuGui;
import grafica.WelcomePanel;

import javax.swing.JFrame;

import managers.DefaultSettings;
import managers.IMatchManager;
import managers.ITurnManager;
import managers.MatchManager;
import managers.TurnManager;
import rete.Client;
import rete.IClient;
import rete.MessageInterpreter;
import rete.StatisticInterpreter;
import trisGui.TrisPanel;

public class MainApp {

	public static void main(String[] args) {
		
		DefaultSettings.getSettings().loadMap();
		
		IClient client = new Client();
		IMatchManager matchManager = new MatchManager(client, new MessageInterpreter());
		
		ITurnManager turnManager = new TurnManager();
		
		MainPanel mainPanel = new MainPanel(new WelcomePanel());
		mainPanel.getGamesMap().put("tris", new TrisPanel(matchManager, turnManager));
		mainPanel.getGamesMap().put("forza4", new Forza4Panel(matchManager, turnManager));
		
		MenuGui menuGui = new MenuGui(mainPanel, matchManager, turnManager, new StatisticInterpreter(), client);
		
		JFrame frame = new JFrame("Giochi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().add(mainPanel);
		frame.setJMenuBar(menuGui);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
