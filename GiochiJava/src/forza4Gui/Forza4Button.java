package forza4Gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import managers.DefaultSettings;
/**
 * questa classe ha la responsabilità di elaborare il comportamento di un bottone durante una partita di Forza4
 * @author gruppo progetto TIC TAC TOE
 */
@SuppressWarnings("serial")
public class Forza4Button extends JButton{

	public Forza4Button() {
		super();
		setContentAreaFilled(false);
		setBorderPainted(false);
		setMultiClickThreshhold(1000);
	
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Timer timer = new Timer();
				timer.schedule(up(returnForza4Button()), 0);
				timer.schedule(down(returnForza4Button()), 0);
				
			}
		});
	}
	
	public Forza4Button returnForza4Button(){
		return this;
	}

	/**
	 * Disegna un indicatore secondo l'azione da compiere
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		
		try {
		
			URL imgUrl = getClass().getResource(DefaultSettings.getSettings().getPath("indicatore1"));
			URL imgUrl1 = getClass().getResource(DefaultSettings.getSettings().getPath("indicatore2"));
			
			BufferedImage image = ImageIO.read(imgUrl);
			
			if (getModel().isPressed()){
				
				image = ImageIO.read(imgUrl1);
			}
			
			g.drawImage(image,-2,0,null);

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Dato un bottone, modifica la sua locazione per un tempo determinato, mandandolo in alto
	 * @param forza4Button
	 * @return task2
	 */
	public TimerTask up(final Forza4Button forza4Button){
		
		final TimerTask task2 = new TimerTask() {
			
			@Override
			public void run() {

				while(forza4Button.getLocation().y>60){
					forza4Button.setLocation(forza4Button.getLocation().x, forza4Button.getLocation().y-1);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		return task2;
		
	}
	
	/**
	 * Dato un bottone, modifica la sua locazione per un tempo determinato, mandandolo in basso
	 * @param forza4Button
	 * @return task1
	 */
	public TimerTask down(final Forza4Button forza4Button){
		final TimerTask task1 = new TimerTask() {
			
			@Override
			public void run() {

				while(forza4Button.getLocation().y<95){
					forza4Button.setLocation(forza4Button.getLocation().x, forza4Button.getLocation().y+1);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};
		return task1;
	}
	
	/**
	 * Restituisce la classe
	 * @return Forza4Button
	 */
	public JButton convertToJButton(){
		return this;
	}
}
