package forza4Gui;

import grafica.VisualizzatoreRisultato;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rete.Client;
import rete.InterpreteMessaggio;
import trisGui.Icona;
import trisGui.SituazioneTurno;
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
	private int mossa = 0;
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private VisualizzatoreRisultato visualizzatoreRisultato = new VisualizzatoreRisultato();
	
	public void disegnaCaselleIniziali(ArrayList<JButton> caselle,int numeroCaselle,JPanel pannello){
		JPanel pannelloTris = new JPanel();
		pannelloTris.setBounds(100, 100, 400, 400);
		pannelloTris.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < numeroCaselle; i++) {
			JButton button = new JButton();
			button.setBackground(Color.WHITE);
			caselle.add(button);
			pannelloTris.add(button);
		}
		pannello.add(pannelloTris);
	}
	
	
	public void creaPulsanti(ArrayList<Pulsante> pulsanti,int n){
		for (int i = 0; i < n; i++) {
			pulsanti.add(new Pulsante());
			}
		}
	// Questo metodo imposta i pulsanti all'interno del Pannello
	public void setPosizionePulsanti(ArrayList<Pulsante> pulsanti){
		for (int i = 0; i < pulsanti.size(); i++) {
			pulsanti.get(i).setBounds((PosizioneSimbolo.PRIMA_COLONNA+PosizioneSimbolo.SPAZIO_VERTICALE*i),95,42,38);
			}
		}
	
	public boolean disegnaSimboli(JPanel panel,ArrayList<JButton> griglia, SituazioneTurno turno){
		if(visualizzatoreRisultato.isAggiorna()){
			interpreteMessaggio.interpreta(Client.send("Update	"+turno.getIDpartita()));
			for (int i = 0; i < interpreteMessaggio.getCaselle().size(); i++) {
				String simbolo = interpreteMessaggio.getCaselle().get(i);
				if(simbolo.equalsIgnoreCase(turno.getMioSimbolo())){
					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("tris")){
						griglia.get(i).setIcon(turno.getIcone()[0].disegna());
					}
					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("forza4")){
						disegnaForza4(panel, i, 0);
					}
				}
				if(simbolo.equalsIgnoreCase(turno.getSimboloAvversario())){
					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("tris")){
						griglia.get(i).setIcon(turno.getIcone()[1].disegna());
					}
					if(interpreteMessaggio.getTipoMessaggio().equalsIgnoreCase("forza4")){
						disegnaForza4(panel, i, 1);
					}
				}
			}	
			turno.calcolaTurno(interpreteMessaggio.getUltimoGiocatore());
			mostraTurno(turno.isMioTurno());
			visualizzatoreRisultato.mostraRisultato(interpreteMessaggio.getStatoPartita(), turno.getMioSimbolo());
			return true;
		}else{
			return false;
		}
	}

	public void pannelloGiocatori(JPanel panel,String mioSimbolo,String simboloAvversario){
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
	 * Questo metodo crea l'azione di aver premuto un {@link JButton}
	 */
	public void setupAction(final ArrayList<JButton> griglia,final String IDpartita,final String simbolo,final Icona iconaMia){
		for (int i = 0; i <9; i++) {
			final int index = i;
			griglia.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(griglia.get(index).getIcon()==null && mossa==0 /*&& visualizzatore.isAggiorna()*/){
						Client.send("Mossa	"+IDpartita+"	"+simbolo+"	"+index);
						griglia.get(index).setIcon(iconaMia.disegna());
						mossa++;
					}	
				}
			});
		}
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
			mossa=0;
		}else{
			player1.setColor(Color.RED);
			player2.setColor(Color.GREEN);
		}
	}
	
	public void setupGrigliaForza4(JPanel panel){
		JLabel griglia = new JLabel();
		java.net.URL imgUrl2 = getClass().getResource("Immagini/griglia.png");
		ImageIcon icon = new ImageIcon(imgUrl2);
		griglia.setIcon(icon);
		griglia.setBounds(123, 144, 428, 366);
		panel.add(griglia);
		java.net.URL imgUrl = getClass().getResource("Immagini/Forza4verticale1.png");
		ImageIcon icon2 = new ImageIcon(imgUrl);
		JLabel logoVerticale = new JLabel(icon2);
		logoVerticale.setBounds(10, 144, 103, 357);
		panel.add(logoVerticale);
	}
	// Aggiungi i pulsanti al pannello
		public void setupPulsanti(JPanel panel,ArrayList<Pulsante> pulsanti){
			for (int i = 0; i < pulsanti.size(); i++) {
				panel.add(pulsanti.get(i));
			}
		}	
	// Serve per disegnare una casella all'interno del pannello
	public void disegnaForza4(JPanel panel,int casella,int colore){
			try {
				java.net.URL imgUrl1 = null;
				if(colore==0){
				imgUrl1 = getClass().getResource("Immagini/palla_gialla11.png");
				}
				if(colore==1){
				imgUrl1 = getClass().getResource("Immagini/palla_rossa11.png");
				}
				BufferedImage image= ImageIO.read(imgUrl1);
				panel.getGraphics().drawImage(image,PosizioneSimbolo.casellaToX(casella),PosizioneSimbolo.casellaToY(casella),null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
	// Questo metodo imposta le azioni
		public void setupAzioneMossa(ArrayList<Pulsante> pulsanti,final String IDpartita,final String mioSimbolo){
			for (int i = 0; i < pulsanti.size() ; i++) {
				final int numeroColonna = i;
				pulsanti.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Client.send("Mossa	"+IDpartita+"	"+mioSimbolo+"	"+numeroColonna);
						System.out.println(numeroColonna);
					}
				});
			}
		}
}
