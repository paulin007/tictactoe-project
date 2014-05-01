package utils.componenti;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.ProxyDifficoltà;
import tris.Casella;
import tris.TabellaTris;

public class JButtonPanel extends JPanel{

	private CheckBoxPanel panel;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();
	private TabellaTris tabellaTris = new TabellaTris();

	public JButtonPanel(CheckBoxPanel panel) {
		tabellaTris.creaTabella();
		this.panel=panel;
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
	}
	// intelligenza artificiale stupida
	
	public void ia(int posizione,String scelta){
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàCasuale());
		int index = proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
		if(scelta=="Cerchio"){
			griglia.get(index).setIcon(croce.disegnaCroce());
			//tabellaTris.getCaselle().get(index).setSimbolo("c");
		}else{
			griglia.get(proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris)).setIcon(cerchio.disegnaCerchio());
			//tabellaTris.getCaselle().get(index).setSimbolo("c");
		}
	}
	
	public void setupInizialeGriglia(){
		for (int i = 0; i < 9; i++) {
			final int j = i;
			final JButton button = new JButton();
			button.setBackground(Color.WHITE);
			griglia.add(button);
		}
	}
	public void setupActionListenerGriglia(){
		
		
		for (int i = 0; i < griglia.size(); i++) {
		
		final int j = i;
		griglia.get(i).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Casella casellaSelezionata = tabellaTris.getCaselle().get(j);
				if(panel.scelta()=="Cerchio"&&casellaSelezionata.isVuota()){
					griglia.get(j).setIcon(cerchio.disegnaCerchio());
					casellaSelezionata.setSimbolo("g");
					ia(j,panel.scelta());
				}
				if(panel.scelta()=="Croce"&&casellaSelezionata.isVuota()){
					griglia.get(j).setIcon(croce.disegnaCroce());
					casellaSelezionata.setSimbolo("g");
					ia(j,panel.scelta());
				}
			}
		});
		}
	}
	
	
	public void setupPanel(){
		
		for (int i = 0; i < griglia.size(); i++) {
				add(griglia.get(i));
		}
	}
		
	public ArrayList<JButton> getGriglia() {
		return griglia;
	}

	public void setGriglia(ArrayList<JButton> griglia) {
		this.griglia = griglia;
	}
}
