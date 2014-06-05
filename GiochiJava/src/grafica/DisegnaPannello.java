package grafica;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import managers.IMatchManager;
import managers.ITurnManager;
import trisGui.Cerchio;
import trisGui.Croce;
import forza4Gui.LabelGiocatori;
import forza4Gui.LabelSfida;

/**
 * Questa classe astrae sul concetto di pannello da disegnare e contiene metodi utili per 
 * disegnare elementi grafici, all'interno di {@link JPanel}
 * @author Giacomo
 *
 */
public class DisegnaPannello {
	
	private LabelGiocatori player1;
	private LabelGiocatori player2;
	private LabelSfida VS = new LabelSfida("VS");
	private IMatchManager matchManager;
	private ITurnManager turnManager;
	private VisualizzatoreRisultato visualizzatoreRisultato = new VisualizzatoreRisultato();
	
	public DisegnaPannello(IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		this.turnManager = turnManager;
	}

	public void createGraphic(ArrayList<JButton> caselle, int numeroCaselle, JPanel pannello){
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 400, 400);
		panel.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < numeroCaselle; i++) {
			JButton button = new JButton();
			button.setBackground(Color.WHITE);
			caselle.add(button);
			panel.add(button);
			caselle.get(i).addActionListener(new ButtonListener(i, matchManager, (PannelloGioco)pannello, turnManager));
		}
		pannello.add(panel);
	}
	
	
//	public void creaPulsanti(ArrayList<Pulsante> pulsanti,int n){
//		for (int i = 0; i < n; i++) {
//			pulsanti.add(new Pulsante());
//			}
//		}
	// Questo metodo imposta i pulsanti all'interno del Pannello
//	public void setPosizionePulsanti(ArrayList<Pulsante> pulsanti){
//		for (int i = 0; i < pulsanti.size(); i++) {
//			pulsanti.get(i).setBounds((PosizioneSimbolo.PRIMA_COLONNA+PosizioneSimbolo.SPAZIO_VERTICALE*i),95,42,38);
//			}
//		}
	
//	public boolean disegnaSimboli(JPanel panel,ArrayList<JButton> griglia, SituazioneTurno turno){
//		if(visualizzatoreRisultato.isAggiorna()){
//			interpreteMessaggio.interpreta(Client.send("Update	"+turno.getIDpartita()));
//			for (int i = 0; i < interpreteMessaggio.getCaselle().size(); i++) {
//				String simbolo = interpreteMessaggio.getCaselle().get(i);
//				if(simbolo.equalsIgnoreCase(turno.getMioSimbolo())){
//					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("tris")){
//						griglia.get(i).setIcon(turno.getIcone()[0].disegna());
//					}
//					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("forza4")){
//						disegnaForza4(panel, i, 0);
//					}
//				}
//				if(simbolo.equalsIgnoreCase(turno.getSimboloAvversario())){
//					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("tris")){
//						griglia.get(i).setIcon(turno.getIcone()[1].disegna());
//					}
//					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("forza4")){
//						disegnaForza4(panel, i, 1);
//					}
//				}
//			}	
//			turno.calcolaTurno(interpreteMessaggio.getUltimoGiocatore());
//			mostraTurno(turno.isMioTurno());
//			visualizzatoreRisultato.mostraRisultato(interpreteMessaggio.getStatoPartita(), turno.getMioSimbolo());
//			return true;
//		}else{
//			return false;
//		}
//	}
	
	public void paint(ArrayList<JButton> caselle, String mioSimbolo, String simboloAvversario){

		ArrayList<String> listaCaselle = matchManager.getInterprete().getCaselle();

		for (int i = 0; i < listaCaselle.size(); i++) {
			if(listaCaselle.get(i).equalsIgnoreCase(mioSimbolo)){
				caselle.get(i).setIcon(new Cerchio().disegna());
			}
			if(listaCaselle.get(i).equalsIgnoreCase(simboloAvversario)){
				caselle.get(i).setIcon(new Croce().disegna());
			}
		}
		setPlayersTurn(mioSimbolo);
		mostraTurno(!matchManager.getInterprete().getUltimoGiocatore().equalsIgnoreCase(mioSimbolo));
		visualizzatoreRisultato.mostraRisultato(matchManager.getInterprete().getStatoPartita(), mioSimbolo);
	}

	private void setPlayersTurn(String mioSimbolo) {
		if(matchManager.getInterprete().getUltimoGiocatore().equalsIgnoreCase(mioSimbolo)){
			turnManager.setMyTurn(false);
		}else{
			turnManager.setMyTurn(true);
		}
	}

	public void disegnaPannelloGiocatori(JPanel panel, String mioSimbolo, String simboloAvversario){		//TODO cambiare nome
		player1 = new LabelGiocatori(mioSimbolo, new Color(196,44,0));
		player2 = new LabelGiocatori(simboloAvversario, new Color(220,213,11));
		player1.setBounds(10, 11, 231, 87);
		panel.add(player1);
		player2.setBounds(371, 11, 220, 87);
		panel.add(player2);
		VS.setBounds(251, 11, 79, 87);
		panel.add(VS);
	}

	/**
	 * Questo metodo permette di stabilire a chi tocca giocare
	 * @param sommaCaselle
	 * @return
	 */
	private void mostraTurno(boolean turno){
		if(turno){
			player1.setColor(Color.GREEN);
			player2.setColor(Color.RED);
		}else{
			player1.setColor(Color.RED);
			player2.setColor(Color.GREEN);
		}
	}
	
//	public void setupGrigliaForza4(JPanel panel){
//		JLabel griglia = new JLabel();
//		java.net.URL imgUrl2 = getClass().getResource("Immagini/griglia.png");
//		ImageIcon icon = new ImageIcon(imgUrl2);
//		griglia.setIcon(icon);
//		griglia.setBounds(123, 144, 428, 366);
//		panel.add(griglia);
//		java.net.URL imgUrl = getClass().getResource("Immagini/Forza4verticale1.png");
//		ImageIcon icon2 = new ImageIcon(imgUrl);
//		JLabel logoVerticale = new JLabel(icon2);
//		logoVerticale.setBounds(10, 144, 103, 357);
//		panel.add(logoVerticale);
//	}
	// Aggiungi i pulsanti al pannello
//		public void setupPulsanti(JPanel panel,ArrayList<Pulsante> pulsanti){
//			for (int i = 0; i < pulsanti.size(); i++) {
//				panel.add(pulsanti.get(i));
//			}
//		}	
	// Serve per disegnare una casella all'interno del pannello
//	public void disegnaForza4(JPanel panel,int casella,int colore){
//			try {
//				java.net.URL imgUrl1 = null;
//				if(colore==0){
//				imgUrl1 = getClass().getResource("Immagini/palla_gialla11.png");
//				}
//				if(colore==1){
//				imgUrl1 = getClass().getResource("Immagini/palla_rossa11.png");
//				}
//				BufferedImage image= ImageIO.read(imgUrl1);
//				panel.getGraphics().drawImage(image,PosizioneSimbolo.casellaToX(casella),PosizioneSimbolo.casellaToY(casella),null);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	}	
	
//	// Questo metodo imposta le azioni
//		public void setupAzioneMossa(ArrayList<Pulsante> pulsanti,final String IDpartita,final String mioSimbolo){
//			for (int i = 0; i < pulsanti.size() ; i++) {
//				final int numeroColonna = i;
//				pulsanti.get(i).addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						Client.send("Mossa	"+IDpartita+"	"+mioSimbolo+"	"+numeroColonna);
//						System.out.println(numeroColonna);
//					}
//				});
//			}
//		}
}
