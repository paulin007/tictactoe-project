package trisGui;

import javax.swing.ImageIcon;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 */
public class Cerchio implements Icona{


	@Override
	public ImageIcon disegna() {
		

		java.net.URL imgUrl = getClass().getResource("/trisGui/Immagini/O.png");
		
		ImageIcon icon = new ImageIcon(imgUrl);
		return icon;
	}
	
	
}
