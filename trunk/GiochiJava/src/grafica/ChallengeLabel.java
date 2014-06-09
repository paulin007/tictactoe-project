package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;

import javax.swing.JLabel;

import managers.DefaultSettings;
/**
 * Elabora l'aspetto del labello che mostra la frase di challenge 'VS'
 */
@SuppressWarnings("serial")
public class ChallengeLabel extends JLabel{
	private String string;
	
	public ChallengeLabel(String string) {
		super();
		this.string = string;
	}
	
	@Override
	protected void paintComponent(Graphics g) {

		Font font = new Font("Font", Font.ITALIC, 20);
		try {
			
			
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream("src"+
					DefaultSettings.getSettings().getPath("akhenaton")));
		
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
}
