/**
 * Questa classe ha la responsabilità di gestire il pannello di gioco
 * @author Giacomo
 */
package copyNew;


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

public class PannelloGioco extends JPanel implements PannelloTris,Observer {
	
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Icona iconaMia;
	private Icona iconaAvversario;
	private ControllerTris controllerTris;
	private boolean partitaFinita;

	
	public PannelloGioco(ControllerTris controllerTris) {
		super();
		this.controllerTris = controllerTris;
		
		String miaScelta = controllerTris.getPannelloCheckBox().scelta();
		controllerTris.getAlgoritmoTris().addObserver(this);
		impostaIcone(miaScelta);
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
		
		controllerTris.getTabellaTris().creaTabella();
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
		return this;
	}
	
	public void ia(){
		TabellaTris tabellaTris = controllerTris.getTabellaTris();
		
		
		if(!partitaFinita){
			int index = controllerTris.getProxyDifficolta().getDifficoltà().generaMossa(tabellaTris);
			griglia.get(index).setIcon(iconaAvversario.disegna());
			controllerTris.getAlgoritmoTris().stabilisciVincitore(tabellaTris.getCaselle());
			partitaFinita = controllerTris.getAlgoritmoTris().partitaFinita();
			
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
			final TabellaTris tabellaTris = controllerTris.getTabellaTris();
			for (int i = 0; i < griglia.size(); i++) {
			
			final int j = i;
			griglia.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Casella casellaSelezionata = tabellaTris.getCaselle().get(j);
					if(casellaSelezionata.isVuota() && griglia.get(j).getIcon()==null){
						if(!partitaFinita){
						griglia.get(j).setIcon(iconaMia.disegna());
						casellaSelezionata.setSimbolo(Simbolo.simboloG1);
						controllerTris.getAlgoritmoTris().stabilisciVincitore(tabellaTris.getCaselle());
						
						partitaFinita = controllerTris.getAlgoritmoTris().partitaFinita();
						
						ia();
						
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
			partitaFinita = true;
			controllerTris.getAlgoritmoTris().getRisultato();
		}
}
