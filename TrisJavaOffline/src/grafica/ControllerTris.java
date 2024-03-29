/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import tris.AlgoritmoTris;
import tris.TabellaTris;
import tris.computerIntelligenza.DifficoltaSemplice;
import tris.computerIntelligenza.ProxyDifficolta;

public class ControllerTris {

	private ProxyDifficolta proxyDifficolta;
	private ProxyPannelloTris proxyPannelloTris;
	private TabellaTris tabellaTris;
	private AlgoritmoTris algoritmoTris;
	private String scelta;
	
	
	public ControllerTris(ProxyDifficolta proxyDifficolta,
			ProxyPannelloTris proxyPannelloTris, TabellaTris tabellaTris,
			AlgoritmoTris algoritmoTris) {
		super();
		this.proxyDifficolta = proxyDifficolta;
		this.proxyPannelloTris = proxyPannelloTris;
		this.tabellaTris = tabellaTris;
		this.algoritmoTris = algoritmoTris;
	}

	public ProxyPannelloTris getProxyPannelloTris() {
		return proxyPannelloTris;
	}

	public void setProxyPannelloTris(ProxyPannelloTris proxyPannelloTris) {
		this.proxyPannelloTris = proxyPannelloTris;
	}

	public ProxyDifficolta getProxyDifficolta() {
		return proxyDifficolta;
	}

	public void setProxyDifficolta(ProxyDifficolta proxyDifficolta) {
		this.proxyDifficolta = proxyDifficolta;
	}

	public TabellaTris getTabellaTris() {
		return tabellaTris;
	}

	public void setTabellaTris(TabellaTris tabellaTris) {
		this.tabellaTris = tabellaTris;
	}

	public AlgoritmoTris getAlgoritmoTris() {
		return algoritmoTris;
	}

	public void setAlgoritmoTris(AlgoritmoTris algoritmoTris) {
		this.algoritmoTris = algoritmoTris;
	}
	/**
	 * Questo metodo permette di impostare il pannello di decisione dell'icona e dell'avvio della partita
	 * contro il computer
	 */
	public void setPannelloCheckBox(){
		proxyPannelloTris.setPannelloTris(new PannelloCheckBox(this));
	}
	/**
	 * Questo metodo permette di impostare il pannello di gioco contro il Computer
	 */
	public void setPannelloGioco(){
		proxyPannelloTris.setPannelloTris(new PannelloGioco(this, scelta));
	}
	
	
	/**
	 * Reimposta le difficoltà, l'algoritmo e la tabella tris per il giocoOffline
	 */
	public void resetController(){
		setProxyDifficolta(new ProxyDifficolta(new DifficoltaSemplice()));
		setTabellaTris(new TabellaTris());
		setAlgoritmoTris(new AlgoritmoTris());
	}
	
	public void setScelta(String scelta) {
		this.scelta = scelta;
	}
}
