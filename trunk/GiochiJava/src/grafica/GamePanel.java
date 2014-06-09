package grafica;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Questa classe descrive un' astrazione sul Pannello usato durante una partita di un gioco,
 */
public interface GamePanel {

	/**
	 * Questo metodo permette di creare un pannello e recuperarlo
	 * @return panel
	 */
	public JPanel createPanel();

	public ArrayList<JButton> getBoxes();

	public void setMySymbol(String mySymbol);

}
