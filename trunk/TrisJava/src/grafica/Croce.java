package grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 * @author Kokou Adjignon
 */
public class Croce implements Icona {

	@Override
	public ImageIcon disegna(){
		
		BufferedImage img = new BufferedImage(200,200, BufferedImage.TYPE_INT_RGB );
		
		// Get a Graphics object
		Graphics g = img.getGraphics();
		Graphics g1 = img.getGraphics();
		
		// Create white background
		g1.setColor( Color.white );
		g1.fillRect(0, 0, img.getHeight(), img.getWidth() );
		
		//Draw a cross
		g.setColor( Color.RED );

		g.drawLine(71, 120, 121, 70);
		g.drawLine(72, 120, 122, 70);
		g.drawLine(73, 120, 123, 70);
		g.drawLine(74, 120, 124, 70);
		
		g.drawLine(71, 70, 121, 120);
		g.drawLine(72, 70, 122, 120);
		g.drawLine(73, 70, 123, 120);
		g.drawLine(74, 70, 124, 120);
		
		// Create imageIcon from BufferedImage
		ImageIcon icon = new ImageIcon( img );
		return icon;
	}
}
