package tests;

import grafica.MenuGui;
import grafica.PannelloDiBenvenuto;
import grafica.PannelloPrincipale;

import javax.swing.JFrame;

import managers.IMatchManager;
import managers.ITurnManager;
import managers.MatchManager;
import managers.TurnManager;
import rete.Client;
import rete.InterpreteMessaggio;
import trisGui.PannelloGiocoTris;

public class MainApp {

	public static void main(String[] args) {
		
		IMatchManager matchManager = new MatchManager(new Client(), new InterpreteMessaggio());
		
		ITurnManager turnManager = new TurnManager();
		
		PannelloGiocoTris tris = new PannelloGiocoTris(matchManager, turnManager);		
		
		PannelloPrincipale principale = new PannelloPrincipale(new PannelloDiBenvenuto());
		principale.addGames(tris);
		principale.setGames();
		
		MenuGui menuGui = new MenuGui(principale, matchManager, turnManager);
		
		JFrame frame = new JFrame("Giochi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,550);
		frame.getContentPane().add(principale);
		frame.setJMenuBar(menuGui);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
