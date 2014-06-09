package trisGui;

import grafica.PanelsDrawer;
import grafica.GamePanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import managers.IMatchManager;
import managers.ITurnManager;
import managers.PlayerSymbol;
/**
 * Responsabilità: crea il pannello del gioco Tris usato nell'applicazione
 */
@SuppressWarnings("serial")
public class TrisPanel extends JPanel implements Observer, GamePanel {
	
	private ArrayList<JButton> boxes = new ArrayList<>();
	private PanelsDrawer drawerPanel;
	private String mySymbol;
	private String opponentSymbol;
	private IMatchManager matchManager;
	
	public TrisPanel(IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		drawerPanel = new PanelsDrawer(matchManager, turnManager);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(matchManager.getInterprete().getMatchStatus().equalsIgnoreCase("InCorso")){
			drawerPanel.paint(null,boxes,mySymbol, opponentSymbol, "tris");
		}else{
			drawerPanel.paint(null,boxes,mySymbol, opponentSymbol, "tris");
			matchManager.endMatch();
		}
	}
	
	@Override
	public JPanel createPanel() {
		initialSetup();
		return this;
	}
	
	/**
	 * Installa i componenti iniziali del pannello di gioco Tris
	 */
	public void initialSetup() {
		removeAll();
		setLayout(null);
		setBackground(new Color(153,203,255));
		drawerPanel.drawPlayersPanel(this, mySymbol, opponentSymbol);
		drawerPanel.drawTrisUI(boxes, 9, this);
		matchManager.addObserver(this);
	}
	
	@Override
	public ArrayList<JButton> getBoxes() {
		return boxes;
	}
	
	@Override
	public void setMySymbol(String mySymbol) {
		this.mySymbol = mySymbol;
		if(mySymbol.equalsIgnoreCase(PlayerSymbol.PLAYER1_SYMBOL.getSymbol())){
			opponentSymbol = PlayerSymbol.PLAYER2_SYMBOL.getSymbol();
		}else{
			opponentSymbol = PlayerSymbol.PLAYER1_SYMBOL.getSymbol();
		}
	}
}
