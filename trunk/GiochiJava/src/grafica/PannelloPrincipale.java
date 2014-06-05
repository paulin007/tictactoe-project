package grafica;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PannelloPrincipale extends JPanel {
	
	private String gioco;
	private ArrayList<PannelloGioco> pannelliGiochi = new ArrayList<>();
	private PannelloGioco pannelloTris;
	private PannelloGioco pannelloForza4;
	
	public PannelloPrincipale(JPanel panel) {
		setPannello(panel);
	}
	
	public void setPannello(JPanel panel){
		removeAll();
		setLayout(new BorderLayout());
		add(panel);
		updateUI();
	}
	
	public void addGames(PannelloGioco pannelloGioco){
		pannelliGiochi.add(pannelloGioco);
	}
	
	public void setGames(){
		pannelloTris = pannelliGiochi.get(0);
//		pannelloForza4 = pannelliGiochi.get(1);
	}
	
	public void setPannelloGioco(String mioSimbolo){
		if(gioco.equalsIgnoreCase("tris")){
			pannelloTris.setMioSimbolo(mioSimbolo);
			setPannello(pannelloTris.creaPannello());
		}
		if(gioco.equalsIgnoreCase("forza4")){
			pannelloForza4.setMioSimbolo(mioSimbolo);
			setPannello(pannelloForza4.creaPannello());
		}
	}
	
	public String getGioco() {
		return gioco;
	}
	
	public void setGioco(String gioco) {
		this.gioco = gioco;
	}
}
