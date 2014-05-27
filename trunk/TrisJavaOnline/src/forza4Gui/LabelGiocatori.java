package forza4Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;

import javax.swing.JLabel;


public class LabelGiocatori extends JLabel{
	
	private String string;
	private Color color;
	
	public LabelGiocatori(String string, Color color) {
		super();
		this.color = color;
		this.string = string;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		Font font = new Font("Font", Font.ITALIC, 20);
		try {
			
			
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream("/Users/Giacomo/Desktop/Tris/TrisJava/src/forza4Gui/Akhenaton.ttf"));
		
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

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
//	public static void main(String[] args) {
//	
//
//		JFrame frame = new JFrame("Test");
//		LabelGiocatori font = new LabelGiocatori("Ciao",Color.RED);
//		frame.getContentPane().add(font);
//		frame.pack();
//		frame.setSize(550,550);
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}
