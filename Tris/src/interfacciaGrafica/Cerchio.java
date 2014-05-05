package interfacciaGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Cerchio {

	public ImageIcon disegnaCerchio(){
		
		BufferedImage img = new BufferedImage(200,200, BufferedImage.TYPE_INT_RGB );
		
		Graphics g = img.getGraphics();
			
		g.setColor( Color.white );
		g.fillRect(0, 0, img.getHeight(), img.getWidth() );
				
		g.setColor( Color.GREEN );
		g.fillOval(75, 80, 50, 50 );	 

		ImageIcon icon = new ImageIcon( img );
		return icon;
	}
}
