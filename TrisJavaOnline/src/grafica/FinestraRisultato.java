package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FinestraRisultato extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FinestraRisultato(String vincitore) {
		
		setTitle("Fine Partita");
		contentPanel.setBackground(new Color(171,205,239));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Font font = new Font("Font", Font.ITALIC, 20);
			try {
				URL url = getClass().getResource("/grafica/Akhenaton.ttf");
				font = Font.createFont(Font.TRUETYPE_FONT , new FileInputStream(new File(url.toURI())));
				float size = 100.0f;
				font = font.deriveFont(size);
			
				
			    URL percorsoSuono;
			    if(vincitore.equalsIgnoreCase("Hai vinto !"))percorsoSuono=getClass().getResource("/suoni/applausi.wav");
			    else percorsoSuono= getClass().getResource("/suoni/nur.wav");
		        
			    AudioInputStream audioIn = AudioSystem.getAudioInputStream(percorsoSuono);		       
		        Clip clip = AudioSystem.getClip();		        
		        clip.open(audioIn);
		        clip.start();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			JLabel lblHaVintoGiocatore = new JLabel("     "+vincitore);
			lblHaVintoGiocatore.setFont(font);
			lblHaVintoGiocatore.setBounds(10, 68, 414, 77);
			contentPanel.add(lblHaVintoGiocatore);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(171,205,239));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
}
