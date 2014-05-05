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

import javax.swing.JButton;
import javax.swing.JPanel;

import tris.Casella;
import tris.TabellaTris;
import vincita.GestoreVincite;

import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.ProxyDifficoltà;

public class PannelloGioco extends JPanel implements PannelloTris {
	
	private TabellaTris tabellaTris;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();
	private String scelta;
	private GestoreVincite gestoreVincite;
	private boolean partitaFinita;
	
	public PannelloGioco(TabellaTris tabellaTris,String scelta) {
		super();
		this.tabellaTris = tabellaTris;
		this.scelta = scelta;
		
	}

	@Override
	public JPanel creaPannello() {
		tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		setLayout(new GridLayout(3, 3));
		gestoreVincite = new GestoreVincite(tabellaTris.getCaselle());
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
		return this;
	}
	
	public void ia(String scelta){
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàDifficile());
		int index = proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
		if(!partitaFinita){
			if(scelta=="Cerchio" && griglia.get(index).getIcon()==null){
				griglia.get(index).setIcon(croce.disegnaCroce());
				info();
			}
			if(scelta=="Croce" && griglia.get(index).getIcon()==null){
				griglia.get(index).setIcon(cerchio.disegnaCerchio());
				info();
				}
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
					if(scelta=="Cerchio"&&casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
						partitaFinita = gestoreVincite.getVerificaVincita().partitaFinita();
						if(!partitaFinita){
						griglia.get(j).setIcon(cerchio.disegnaCerchio());
						casellaSelezionata.setSimbolo("g");
						partitaFinita = gestoreVincite.getVerificaVincita().partitaFinita();
						ia(scelta);
						}
					}
					if(scelta=="Croce"&&casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
						if(!partitaFinita){
						griglia.get(j).setIcon(croce.disegnaCroce());
						partitaFinita = gestoreVincite.getVerificaVincita().partitaFinita();
						casellaSelezionata.setSimbolo("g");
						partitaFinita = gestoreVincite.getVerificaVincita().partitaFinita();
						ia(scelta);
						}
					}
				}
			});
			}
		}
		public TabellaTris getTabellaTris() {
			return tabellaTris;
		}
		public void setTabellaTris(TabellaTris tabellaTris) {
			this.tabellaTris = tabellaTris;
		}
		
		public void setupPanel(){
			
			for (int i = 0; i < griglia.size(); i++) {
					add(griglia.get(i));
			}
		}
// DEBUG	
		public void info(){
			for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
				System.out.println(tabellaTris.getCaselle().get(i));
			}
		}
			
		public ArrayList<JButton> getGriglia() {
			return griglia;
		}

		public void setGriglia(ArrayList<JButton> griglia) {
			this.griglia = griglia;
		}
}
