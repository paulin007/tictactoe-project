package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import managers.DefaultSettings;
/**
 *Questa classe ha la responsabilità di creare un pannello di dialogo per communicare l'esito della partita
 */
@SuppressWarnings("serial")
public class ResultDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ResultDialog(String vincitore) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Fine Partita!");
		setVisible(true);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(171,205,239));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	
		JLabel label = new JLabel(vincitore);
		label.setBounds(84, 61, 259, 80);
		contentPanel.add(label);
		
		Font font = new Font("Font", Font.ITALIC, 20);
		try {
			URL url = getClass().getResource(DefaultSettings.getSettings().getPath("akhenaton"));
			font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream(new File(url.toURI())));
			float size = 100.0f;
			font = font.deriveFont(size);
			label.setFont(font);
			
		    URL percorsoSuono;
		    if(vincitore.equalsIgnoreCase("Hai vinto !")) {
		    	percorsoSuono=getClass().getResource(DefaultSettings.getSettings().getPath("applausi"));
		    } else {
		    	percorsoSuono= getClass().getResource(DefaultSettings.getSettings().getPath("nur"));
		    }
	        
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(percorsoSuono);		       
	        Clip clip = AudioSystem.getClip();		        
	        clip.open(audioIn);
	        clip.start();
	        
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
