package tests;

import forza4Gui.Forza4Panel;
import grafica.GamePanel;
import grafica.MainPanel;
import grafica.MenuGui;
import grafica.WelcomePanel;

import javax.swing.JFrame;

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
		
		IClient client = new Client();
		IMatchManager matchManager = new MatchManager(client, new MessageInterpreter());
		
		ITurnManager turnManager = new TurnManager();
		
		TrisPanel tris = new TrisPanel(matchManager, turnManager);
		GamePanel forza4 = new Forza4Panel(matchManager, turnManager);
		
		MainPanel mainPanel = new MainPanel(new WelcomePanel());
		mainPanel.addGames(tris);
		mainPanel.addGames(forza4);
		mainPanel.setGames();
		
		MenuGui menuGui = new MenuGui(mainPanel, matchManager, turnManager, new StatisticInterpreter(), client);
		
		JFrame frame = new JFrame("Giochi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,550);
		frame.getContentPane().add(mainPanel);
		frame.setJMenuBar(menuGui);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
