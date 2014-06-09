package grafica;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	private String game;
	private HashMap<String, GamePanel> gamesMap = new HashMap<>();
	
	public MainPanel(JPanel panel) {
		setPanel(panel);
	}
	
	public void setPanel(JPanel panel){
		removeAll();
		setLayout(new BorderLayout());
		add(panel);
		updateUI();
	}
	
	public void setGamePanel(String mySymbol){
		gamesMap.get(game).setMySymbol(mySymbol);
		setPanel(gamesMap.get(game).createPanel());
	}
	
	public String getGame() {
		return game;
	}
	
	public void setGame(String game) {
		this.game = game;
	}
	
	public HashMap<String, GamePanel> getGamesMap() {
		return gamesMap;
	}
}
