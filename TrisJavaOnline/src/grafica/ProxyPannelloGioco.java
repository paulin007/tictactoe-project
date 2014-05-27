package grafica;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
 * Questa classe permette di cambiare a run time, i vari tipi di {@link PannelloGioco}
 */
@SuppressWarnings("serial")
public class ProxyPannelloGioco extends JPanel implements PannelloGioco {
	
	private PannelloGioco pannelloTris;

	public PannelloGioco getPannelloTris() {
		return pannelloTris;
	}

	public void setPannelloTris(PannelloGioco pannelloTris) {
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
