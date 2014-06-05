package trisGui;

import javax.swing.ImageIcon;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 */
public class Circle implements Icon{

	@Override
	public ImageIcon drawIcon() {
		

		java.net.URL imgUrl = getClass().getResource("/trisGui/Immagini/O.png");
		
		ImageIcon icon = new ImageIcon(imgUrl);
		return icon;
	}
	
}
