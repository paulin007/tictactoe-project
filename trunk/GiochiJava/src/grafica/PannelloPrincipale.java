package grafica;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import trisGui.SituazioneTurno;

@SuppressWarnings("serial")
public class PannelloPrincipale extends JPanel {
	
	private String gioco;
	private ArrayList<PannelloGioco> pannelliGiochi;
	private PannelloGioco pannelloTris;
	private PannelloGioco pannelloForza4;
	
	public void setPannelliGiochi(ArrayList<PannelloGioco> pannelliGiochi) {
		this.pannelliGiochi = pannelliGiochi;
			pannelloTris = pannelliGiochi.get(0);		//TODO eventuale problema di assegnazione! dovrebbe essere pannelliGiochi.get(0) = pannelloTris;
			pannelloForza4 = pannelliGiochi.get(1);
	}
	
	
	public PannelloPrincipale(JPanel panel) {
		setPannello(panel);
	}
	
	
	public void setPannello(JPanel panel){
		removeAll();
		setLayout(new BorderLayout());
		add(panel);
		updateUI();
	}
	
	public void setPannelloGioco(SituazioneTurno turno){
		if(gioco.equalsIgnoreCase("tris")){
			pannelloTris.setTurno(turno);
			setPannello(pannelloTris.creaPannello());
		}
		if(gioco.equalsIgnoreCase("forza4")){
			pannelloForza4.setTurno(turno);
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
