package forza4Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class LabelSfida extends JLabel{
	private String string;
	
	public LabelSfida(String string) {
		super();
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
		
		
		
		char[] vector = string.toCharArray();
	
		g.setFont(font);
		for (int i = 0; i < vector.length; i++) {
			
			if(i%2==0){
				g.setColor(new Color(239,231,13));
				g.drawString(String.valueOf(vector[i]), 30*i, 50);
			}
			if(i%2==1 ){
				g.setColor(new Color(196,44,0));
				if(i==1){
					
					g.drawString(String.valueOf(vector[i]), 40*i, 50);
				}
				if(i!=1){
				
					g.drawString(String.valueOf(vector[i]), 30*i, 50);
				}
				
			}
		}
		super.paintComponent(g);
	}
	
	public static void main(String[] args) {
	

		JFrame frame = new JFrame("Test");
		LabelSfida font = new LabelSfida("Ciao");
		frame.getContentPane().add(font);
		frame.pack();
		frame.setSize(550,550);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
