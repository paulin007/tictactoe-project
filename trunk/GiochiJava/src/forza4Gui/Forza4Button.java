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

import managers.DefaultSettings;

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

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		
		try {
			java.net.URL imgUrl = getClass().getResource(DefaultSettings.getSettings().getPath("indicatore1"));
			java.net.URL imgUrl1 = getClass().getResource(DefaultSettings.getSettings().getPath("indicatore2"));
			
			BufferedImage image = ImageIO.read(imgUrl);
			
			if (getModel().isPressed()){
				
				image = ImageIO.read(imgUrl1);
			}
			
			g.drawImage(image,-2,0,null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	
			
	}
	

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
	
	public JButton convertToJButton(){
		return this;
	}
}
