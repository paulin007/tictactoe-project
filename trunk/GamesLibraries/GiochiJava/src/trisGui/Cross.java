package trisGui;

import javax.swing.ImageIcon;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 * @author Kokou Adjignon
 */
public class Cross implements Icon {

	@Override
	public ImageIcon drawIcon(){
		
		java.net.URL imgUrl = getClass().getResource("/trisGui/Immagini/X.png");

		ImageIcon icon = new ImageIcon( imgUrl );
		return icon;
	}
}
