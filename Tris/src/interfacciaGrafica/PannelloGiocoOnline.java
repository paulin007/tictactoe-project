/**
 * Questa classe ha la responsabilità di gestire il pannello di gioco
 * @author Giacomo
 */
package interfacciaGrafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import tris.Casella;
import tris.TabellaTris;

public class PannelloGiocoOnline extends JPanel implements PannelloTris, Observer {
	
	private TabellaTris tabellaTris;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();
	private String scelta;
	private boolean partitaFinita;
	
	public PannelloGiocoOnline(TabellaTris tabellaTris,String scelta) {
		super();
		this.tabellaTris = tabellaTris;
		this.scelta = scelta;
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			tabellaTris.getCaselle().get(i).addObserver(this);
		}
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
	}

	@Override
	public JPanel creaPannello() {
		//tabellaTris = new TabellaTris();
		//tabellaTris.creaTabella();
		
		creaGrafica(tabellaTris);
		return this;
	}
	
	
	public void setupInizialeGriglia(){
			for (int i = 0; i < 9; i++) {
				final JButton button = new JButton();
				button.setBackground(Color.WHITE);
				griglia.add(button);
			}
		}
		
		public void creaGrafica(TabellaTris tabellaTris){
			
			for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
				if(tabellaTris.getCaselle().get(i).occupataDaComputer()){
					griglia.get(i).setIcon(cerchio.disegnaCerchio());
					
				}
			}
		}
		public void setupActionListenerGriglia(){
			
			for (int i = 0; i < griglia.size(); i++) {
			
			final int j = i;
			griglia.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Casella casellaSelezionata = tabellaTris.getCaselle().get(j);
					if(scelta.equalsIgnoreCase("cerchio")&&casellaSelezionata.isVuota()){
						if(!partitaFinita){
						griglia.get(j).setIcon(cerchio.disegnaCerchio());
						
						casellaSelezionata.setSimbolo("g");
						}
					}
					if(scelta.equalsIgnoreCase("croce")&&casellaSelezionata.isVuota()){
						 if(!partitaFinita){
						griglia.get(j).setIcon(croce.disegnaCroce());
						casellaSelezionata.setSimbolo("g");
					}
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
		@Override
		public void update(Observable o, Object arg) {
			creaPannello();
		}
}
