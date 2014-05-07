/**
 * Questa classe ha la responsabilità di gestire il pannello di gioco
 * @author Giacomo
 */
package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tris.Casella;
import tris.TabellaTris;
import vincita.GestoreVincite;

public class PannelloGiocoOnline extends JPanel implements PannelloTris, Observer {
	
	private TabellaTris tabellaTris;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();
	private String scelta;
	private boolean partitaFinita;
	private GestoreVincite gestoreVincite;
	private boolean mioTurno;
	JPanel turno = new JPanel();
	JPanel gioco = new JPanel();
	JTextArea area = new JTextArea("Mio turno");
	
	public PannelloGiocoOnline(TabellaTris tabellaTris,String scelta) {
		super();
		this.tabellaTris = tabellaTris;
		gestoreVincite = new GestoreVincite(tabellaTris.getCaselle());
		this.scelta = scelta;
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			tabellaTris.getCaselle().get(i).addObserver(this);
		}
		mioTurno = true;
		
		gioco.setLayout(new GridLayout(3, 3));
		add(turno);
		add(gioco);
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
		
	}

	@Override
	public JPanel creaPannello() {
		//tabellaTris = new TabellaTris();
		//tabellaTris.creaTabella();
		
		area.setFont(new Font("Verdana",Font.PLAIN,20));
		if(mioTurno){
			area.setForeground(Color.GREEN);
		}else{
			area.setForeground(Color.RED);
		}
		turno.add(area);
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
					if(scelta.equalsIgnoreCase("cerchio")&&casellaSelezionata.isVuota()&&mioTurno){
						if(!partitaFinita){
						griglia.get(j).setIcon(cerchio.disegnaCerchio());
						
						gestoreVincite.getVerificaVincita();
						casellaSelezionata.setSimbolo("g");
						
						
						}
					}
					if(scelta.equalsIgnoreCase("croce")&&casellaSelezionata.isVuota()&&mioTurno){
						 if(!partitaFinita){
						griglia.get(j).setIcon(croce.disegnaCroce());
						gestoreVincite.getVerificaVincita();
						casellaSelezionata.setSimbolo("g");
						
					}
					}
				}
			});
			}
		}
		public void setupPanel(){
			
			for (int i = 0; i < griglia.size(); i++) {
					gioco.add(griglia.get(i));
			}
		}
		@Override
		public void update(Observable o, Object arg) {
			if(mioTurno){
				mioTurno = false;
			}else{
				mioTurno = true;
			}
			creaPannello();
		}
}
