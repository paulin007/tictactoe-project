package grafica;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	
	private String game;
	private ArrayList<GamePanel> panelsGames = new ArrayList<>();
	private GamePanel trisPanel;
	private GamePanel forza4Panel;
	
	public MainPanel(JPanel panel) {
		setPanel(panel);
	}
	
	public void setPanel(JPanel panel){
		removeAll();
		setLayout(new BorderLayout());
		add(panel);
		updateUI();
	}
	
	public void addGames(GamePanel gamePanel){
		panelsGames.add(gamePanel);
	}
	
	public void setGames(){
		trisPanel = panelsGames.get(0);
		forza4Panel = panelsGames.get(1);
	}
	
	public void setGamePanel(String mySymbol){
		if(game.equalsIgnoreCase("tris")){
			trisPanel.setMySymbol(mySymbol);
			setPanel(trisPanel.createPanel());
		}
		if(game.equalsIgnoreCase("forza4")){
			forza4Panel.setMySymbol(mySymbol);
			setPanel(forza4Panel.createPanel());
		}
	}
	
	public String getGame() {
		return game;
	}
	
	public void setGame(String game) {
		this.game = game;
	}
}
