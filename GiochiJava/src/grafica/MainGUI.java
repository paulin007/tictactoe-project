package grafica;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import forza4Gui.PannelloGiocoForza4;
import trisGui.PannelloGiocoTris;
/**
 * Questo main permette di eseguire la parte grafica del gioco del tris
 * @author Giacomo
 */
public class MainGUI {
	
	public MainGUI() {
	
		PannelloPrincipale principale = new PannelloPrincipale(new PannelloDiBenvenuto());
		PannelloGiocoTris tris = new PannelloGiocoTris();
		PannelloGiocoForza4 forza4 = new PannelloGiocoForza4();
		ArrayList<PannelloGioco> pannelliGiochi = new ArrayList<>();
		pannelliGiochi.add(tris);
		pannelliGiochi.add(forza4);
		principale.setPannelliGiochi(pannelliGiochi);
		MenuGui menuTris = new MenuGui(principale);
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/trisGui/Immagini/tris.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,550);
		frame.add(principale);
		frame.setJMenuBar(menuTris);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainGUI mainTris = new MainGUI();
	}
	
}
