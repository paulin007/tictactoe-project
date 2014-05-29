package forza4Gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Pulsante extends JButton{

	
	public Pulsante() {
		super();
		setContentAreaFilled(false);
		setBorderPainted(false);
		setMultiClickThreshhold(1000);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Timer timer = new Timer();
				
				timer.schedule(sali(returnPulsante()), 0);
				timer.schedule(scendi(returnPulsante()), 0);
				
			}
		});
	}
	public Pulsante returnPulsante(){
		return this;
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		
		try {
			java.net.URL imgUrl = getClass().getResource("Immagini/indicatore1.png");
			java.net.URL imgUrl1 = getClass().getResource("Immagini/indicatore2.png");
			
			BufferedImage image = ImageIO.read(imgUrl);
			
			if (getModel().isPressed()){
				
				image = ImageIO.read(imgUrl1);
			}
			
			g.drawImage(image,-2,0,null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
	}
	

	public TimerTask sali(final Pulsante pulsante){
		
		final TimerTask task2 = new TimerTask() {
			
			@Override
			public void run() {

				while(pulsante.getLocation().y>60){
					pulsante.setLocation(pulsante.getLocation().x, pulsante.getLocation().y-1);
					try {
						Thread.sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		return task2;
		
	}
	public TimerTask scendi(final Pulsante pulsante){
		final TimerTask task1 = new TimerTask() {
			
			@Override
			public void run() {

				while(pulsante.getLocation().y<95){
					pulsante.setLocation(pulsante.getLocation().x, pulsante.getLocation().y+1);
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
}
