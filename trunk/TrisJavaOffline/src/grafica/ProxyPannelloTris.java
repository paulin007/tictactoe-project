/**
 * Questa classe permette di cambiare a run time, i vari tipi di {@link PannelloTris}
 * @author Giacomo
 */
package grafica;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProxyPannelloTris extends JPanel implements PannelloTris {
	
	private PannelloTris pannelloTris;

	public PannelloTris getPannelloTris() {
		return pannelloTris;
	}

	public void setPannelloTris(PannelloTris pannelloTris) {
		this.pannelloTris = pannelloTris;
		update();
	}
	
	@Override
	public JPanel creaPannello() {
		return pannelloTris.creaPannello();
	}
	/**
	 * Questo metodo permette di aggiornare il pannello, ogni qualvolta cambia il pannello richiesto
	 */
	public void update() {
		removeAll();
		setLayout(new BorderLayout());
		add(pannelloTris.creaPannello());
		updateUI();
	}
}
