/**
 * Questa classe ha la responsabilità di gestire l'interfaccia grafica del gioco del Tris, che si sviluppa Online
 */
package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;

import tris.Simbolo;

public class PannelloGiocoOnline extends JPanel implements PannelloTris {
	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Icona iconaMia;
	private Icona iconaAvversario;
	private ControllerTris controllerTris;
	private static int numeroCaselle = 9;
	private String mioSimbolo = "G1";
	private String simboloAvversario;
	private String messaggio = "Mossa	0	"+mioSimbolo+"	";
	private boolean mioTurno;
	
	public PannelloGiocoOnline() {
		setupInizialeGriglia();
		setLayout(new GridLayout(3, 3));
		setupPanel();
		setupAction();
	}
	
	public PannelloGiocoOnline(ControllerTris controllerTris,String mioSimbolo,String iconaMia) {
		super();
		this.controllerTris = controllerTris;
		this.mioSimbolo = mioSimbolo;
		setIcona(iconaMia);
		setSimboloAvversario();
		setupInizialeGriglia();
		setLayout(new GridLayout(3, 3));
		setupPanel();
		setupAction();
	}
	/**
	 * Questo metodo permette di interpretare una stringa contente le mosse della partita e stampare a video
	 * @param partita
	 */
	public void disegnaTris(String partita){
		// inCorso G1 X G2 G1 G1 G2 G2 X X;
		StringTokenizer stringTokenizer = new StringTokenizer(partita);
		ArrayList<Integer> caselleMie = new ArrayList<>();
		ArrayList<Integer> caselleAvversario = new ArrayList<>();
		String statoPartita = stringTokenizer.nextToken();
		int index = 0;
		while(stringTokenizer.hasMoreTokens()){
			String simbolo = stringTokenizer.nextToken();
			if(simbolo.equalsIgnoreCase(mioSimbolo)){
				caselleMie.add(index);
			}
			if(simbolo.equalsIgnoreCase(simboloAvversario)){
				caselleAvversario.add(index);
			}
			index++;
		}
		int sommaCaselle = caselleMie.size()+caselleAvversario.size();
		isMioTurno(sommaCaselle);
		for (int i = 0; i < caselleMie.size(); i++) {
			griglia.get(caselleMie.get(i)).setIcon(iconaMia.disegna());
		}
		for (int i = 0; i < caselleAvversario.size(); i++) {
			griglia.get(caselleAvversario.get(i)).setIcon(iconaAvversario.disegna());
		}
		setupPanel();
	}
	
	private void setupPanel(){
		for (int i = 0; i < griglia.size(); i++) {
				add(griglia.get(i));
		}
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
								controllerTris.getClient().send(messaggio+index);
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
	private boolean isMioTurno(int sommaCaselle){
		boolean state = false;
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)&&sommaCaselle%2==0){
			//somma caselle pari;
			state = true;
		}
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)&&sommaCaselle%2==1){
			//somma caselle dispari
			state = false;
		}
		return state;
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
}
