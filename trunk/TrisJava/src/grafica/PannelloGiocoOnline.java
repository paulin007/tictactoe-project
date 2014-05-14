/**
 * Questa classe ha la responsabilitÃ  di gestire l'interfaccia grafica del gioco del Tris, che si sviluppa Online
 */
package grafica;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import rete.InterpreteMessaggio;
import rete.TimerPannello;
import tris.Simbolo;

public class PannelloGiocoOnline extends JPanel implements PannelloTris,Observer {
	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private Icona iconaMia;
	private Icona iconaAvversario;
	private ControllerTris controllerTris;
	private static int numeroCaselle = 9;
	private JLabel label = new JLabel("Mio turno");
	private String mioSimbolo;
	private String simboloAvversario;
	private String IDpartita;
	private String messaggioMossa = "Mossa	";
	private String ultimaMossa;
	private boolean mioTurno = false;
	private boolean risultatoMostrato = false;
	String messaggioRicevuto ="";
	

	public PannelloGiocoOnline(ControllerTris controllerTris,String mioSimbolo,String iconaMia,String IDpartita) {
		super();
		this.controllerTris = controllerTris;
		this.mioSimbolo = mioSimbolo;
		this.IDpartita = IDpartita;
		setIcona(iconaMia);
		setSimboloAvversario();
		setupTurnoInziale();
		setupInizialeGriglia();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setupPanel();
		setupAction();
		TimerPannello timerPannello = new TimerPannello();
		timerPannello.addObserver(this);
		System.out.println(IDpartita);
		messaggioMossa +=this.IDpartita+"	"+mioSimbolo+"	";
	}
	/**
	 * Questo metodo permette di interpretare una stringa contente le mosse della partita e stampare a video
	 * @param partita
	 */
	public void disegnaTris(){
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
		System.out.println(interpreteMessaggio.getUltimoGiocatore());
//		int sommaCaselle = caselleMie.size()+caselleAvversario.size();
//		isMioTurno(sommaCaselle);
		for (int i = 0; i < caselleMie.size(); i++) {
			griglia.get(caselleMie.get(i)).setIcon(iconaMia.disegna());
		}
		for (int i = 0; i < caselleAvversario.size(); i++) {
			griglia.get(caselleAvversario.get(i)).setIcon(iconaAvversario.disegna());
		}
		setupPanel();
	}
	
private void setupPanel(){
		
		JPanel pannelloTesto = new JPanel();
		pannelloTesto.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		Font font = new Font("Verdana", Font.BOLD, 16);
		
		label.setFont(font);
		
		label.setPreferredSize(new Dimension(85,20));
		
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
							if(griglia.get(index).getIcon()==null){
								ultimaMossa = messaggioMossa+index;
								System.out.println(ultimaMossa);
								controllerTris.getClient().send(ultimaMossa);
								griglia.get(index).setIcon(iconaMia.disegna());
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
			this.iconaMia = new Croce();
			this.iconaAvversario = new Cerchio();
		}
		if(iconaMia.equalsIgnoreCase("Cerchio")){
			this.iconaMia = new Cerchio();
			this.iconaAvversario = new Croce();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		interpreteMessaggio.interpreta(controllerTris.getClient().send(ultimaMossa));
		//interpreteMessaggio.interpreta("Partita	0	Giocatore1	G1 G2 null G1 null null G1 G2 G1 G1");
		disegnaTris();
		if(!risultatoMostrato){
			mostraRisultato();
			risultatoMostrato = true;
		}
		creaPannello();
	}
	private void setupTurnoInziale(){
		if(Simbolo.simboloG1.equalsIgnoreCase(mioSimbolo)){
			mioTurno = true;
			label.setForeground(Color.GREEN);
		}else{
			mioTurno = false;
			label.setForeground(Color.RED);
		}
	}
	/**
	 * Questo metodo permette di mostrare a video, il risultato della partita
	 */
	private void mostraRisultato(){
		String risultato = interpreteMessaggio.getStatoPartita();
		if(risultato.equalsIgnoreCase("Giocatore1")&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)||
				risultato.equalsIgnoreCase("Giocatore2")&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)){
			risultato = "Hai vinto !";
			JOptionPane.showMessageDialog(null, risultato);
		}
		if(risultato.equalsIgnoreCase("Giocatore1")&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)||
				risultato.equalsIgnoreCase("Giocatore2")&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)){
			risultato = "Hai perso !";
			JOptionPane.showMessageDialog(null, risultato);
		}
		if(risultato.equalsIgnoreCase("Pareggio")){
			risultato = "La partita è finita in pareggio";
			JOptionPane.showMessageDialog(null, risultato);
		}
	}
}