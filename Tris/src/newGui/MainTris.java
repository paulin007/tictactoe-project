/**
 * Questo main permette di eseguire la parte grafica del gioco del tris
 * @author Giacomo
 */
package newGui;

import javax.swing.JFrame;

import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.ProxyDifficoltà;

public class MainTris {
	public static void main(String[] args) {
		ProxyPannelloTris pannelloTris = new ProxyPannelloTris();
		pannelloTris.setPannelloTris(new PannelloDiBenvenuto());
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàCasuale());
		MenuTris menuTris = new MenuTris(pannelloTris, proxyDifficoltà);
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(pannelloTris);
		frame.setJMenuBar(menuTris);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
