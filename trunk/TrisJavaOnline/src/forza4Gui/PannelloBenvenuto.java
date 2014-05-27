package forza4Gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PannelloBenvenuto extends JPanel{

	public PannelloBenvenuto() {
	
		
		
		JLabel label = new JLabel();
		java.net.URL imgUrl = getClass().getResource("Forza4logo.png");
		ImageIcon icon = new  ImageIcon(imgUrl);
		
		label.setIcon(icon);
		
		
	
		
	}
	
}
