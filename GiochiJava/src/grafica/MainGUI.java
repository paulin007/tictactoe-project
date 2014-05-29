package grafica;

import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * Questo main permette di eseguire la parte grafica del gioco del tris
 * @author Giacomo
 */
public class MainGUI {
	
	public MainGUI() {
	
		ProxyPannelloGioco pannelloGioco = new ProxyPannelloGioco();
		pannelloGioco.setPannelloGioco(new PannelloDiBenvenuto());
		ControllerGioco controllerGioco = new ControllerGioco(pannelloGioco);
		MenuGui menuTris = new MenuGui(controllerGioco);
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/trisGui/Immagini/tris.png")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,550);
		frame.add(pannelloGioco);
		frame.setJMenuBar(menuTris);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainGUI mainTris = new MainGUI();
	}
	
}
