package utils.componenti;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import newGui.Cerchio;
import newGui.Croce;
import tris.Casella;
import tris.TabellaTris;
import vincita.GestoreVincite;
import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.ProxyDifficoltà;

public class JButtonPanel extends JPanel{

	private static final long serialVersionUID = 0;
	private CheckBoxPanel panel;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();
	private TabellaTris tabellaTris = new TabellaTris();
	private GestoreVincite gestoreVincite;

	public JButtonPanel(CheckBoxPanel panel) {
		tabellaTris.creaTabella();
		this.panel=panel;
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
		gestoreVincite = new GestoreVincite(tabellaTris.getCaselle());
	}
	// intelligenza artificiale stupida
	
	public void ia(String scelta){
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàCasuale());
		int index = proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
		
		if(scelta=="Cerchio" && griglia.get(index).getIcon()==null){
			griglia.get(index).setIcon(croce.disegnaCroce());
			
		}
		if(scelta=="Croce" && griglia.get(index).getIcon()==null){
			griglia.get(proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris)).setIcon(cerchio.disegnaCerchio());
			
		}
	}
	
	public void setupInizialeGriglia(){
		for (int i = 0; i < 9; i++) {
			
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
				if(panel.scelta()=="Cerchio"&&casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
					griglia.get(j).setIcon(cerchio.disegnaCerchio());
					casellaSelezionata.setSimbolo("g");
					
					ia(panel.scelta());
				}
				if(panel.scelta()=="Croce"&&casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
					griglia.get(j).setIcon(croce.disegnaCroce());
					casellaSelezionata.setSimbolo("g");
					ia(panel.scelta());
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
	public TabellaTris getTabellaTris() {
		return tabellaTris;
	}
	public void setTabellaTris(TabellaTris tabellaTris) {
		this.tabellaTris = tabellaTris;
	}
		
	public ArrayList<JButton> getGriglia() {
		return griglia;
	}

	public void setGriglia(ArrayList<JButton> griglia) {
		this.griglia = griglia;
	}
}
