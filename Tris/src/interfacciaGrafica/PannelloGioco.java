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
import tris.Simbolo;
import tris.TabellaTris;
import vincita.AlgoritmoTris;
import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.ProxyDifficoltà;

public class PannelloGioco extends JPanel implements PannelloTris,Observer {
	
	private TabellaTris tabellaTris;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Icona iconaMia;
	private Icona iconaAvversario;
	private AlgoritmoTris algoritmoTris = new AlgoritmoTris();
	private boolean partitaFinita;
	
	public PannelloGioco(TabellaTris tabellaTris,String scelta) {
		super();
		this.tabellaTris = tabellaTris;
		algoritmoTris.addObserver(this);
		impostaIcone(scelta);
		
	}

	private void impostaIcone(String scelta) {
		if(scelta.equalsIgnoreCase("Croce")){
			iconaMia = new Croce();
			iconaAvversario = new Cerchio();
		}
		if(scelta.equalsIgnoreCase("Cerchio")){
			iconaMia = new Cerchio();
			iconaAvversario = new Croce();
		}
	}

	@Override
	public JPanel creaPannello() {
		tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
		return this;
	}
	
	public void ia(){
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàDifficile());
		int index = proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
		if(!partitaFinita){
			griglia.get(index).setIcon(iconaAvversario.disegna());
			algoritmoTris.stabilisciVincitore(tabellaTris.getCaselle());
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
					if(casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
						if(!partitaFinita){
						griglia.get(j).setIcon(iconaMia.disegna());
						partitaFinita = algoritmoTris.partitaFinita();
						casellaSelezionata.setSimbolo(Simbolo.simboloG1);
						algoritmoTris.stabilisciVincitore(tabellaTris.getCaselle());
						partitaFinita = algoritmoTris.partitaFinita();
						ia();
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
		@Override
		public void update(Observable o, Object arg) {
			System.out.println("sono stato notificato");
			partitaFinita = true;
			algoritmoTris.getRisultato();
			
		}
}
