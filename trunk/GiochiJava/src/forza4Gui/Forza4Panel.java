package forza4Gui;

import grafica.GamePanel;
import grafica.PanelsDrawer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import managers.IMatchManager;
import managers.ITurnManager;
import managers.DefaultSettings;
import managers.PlayerSymbol;

@SuppressWarnings("serial")
public class Forza4Panel extends JPanel implements Observer, GamePanel {

	private String mySymbol;
	private String opponentSymbol;
	private PanelsDrawer drawerPanel;
	private JPanel gridPanel = new JPanel();
	private ArrayList<Forza4Button> forza4Buttons = new ArrayList<>();
	private IMatchManager matchManager;
	
	public Forza4Panel(IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		drawerPanel = new PanelsDrawer(matchManager, turnManager);
		drawerPanel.createForza4Button(forza4Buttons,7);
	}

	public void setupInziale(){
		removeAll();
		setLayout(null);
		drawerPanel.drawPlayersPanel(this, mySymbol, opponentSymbol);
		drawerPanel.setPositionForza4Button(forza4Buttons);
		drawerPanel.setupForza4Button(this, forza4Buttons);
		drawerPanel.setupForza4Grid(this);
		add(gridPanel);
		matchManager.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(matchManager.getInterprete().getMatchStatus().equalsIgnoreCase("InCorso")){
			drawerPanel.paint(this, new ArrayList<JButton>(),mySymbol, opponentSymbol, "forza4");
		}else{
			drawerPanel.paint(this, new ArrayList<JButton>(),mySymbol, opponentSymbol, "forza4");
			matchManager.endMatch();
		}
	}
		
	@Override
	public JPanel createPanel() {
		setupInziale();
		return this;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			java.net.URL imgUrl = getClass().getResource(DefaultSettings.getSettings().getPath("sfondo2"));
			BufferedImage image = ImageIO.read(imgUrl);
			g.drawImage(image,0,0,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
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
	
	@Override
	public ArrayList<JButton> getBoxes() {
		ArrayList<JButton> buttons = new ArrayList<>();
		for (int i = 0; i < forza4Buttons.size(); i++) {
			buttons.add(forza4Buttons.get(i).convertToJButton());
		}
		return buttons;
	}
}
