/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import rete.Client;
import tris.Simbolo;
import tris.TabellaTris;
import tris.computerIntelligenza.DifficoltàSemplice;
import tris.computerIntelligenza.ProxyDifficoltà;
import tris.vincita.AlgoritmoTris;

public class ControllerTris {

	private ProxyDifficoltà proxyDifficolta;
	private ProxyPannelloTris proxyPannelloTris;
	private PannelloCheckBox pannelloCheckBox;
	private TabellaTris tabellaTris;
	private AlgoritmoTris algoritmoTris;
	private PannelloGiocatori pannelloGiocatori;
	private PannelloGiocoOnline pannelloGiocoOnline;
	private Client client = new Client();
	
	
	public ControllerTris(ProxyDifficoltà proxyDifficolta,
			ProxyPannelloTris proxyPannelloTris, TabellaTris tabellaTris,
			AlgoritmoTris algoritmoTris) {
		super();
		this.proxyDifficolta = proxyDifficolta;
		this.proxyPannelloTris = proxyPannelloTris;
		this.tabellaTris = tabellaTris;
		this.algoritmoTris = algoritmoTris;
	}
	public PannelloCheckBox getPannelloCheckBox() {
		return pannelloCheckBox;
	}

	
	public ProxyPannelloTris getProxyPannelloTris() {
		return proxyPannelloTris;
	}

	public void setProxyPannelloTris(ProxyPannelloTris proxyPannelloTris) {
		this.proxyPannelloTris = proxyPannelloTris;
	}

	public ProxyDifficoltà getProxyDifficolta() {
		return proxyDifficolta;
	}

	public void setProxyDifficolta(ProxyDifficoltà proxyDifficolta) {
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
		pannelloCheckBox = new PannelloCheckBox(this);
		proxyPannelloTris.setPannelloTris(pannelloCheckBox);
	}
	/**
	 * Questo metodo permette di impostare il pannello contente la lista di giocatori
	 */
	public void setPannelloGiocatori(){
		pannelloGiocatori = new PannelloGiocatori(this);
		proxyPannelloTris.setPannelloTris(pannelloGiocatori);
	}
	/**
	 * Questo metodo permette di impostare il pannello di gioco contro il Computer
	 */
	public void setPannelloGioco(){
		PannelloGioco pannelloGioco = new PannelloGioco(this);
		proxyPannelloTris.setPannelloTris(pannelloGioco);
	}
	/**
	 * Questo metodo permette di impostare il pannelo di gioco online
	 * @param simbolo
	 * @param icona
	 */
	public void setPannelloGiocoOnline(String simbolo,String icona){
		pannelloGiocoOnline = new PannelloGiocoOnline(this,simbolo,icona);
		proxyPannelloTris.setPannelloTris(pannelloGiocoOnline);
	}
	
	public PannelloGiocatori getPannelloGiocatori() {
		return pannelloGiocatori;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void resetController(){
		setProxyDifficolta(new ProxyDifficoltà(new DifficoltàSemplice()));
		setTabellaTris(new TabellaTris());
		setAlgoritmoTris(new AlgoritmoTris());
	}
}
