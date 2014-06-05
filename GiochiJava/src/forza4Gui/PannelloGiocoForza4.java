package forza4Gui;

import grafica.PannelloGioco;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import rete.TimerPannello;

public class PannelloGiocoForza4 extends JPanel implements Observer, PannelloGioco {
	
//	private DisegnaPannello disegnaPannello = new DisegnaPannello();
	private JPanel pannelloGriglia = new JPanel();
	private TimerPannello timerPannello = new TimerPannello();
	private ArrayList<Pulsante> pulsanti = new ArrayList<>();
	
	


	
	public void setupInziale(){
		removeAll();
		setLayout(null);
		timerPannello.addObserver(this);
//		disegnaPannello.pannelloGiocatori(this, turno.getMioSimbolo(), turno.getSimboloAvversario());
//		disegnaPannello.creaPulsanti(pulsanti,7);
//		disegnaPannello.setPosizionePulsanti(pulsanti);
//		disegnaPannello.setupPulsanti(this, pulsanti);
//		disegnaPannello.setupGrigliaForza4(this);
		add(pannelloGriglia);
//		disegnaPannello.setupAzioneMossa(pulsanti, turno.getIDpartita(), turno.getMioSimbolo());
	}
	
	@Override
	public void update(Observable o, Object arg) {
//		if(disegnaPannello.disegnaSimboli(this,null,turno)){
//		}else{
//			timerPannello.deleteObserver(this);
//		}
		
	}
	@Override
	public JPanel creaPannello() {
		setupInziale();
		return this;
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

	@Override
	public ArrayList<JButton> getCaselle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMioSimbolo(String mioSimbolo) {
		// TODO Auto-generated method stub
		
	}
}
