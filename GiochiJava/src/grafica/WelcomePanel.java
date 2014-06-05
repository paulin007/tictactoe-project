package grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Questa classe rappresenta il pannello di benvenuto una volta lanciata
 * l'applicazione
 *
 */
@SuppressWarnings("serial")
public class WelcomePanel extends JPanel{

	public WelcomePanel(){
		
		setBackground(Color.white);
		
		java.net.URL imgUrl = getClass().getResource("/trisGui/Immagini/Logo.png");
		ImageIcon image = new ImageIcon(imgUrl);
		
		JLabel label = new JLabel(image);	
		add(label);
	}
}
