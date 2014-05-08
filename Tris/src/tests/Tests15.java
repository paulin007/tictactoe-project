package tests;

import interfacciaGrafica.PannelloGioco;

import java.awt.GridLayout;

import javax.swing.JFrame;

import tris.TabellaTris;
import vincita.GestoreVincite;
import vincita.AlgoritmoTris;
/**
 * Testo la funzionalità della classe GestoreVincite
 * @author Dario
 *
 */
public class Tests15 {

	public static void main(String[] args) {
		
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		PannelloGioco pannelloGioco = new PannelloGioco(tabellaTris, "Cerchio");
		
		
		AlgoritmoTris vincita = new AlgoritmoTris();
		GestoreVincite gestoreVincite = new GestoreVincite(pannelloGioco.getTabellaTris().getCaselle());
		
		
		
		JFrame frame = new JFrame("Test gestore vincite");
		frame.setVisible(true);
		frame.setLocation(300,300);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new GridLayout(1, 2));
		frame.getContentPane().add(pannelloGioco.creaPannello());
		
		
		
	}
}
