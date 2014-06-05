package grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import managers.DefaultSettings;
/**
 * Questa classe rappresenta il pannello di benvenuto una volta lanciata
 * l'applicazione
 *
 */
@SuppressWarnings("serial")
public class WelcomePanel extends JPanel{

	public WelcomePanel(){
		
		setBackground(Color.white);
		
		java.net.URL imgUrl = getClass().getResource(DefaultSettings.getSettings().getPath("logo"));
		ImageIcon image = new ImageIcon(imgUrl);
		
		JLabel label = new JLabel(image);	
		add(label);
	}
}
