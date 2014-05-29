package grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Questa classe rappresenta il pannello di benvenuto una volta lanciata
 * l'applicazione
 *
 */
@SuppressWarnings("serial")
public class PannelloDiBenvenuto extends JPanel implements PannelloGioco {


	@Override
	public JPanel creaPannello() {

		setBackground(Color.white);
		
		java.net.URL imgUrl = getClass().getResource("/trisGui/immagini/Logo.png");
		ImageIcon image = new ImageIcon(imgUrl);
	
		JLabel label = new JLabel(image);
		add(label);
		return this;
	}
}
