package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.swing.JLabel;


@SuppressWarnings("serial")
public class PlayersLabel extends JLabel{
	
	private String string;
	private Color color;
	
	public PlayersLabel(String string, Color color) {
		super();
		this.color = color;
		this.string = string;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		Font font = new Font("Font", Font.ITALIC, 20);
		try {
			
			URL url = getClass().getResource("/forza4Gui/Akhenaton.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream(new File(url.toURI())));
		
			float size = 100.0f;
			font = font.deriveFont(size);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
		g.setFont(font);
		g.setColor(color);
		g.drawString(string, 40, 50);
		
		super.paintComponent(g);
	}

	
	public void setColor(Color color) {
		this.color = color;
		updateUI();
	}
}
