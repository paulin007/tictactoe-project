package trisGui;

import grafica.DisegnaPannello;
import grafica.PannelloGioco;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import managers.IMatchManager;
import managers.ITurnManager;

@SuppressWarnings("serial")
public class PannelloGiocoTris extends JPanel implements Observer, PannelloGioco {
	
	private static final String PLAYER1_SYMBOL = "G1";
	private static final String PLAYER2_SYMBOL = "G2";
	private ArrayList<JButton> caselle = new ArrayList<>();
	private DisegnaPannello disegnaPannello;
	private String mioSimbolo;
	private String simboloAvversario;
	private IMatchManager matchManager;
	
	public PannelloGiocoTris(IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		disegnaPannello = new DisegnaPannello(matchManager, turnManager);
		matchManager.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(matchManager.getInterprete().getStatoPartita().equalsIgnoreCase("InCorso")){
			disegnaPannello.paint(caselle,mioSimbolo, simboloAvversario);
		}else{
			disegnaPannello.paint(caselle,mioSimbolo, simboloAvversario);
			matchManager.endMatch();
		}
	}
	
	@Override
	public JPanel creaPannello() {
		setupInziale();
		return this;
	}
	
	public void setupInziale() {
		removeAll();
		setLayout(null);
		setBackground(new Color(153,203,255));
		disegnaPannello.disegnaPannelloGiocatori(this, mioSimbolo, simboloAvversario);
		disegnaPannello.createGraphic(caselle, 9, this);
	}
	
	@Override
	public ArrayList<JButton> getCaselle() {
		return caselle;
	}
	
	@Override
	public void setMioSimbolo(String mioSimbolo) {
		this.mioSimbolo = mioSimbolo;
		if(mioSimbolo.equalsIgnoreCase(PLAYER1_SYMBOL)){
			simboloAvversario = PLAYER2_SYMBOL;
		}else{
			simboloAvversario = PLAYER1_SYMBOL;
		}
	}
}
