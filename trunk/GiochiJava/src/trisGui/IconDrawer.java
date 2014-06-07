package trisGui;

import java.net.URL;
import javax.swing.ImageIcon;
/**
 * Questa classe ha la responsabilità di disegnare un icona data un immagine
 * @author K. ADJIGNON
 */
public class IconDrawer {
	
	private URL imgUrl;
	
	public IconDrawer(String imgUrl) {
		this.imgUrl = getClass().getResource(imgUrl);
	}
	
	public ImageIcon Draw() {
		
		return new ImageIcon(imgUrl);
	}

}
