package trisGui;

import grafica.PannelloGioco;
import grafica.VisualizzatoreRisultato;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rete.Client;
import rete.InterpreteMessaggio;
import rete.TimerPannello;
/**
 * Questa classe ha la responsabilitÃ  di gestire l'interfaccia grafica del gioco del Tris, che si sviluppa Online
 */
@SuppressWarnings("serial")
public class PannelloGiocoTris extends JPanel implements PannelloGioco,Observer {
	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private Icona[] icone;
	private JLabel label = new JLabel("Tuo turno");
	private int mossa = 0;
	private VisualizzatoreRisultato visualizzatore = new VisualizzatoreRisultato();
	private SituazioneTurno turno;
	private TimerPannello timerPannello = new TimerPannello();
	
	public PannelloGiocoTris(SituazioneTurno turno) {
		super();
		this.turno = turno;
		setupInizialeGioco(turno.getMiaIcona());
	}
	
	/**
	 * Inizializza il gioco
	 * @param iconaMia
	 */
	private void setupInizialeGioco(String iconaMia) {
		icone = turno.getIcone();
		setupTurnoInziale(turno.inizioIO());
		setupInizialeGriglia();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setupPanel();
		setupAction();
		timerPannello.addObserver(this);
	}
	
	
	private void disegnaTris(){
		for (int i = 0; i < interpreteMessaggio.getCaselle().size(); i++) {
			String simbolo = interpreteMessaggio.getCaselle().get(i);
			if(simbolo.equalsIgnoreCase(turno.getMioSimbolo())){
			griglia.get(i).setIcon(icone[0].disegna());
			}
			if(simbolo.equalsIgnoreCase(turno.getSimboloAvversario())){
			griglia.get(i).setIcon(icone[1].disegna());
			}
		}
		turno.calcolaTurno(interpreteMessaggio.getUltimoGiocatore());
		mostraTurno(turno.isMioTurno());
	}
	
	private void setupPanel(){
		
		JPanel pannelloTesto = new JPanel();
		pannelloTesto.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		Font font = new Font("Verdana", Font.BOLD, 16);
		label.setFont(font);
		pannelloTesto.add(label);
		pannelloTesto.setPreferredSize(new Dimension(400,50));
		add(pannelloTesto);
		JPanel pannelloGriglia = new JPanel();
		pannelloGriglia.setPreferredSize(new Dimension(400,350));
		pannelloGriglia.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < griglia.size(); i++) {
			pannelloGriglia.add(griglia.get(i));
		}
		add(pannelloGriglia);
	}
	
	private void setupInizialeGriglia(){
		for (int i = 0; i < 9; i++) {
			final JButton button = new JButton();
			button.setBackground(Color.WHITE);
			griglia.add(button);
		}
	}
	
	/**
	 * Questo metodo crea l'azione di aver premuto un {@link JButton}
	 */
	private void setupAction(){
		for (int i = 0; i <9; i++) {
			final int index = i;
			griglia.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(griglia.get(index).getIcon()==null && mossa==0 && visualizzatore.isAggiorna()){
						Client.send("Mossa	"+turno.getIDpartita()+"	"+turno.getMioSimbolo()+"	"+index);
						griglia.get(index).setIcon(icone[0].disegna());
						mossa++;
					}	
				}
			});
		}
	}
	
	
	
	@Override
	public JPanel creaPannello() {
		return this;
	}
	
	/**
	 * Questo metodo permette di stabilire a chi tocca giocare
	 * @param sommaCaselle
	 * @return
	 */
	private void mostraTurno(boolean turno){
		if(turno){
			label.setForeground(Color.GREEN);
			mossa=0;
		}else{
			label.setForeground(Color.RED);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(visualizzatore.isAggiorna()){
			interpreteMessaggio.interpreta(Client.send("Update	"+turno.getIDpartita()));
			disegnaTris();
			visualizzatore.mostraRisultato(interpreteMessaggio, turno.getMioSimbolo());
		}else{
			timerPannello.deleteObserver(this);
		}
	}
	
	/**
	 * Questo metodo permette di impostare il colore del label del turno iniziale
	 */
	private void setupTurnoInziale(boolean inizioIO){
		if(inizioIO){
			label.setForeground(Color.GREEN);
		}else{
			label.setForeground(Color.RED);
		}
	}
}