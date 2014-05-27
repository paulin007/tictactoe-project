package trisGui;

import grafica.ControllerGioco;
import grafica.PannelloGioco;
import grafica.Simbolo;
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

import rete.InterpreteMessaggio;
import rete.TimerPannello;
/**
 * Questa classe ha la responsabilitÃ  di gestire l'interfaccia grafica del gioco del Tris, che si sviluppa Online
 */
public class PannelloGiocoOnlineTris extends JPanel implements PannelloGioco,Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private Icona[] icone = new Icona[2];
	private ControllerGioco controllerTris;
	private static int numeroCaselle = 9;
	private JLabel label = new JLabel("Tuo turno");
	private String mioSimbolo;
	private String simboloAvversario;
	private String IDpartita;
	private String messaggioMossa = "Mossa	";
	private String ultimaMossa;
	@SuppressWarnings("unused")
	private boolean mioTurno = false;
	private int mossa = 0;
	private VisualizzatoreRisultato visualizzatore = new VisualizzatoreRisultato();
	

	public PannelloGiocoOnlineTris(ControllerGioco controllerTris, String mioSimbolo, String iconaMia, String IDpartita) {
		super();
		this.controllerTris = controllerTris;
		this.mioSimbolo = mioSimbolo;
		this.IDpartita = IDpartita;
		setupInizialeGioco(iconaMia);
	}
	
	/**
	 * Inizializza il gioco
	 * @param iconaMia
	 */
	private void setupInizialeGioco(String iconaMia) {
		setIcona(iconaMia);
		setSimboloAvversario();
		setupTurnoInziale();
		setupInizialeGriglia();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setupPanel();
		setupAction();
		TimerPannello timerPannello = new TimerPannello();
		timerPannello.addObserver(this);
		messaggioMossa +=this.IDpartita+"	"+mioSimbolo+"	";
	}
	
	
	private void disegnaTris(){
		// inCorso G1 X G2 G1 G1 G2 G2 X X;
		ArrayList<Integer> caselleMie = new ArrayList<>();
		ArrayList<Integer> caselleAvversario = new ArrayList<>();
		for (int i = 0; i < interpreteMessaggio.getCaselle().size(); i++) {
			String simbolo = interpreteMessaggio.getCaselle().get(i);
			if(simbolo.equalsIgnoreCase(mioSimbolo)){
				caselleMie.add(i);
			}
			if(simbolo.equalsIgnoreCase(simboloAvversario)){
				caselleAvversario.add(i);
			}
		}
		isMioTurno(interpreteMessaggio.getUltimoGiocatore());
		for (int i = 0; i < caselleMie.size(); i++) {
			griglia.get(caselleMie.get(i)).setIcon(icone[0].disegna());
		}
		for (int i = 0; i < caselleAvversario.size(); i++) {
			griglia.get(caselleAvversario.get(i)).setIcon(icone[1].disegna());
		}
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
		for (int i = 0; i <numeroCaselle; i++) {
			final int index = i;
			griglia.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(griglia.get(index).getIcon()==null && mossa==0 && visualizzatore.isAggiorna()){
						ultimaMossa = messaggioMossa+index;
						System.out.println(ultimaMossa);
						controllerTris.getClient().send(ultimaMossa);
						griglia.get(index).setIcon(icone[0].disegna());
						mossa++;
					}	
				}
			});
		}
	}
	
	/**
	 * Questo metodo permette di stabilire i simboli che sono usati nel Tris
	 */
	private void setSimboloAvversario(){
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)){
			simboloAvversario = Simbolo.simboloG2;
		}
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)){
			simboloAvversario = Simbolo.simboloG1;
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
	private void isMioTurno(String ultimoGiocatore){
		if(!mioSimbolo.equalsIgnoreCase(ultimoGiocatore)){
			label.setForeground(Color.GREEN);
			mioTurno = true;
			mossa=0;
		}else{
			label.setForeground(Color.RED);
			mioTurno = false;
		}
	}
	
	/**
	 * Questo metodo permette di impostare il tipo di icona che viene mostrata a video
	 * @param iconaMia
	 */
	private void setIcona(String iconaMia){
		if(iconaMia.equalsIgnoreCase("Croce")){
			this.icone[0] = new Croce();
			this.icone[1] = new Cerchio();
		}
		if(iconaMia.equalsIgnoreCase("Cerchio")){
			this.icone[0] = new Cerchio();
			this.icone[1] = new Croce();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(visualizzatore.isAggiorna()){
			interpreteMessaggio.interpreta(controllerTris.getClient().send("Update	"+IDpartita));
			disegnaTris();
			visualizzatore.mostraRisultato(interpreteMessaggio, mioSimbolo);
			creaPannello();
		}	
	}
	
	/**
	 * Questo metodo permette di impostare il colore del label del turno iniziale
	 */
	private void setupTurnoInziale(){
		if(Simbolo.simboloG1.equalsIgnoreCase(mioSimbolo)){
			this.mioTurno = true;
			label.setForeground(Color.GREEN);
		}else{
			this.mioTurno = false;
			label.setForeground(Color.RED);
		}
	}
	

}