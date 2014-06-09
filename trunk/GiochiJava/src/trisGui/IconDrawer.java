package trisGui;

import java.net.URL;
import javax.swing.ImageIcon;
/**
 * Questa classe ha la responsabilità di disegnare un icona data un immagine
 * @author K. ADJIGNON
 */
public class IconDrawer {
	
	private URL imgUrl;
	private ImageIcon imgIcon;
	
	public IconDrawer(String imgUrl) {
		this.imgUrl = getClass().getResource(imgUrl);
		Draw();
	}
	
	/**
	 * Data un immagine disegna la sua icona
	 * @return ImageIcon
	 */
	public void Draw() {
		imgIcon = new ImageIcon(imgUrl);
	}
	
	public ImageIcon getIcon() {
		return imgIcon;
	}

}
