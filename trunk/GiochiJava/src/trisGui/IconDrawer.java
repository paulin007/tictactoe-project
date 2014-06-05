package trisGui;

import javax.swing.ImageIcon;
/**
 * Questa classe ha la responsabilità di disegnare un icona data un immagini
 * @author K. ADJIGNON
 */
public class IconDrawer {
	
	private java.net.URL imgUrl;
	
	public IconDrawer(String imgUrl) {
		this.imgUrl = getClass().getResource(imgUrl);
	}
	
	public ImageIcon Draw() {
		
		return new ImageIcon(imgUrl);
	}

}
