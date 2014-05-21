/**
 * Questo main permette di eseguire la parte grafica del gioco del tris
 * @author Giacomo
 */
package grafica;

import java.awt.Toolkit;

import javax.swing.JFrame;

import tris.AlgoritmoTris;
import tris.TabellaTris;
import tris.computerIntelligenza.DifficoltàSemplice;
import tris.computerIntelligenza.ProxyDifficoltà;

public class MainTris {
	
	public MainTris() {
	
		ProxyPannelloTris pannelloTris = new ProxyPannelloTris();
		pannelloTris.setPannelloTris(new PannelloDiBenvenuto());
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàSemplice());
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		AlgoritmoTris algoritmoTris = new AlgoritmoTris();
		ControllerTris controllerTris = new ControllerTris(proxyDifficoltà, pannelloTris, tabellaTris, algoritmoTris);
		MenuTris menuTris = new MenuTris(controllerTris);
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tris.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(pannelloTris);
		frame.setJMenuBar(menuTris);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainTris mainTris = new MainTris();
	}
	
}
