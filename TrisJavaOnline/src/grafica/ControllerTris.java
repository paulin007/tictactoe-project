/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import rete.Client;

public class ControllerTris {

	private ProxyPannelloTris proxyPannelloTris;
	private Client client = new Client();
	
	public ControllerTris(ProxyPannelloTris proxyPannelloTris) {
		super();
		this.proxyPannelloTris = proxyPannelloTris;

	}

	public ProxyPannelloTris getProxyPannelloTris() {
		return proxyPannelloTris;
	}

	public void setProxyPannelloTris(ProxyPannelloTris proxyPannelloTris) {
		this.proxyPannelloTris = proxyPannelloTris;
	}

	/**
	 * Questo metodo permette di impostare il pannello contente la lista di giocatori
	 */
	public void setPannelloGiocatori(){
		proxyPannelloTris.setPannelloTris(new PannelloGiocatori(this));
	}

	/**
	 * Questo metodo permette di impostare il pannelo di gioco online
	 * @param simbolo
	 * @param icona
	 */
	public void setPannelloGiocoOnline(String simbolo,String icona,String ID){
		proxyPannelloTris.setPannelloTris(new PannelloGiocoOnline(this,simbolo,icona,ID));
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

}
