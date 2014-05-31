package grafica;

import javax.swing.JPanel;

import trisGui.SituazioneTurno;
/**
 * Questa classe astrae sul concetto di Pannello che viene utilizzato nell'applicazione Tris
 */
public interface PannelloGioco {
	
	/**
	 * Questo metodo permette di creare un pannello e recuperarlo
	 * @return
	 */
	public JPanel creaPannello();
	
	public void setTurno(SituazioneTurno turno);
	
	

}
