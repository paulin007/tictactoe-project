package grafica;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
 * Questa classe permette di cambiare a run time, i vari tipi di {@link PannelloGioco}
 */
@SuppressWarnings("serial")
public class ProxyPannelloGioco extends JPanel implements PannelloGioco {
	
	private PannelloGioco pannelloGioco;

	public PannelloGioco getPannelloGioco() {
		return pannelloGioco;
	}

	public void setPannelloGioco(PannelloGioco pannelloGioco) {
		this.pannelloGioco = pannelloGioco;
		update();
	}
	
	@Override
	public JPanel creaPannello() {
		return pannelloGioco.creaPannello();
	}
	/**
	 * Questo metodo permette di aggiornare il pannello, ogni qualvolta cambia il pannello richiesto
	 */
	public void update() {
		removeAll();
		setLayout(new BorderLayout());
		add(pannelloGioco.creaPannello());
		updateUI();
	}
}
