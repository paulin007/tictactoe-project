package grafica;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import managers.DefaultSettings;
import managers.IMatchManager;
import managers.ITurnManager;
import trisGui.Circle;
import trisGui.Cross;
import trisGui.Icon;
import forza4Gui.Forza4Button;
import forza4Gui.SymbolPosition;

/**
 * Questa classe astrae sul concetto di pannello da disegnare e contiene metodi utili per 
 * disegnare elementi grafici, all'interno di {@link JPanel}
 * @author Giacomo
 *
 */
public class PanelsDrawer {
	
	private PlayersLabel player1;
	private PlayersLabel player2;
	private ChallengeLabel VS = new ChallengeLabel("VS");
	private IMatchManager matchManager;
	private ITurnManager turnManager;
	private ResultViewer resultViewer = new ResultViewer();
	private Circle circle = new Circle();
	private Cross cross = new Cross();
	
	public PanelsDrawer(IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		this.turnManager = turnManager;
	}

	public void drawTrisUI(ArrayList<JButton> boxes, int numeroCaselle, JPanel gamePanel){
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 400, 400);
		panel.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < numeroCaselle; i++) {
			JButton button = new JButton();
			button.setBackground(Color.WHITE);
			boxes.add(button);
			panel.add(button);
			boxes.get(i).addActionListener(new ButtonListener(i, matchManager, (GamePanel)gamePanel, turnManager));
		}
		gamePanel.add(panel);
	}
	
	
	public void createForza4Button(ArrayList<Forza4Button> forza4Button,int n){
		for (int i = 0; i < n; i++) {
			forza4Button.add(new Forza4Button());
		}
	}
	/**
	 * Questo metodo imposta i pulsanti all'interno del Pannello di gioco Forza4
	 * 
	 * @param forza4Button
	 */
	public void setPositionForza4Button(ArrayList<Forza4Button> forza4Button){
		for (int i = 0; i < forza4Button.size(); i++) {
			forza4Button.get(i).setBounds((SymbolPosition.FIRST_COLUMN+SymbolPosition.VERTICAL_SPACE*i),95,42,38);
		}
	}
	/**
	 * Aggiungi i pulsanti al pannello
	 * 
	 * @param panel
	 * @param forza4Button
	 */
	public void setupForza4Button(JPanel panel, ArrayList<Forza4Button> forza4Button){
		for (int i = 0; i < forza4Button.size(); i++) {
			panel.add(forza4Button.get(i));
			forza4Button.get(i).setEnabled(true);
			forza4Button.get(i).addActionListener(new ButtonListener(i, matchManager, (GamePanel)panel , turnManager));
		}
	}
	
	/**
	 * Questo metodo imposta i pulsanti all'interno del Pannello di gioco Tris
	 * 
	 * @param panel
	 * @param boxes
	 * @param mySymbol
	 * @param opponentSymbol
	 * @param gameName
	 */
	public void paint(JPanel panel, ArrayList<JButton> boxes, String mySymbol, String opponentSymbol, String gameName){

		ArrayList<String> listaCaselle = matchManager.getInterprete().getBoxes();

		for (int i = 0; i < listaCaselle.size(); i++) {
			boolean myDrawable = listaCaselle.get(i).equalsIgnoreCase(mySymbol);
			boolean opponentDrawable = listaCaselle.get(i).equalsIgnoreCase(opponentSymbol);
			
			if(gameName.equalsIgnoreCase("tris")){
				drawTrisIcon(boxes.get(i), circle.clone(), myDrawable);
				drawTrisIcon(boxes.get(i), cross.clone(), opponentDrawable);
			} else if(gameName.equalsIgnoreCase("forza4")){
				drawForza4Icon(panel, i, gameName, "gialla", myDrawable);
				drawForza4Icon(panel, i, gameName, "rossa", opponentDrawable);
			}
		}
		setPlayersTurn(mySymbol);
		showPlayerTurn(!matchManager.getInterprete().getLastPlayer().equalsIgnoreCase(mySymbol));
		resultViewer.showResult(matchManager.getInterprete().getMatchStatus(), mySymbol);
	}
	
	private void drawTrisIcon(JButton button, Icon icon, boolean drawable){
		if(drawable){
			button.setIcon(icon.getDrawer().getIcon());
		}
	}
	
	private void drawForza4Icon(JPanel panel, int location, String gameName, String color, boolean drawable){
		if(drawable && gameName.equalsIgnoreCase("forza4")){
			drawForza4UI(panel, location, color);
		}
	}

	private void setPlayersTurn(String mySymbol) {
		if(matchManager.getInterprete().getLastPlayer().equalsIgnoreCase(mySymbol)){
			turnManager.setMyTurn(false);
		}else{
			turnManager.setMyTurn(true);
		}
	}

	/**
	 * Aggiunge i vari labelli di intestazione del gioco al pannello
	 * 
	 * @param panel
	 * @param mySymbol
	 * @param opponentSymbol
	 */
	public void drawPlayersPanel(JPanel panel, String mySymbol, String opponentSymbol){
		player1 = new PlayersLabel(mySymbol, new Color(196,44,0));
		player2 = new PlayersLabel(opponentSymbol, new Color(220,213,11));
		player1.setBounds(10, 11, 231, 87);
		panel.add(player1);
		player2.setBounds(371, 11, 220, 87);
		panel.add(player2);
		VS.setBounds(251, 11, 79, 87);
		panel.add(VS);
	}

	/**
	 * Questo metodo permette di stabilire a chi tocca giocare
	 * @param sommaCaselle
	 * @return
	 */
	private void showPlayerTurn(boolean turn){
		if(turn){
			player1.setColor(Color.GREEN);
			player2.setColor(Color.RED);
		}else{
			player1.setColor(Color.RED);
			player2.setColor(Color.GREEN);
		}
	}
	/**
	 * Imposta il pannello di gioco di Forza4
	 * @param panel
	 */
	public void setupForza4Grid(JPanel panel){
		JLabel grid = new JLabel();
		java.net.URL imgUrl2 = getClass().getResource(DefaultSettings.getSettings().getPath("griglia"));
		ImageIcon icon = new ImageIcon(imgUrl2);
		grid.setIcon(icon);
		grid.setBounds(123, 144, 428, 366);
		panel.add(grid);
		java.net.URL imgUrl = getClass().getResource(DefaultSettings.getSettings().getPath("forza4verticale"));
		ImageIcon icon2 = new ImageIcon(imgUrl);
		JLabel verticalLogo = new JLabel(icon2);
		verticalLogo.setBounds(10, 144, 103, 357);
		panel.add(verticalLogo);
	}
	
	
	//Serve per disegnare una casella all'interno del pannello
	private void drawForza4UI(JPanel panel, int box, String color){
			try {
				java.net.URL imgUrl1 = null;
				if(color.equalsIgnoreCase("gialla")){
				imgUrl1 = getClass().getResource(DefaultSettings.getSettings().getPath("pallaGialla"));
				}
				if(color.equalsIgnoreCase("rossa")){
				imgUrl1 = getClass().getResource(DefaultSettings.getSettings().getPath("pallaRossa"));
				}
				BufferedImage image= ImageIO.read(imgUrl1);
				panel.getGraphics().drawImage(image,SymbolPosition.boxToX(box),SymbolPosition.boxToY(box),null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
	
}
