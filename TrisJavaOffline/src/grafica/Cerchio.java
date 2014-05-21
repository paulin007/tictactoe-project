package grafica;

import javax.swing.ImageIcon;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 * @author Kokou Adjignon
 */
public class Cerchio implements Icona{


	@Override
	public ImageIcon disegna() {
		
		java.net.URL imgUrl = getClass().getResource("O.png");

		ImageIcon icon = new ImageIcon( imgUrl );
		return icon;
	}
	
	
}
