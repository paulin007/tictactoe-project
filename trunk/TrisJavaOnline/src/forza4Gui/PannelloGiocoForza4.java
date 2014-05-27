package forza4Gui;

import grafica.ControllerGioco;
import grafica.PannelloGioco;
import grafica.Simbolo;
import grafica.VisualizzatoreRisultato;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rete.InterpreteMessaggio;
import rete.TimerPannello;

public class PannelloGiocoForza4 extends JPanel implements PannelloGioco, Observer {
	
//	private String mioNome = "Dario";
//	private String nomeAvversario = "Simone";
	private ArrayList<Pulsante> pulsanti = new ArrayList<>();
	private LabelGiocatori player1;
	private LabelGiocatori player2;
	private LabelSfida VS = new LabelSfida("VS");
	private ControllerGioco controllerTris;
	private String IDpartita;
	private String mioSimbolo;
	private String simboloAvversario;
//	private boolean mioTurno = false;
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private VisualizzatoreRisultato visualizzatore = new VisualizzatoreRisultato();
//	private int mossa = 0;

	public PannelloGiocoForza4(ControllerGioco controllerTris,String mioSimbolo, String IDpartita) {
		this.controllerTris = controllerTris;
		this.mioSimbolo = mioSimbolo;
		this.IDpartita = IDpartita;
		TimerPannello timerPannello = new TimerPannello();
		timerPannello.addObserver(this);
		setLayout(null);
		setupIniziale();
		player1 = new LabelGiocatori(mioSimbolo, new Color(196,44,0));
		player2 = new LabelGiocatori(simboloAvversario, new Color(220,213,11));
		setupGrigliaForza4();
	}

	private void setupIniziale(){
		setSimboloAvversario();
		creaPulsanti();
		setPosizionePulsanti();
		setupPulsanti();
		setupAzioneMossa();
	}
	// Questo metodo serve per aggiungere 7 pulsanti
	private void creaPulsanti(){
		for (int i = 0; i < 7; i++) {
			pulsanti.add(new Pulsante());
		}
	}
	// Questo metodo imposta i pulsanti all'interno del Pannello
	private void setPosizionePulsanti(){
		for (int i = 0; i < pulsanti.size(); i++) {
			pulsanti.get(i).setBounds((PosizioneSimbolo.PRIMA_COLONNA+PosizioneSimbolo.SPAZIO_VERTICALE*i),95,42,38);
		}
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			java.net.URL imgUrl = getClass().getResource("Immagini/Sfondo2.png");
			BufferedImage image = ImageIO.read(imgUrl);
			g.drawImage(image,0,0,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	// Aggiungi i pulsanti al pannello
	private void setupPulsanti(){
		for (int i = 0; i < pulsanti.size(); i++) {
			add(pulsanti.get(i));
		}
	}	
	// Questo metodo imposta le azioni
	private void setupAzioneMossa(){
		for (int i = 0; i < pulsanti.size() ; i++) {
			final int numeroColonna = i;
			pulsanti.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controllerTris.getClient().send("Mossa	"+IDpartita+"	"+mioSimbolo+"	"+numeroColonna);
					System.out.println(numeroColonna);
				}
			});
		}
	}
	@Override
	public JPanel creaPannello() {
		return this;
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
	 * Questo metodo permette di stabilire i simboli che sono usati
	 */
	private void setSimboloAvversario(){
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)){
			simboloAvversario = Simbolo.simboloG2;
		}
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)){
			simboloAvversario = Simbolo.simboloG1;
		}
	}
	
	private void disegnaTris(){
		for (int i = 0; i < interpreteMessaggio.getCaselle().size(); i++) {
			String simbolo = interpreteMessaggio.getCaselle().get(i);
			int casella = i;
			if(simbolo.equalsIgnoreCase(mioSimbolo)){
				draw(casella, 0);
			}
			if(simbolo.equalsIgnoreCase(simboloAvversario)){
				draw(casella,1);
			}
		}
		isMioTurno(interpreteMessaggio.getUltimoGiocatore());
	}
	/**
	 * Questo metodo permette di stabilire a chi tocca giocare
	 * @param sommaCaselle
	 * @return
	 */
	private void isMioTurno(String ultimoGiocatore){
		if(!mioSimbolo.equalsIgnoreCase(ultimoGiocatore)){
			player1.setColor(Color.GREEN);
			player2.setColor(Color.RED);
	//		mioTurno = true;
	//		mossa=0;
		}else{
			player1.setColor(Color.RED);
			player2.setColor(Color.GREEN);
	//		mioTurno = false;
		}
	}
	// Serve per disegnare una casella all'interno del pannello
	private void draw(int casella,int colore){
		
		try {
			java.net.URL imgUrl1 = null;
			if(colore==0){
			imgUrl1 = getClass().getResource("Immagini/palla_gialla11.png");
			}
			if(colore==1){
			imgUrl1 = getClass().getResource("Immagini/palla_rossa11.png");
			}
			BufferedImage image= ImageIO.read(imgUrl1);
			getGraphics().drawImage(image,PosizioneSimbolo.casellaToX(casella),PosizioneSimbolo.casellaToY(casella),null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setupGrigliaForza4() {
		JLabel griglia = new JLabel();
		java.net.URL imgUrl2 = getClass().getResource("Immagini/griglia.png");
		ImageIcon icon = new ImageIcon(imgUrl2);
		griglia.setIcon(icon);
		griglia.setBounds(123, 144, 428, 366);
		add(griglia);
		java.net.URL imgUrl = getClass().getResource("Immagini/Forza4verticale1.png");
		ImageIcon icon2 = new ImageIcon(imgUrl);
		JLabel logoVerticale = new JLabel(icon2);
		logoVerticale.setBounds(10, 144, 103, 357);
		add(logoVerticale);
		player1.setBounds(10, 11, 231, 87);
		add(player1);
		player2.setBounds(371, 11, 220, 87);
		add(player2);
		VS.setBounds(251, 11, 79, 87);
		add(VS);
	}
}
