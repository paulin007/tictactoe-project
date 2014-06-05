package grafica;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Questa classe astrae sul concetto di Pannello che viene utilizzato nell'applicazione Tris
 */
public interface GamePanel {

	/**
	 * Questo metodo permette di creare un pannello e recuperarlo
	 * @return
	 */
	public JPanel createPanel();

	public ArrayList<JButton> getBoxes();

	public void setMySymbol(String mySymbol);

}
