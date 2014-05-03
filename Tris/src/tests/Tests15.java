package tests;

import java.awt.GridLayout;

import javax.swing.JFrame;

import tris.TabellaTris;
import utils.componenti.CheckBoxPanel;
import utils.componenti.JButtonPanel;
import vincita.GestoreVincite;
import vincita.VerificaVincita;
/**
 * Testo la funzionalità della classe GestoreVincite
 * @author Dario
 *
 */
public class Tests15 {

	public static void main(String[] args) {
		
		CheckBoxPanel boxPanel = new CheckBoxPanel();
		JButtonPanel panel = new JButtonPanel(boxPanel);
		
		VerificaVincita vincita = new VerificaVincita();
		GestoreVincite gestoreVincite = new GestoreVincite(vincita, panel.getTabellaTris().getCaselle());
		
		
		
		JFrame frame = new JFrame("Test gestore vincite");
		frame.setVisible(true);
		frame.setLocation(300,300);
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(1, 2));
		frame.getContentPane().add(panel);
		frame.getContentPane().add(boxPanel);
		
		
	}
}
