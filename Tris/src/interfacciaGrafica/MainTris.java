/**
 * Questo main permette di eseguire la parte grafica del gioco del tris
 * @author Giacomo
 */
package interfacciaGrafica;

import java.awt.Toolkit;

import javax.swing.JFrame;

import computerIntelligenza.DifficoltàSemplice;
import computerIntelligenza.ProxyDifficoltà;


public class MainTris {
	public MainTris() {
		ProxyPannelloTris pannelloTris = new ProxyPannelloTris();
		pannelloTris.setPannelloTris(new PannelloDiBenvenuto());
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàSemplice());
		MenuTris menuTris = new MenuTris(pannelloTris, proxyDifficoltà);
		
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
		MainTris mainTris = new MainTris();
	}
}
