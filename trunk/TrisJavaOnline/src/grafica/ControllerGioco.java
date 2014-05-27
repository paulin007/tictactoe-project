/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import forza4Gui.PannelloGiocoForza4;
import rete.Client;
import trisGui.PannelloGiocoOnlineTris;

public class ControllerGioco {

	private ProxyPannelloGioco proxyPannelloTris;
	private Client client = new Client();
	private String nomeGioco = "Tris";
	
	public ControllerGioco(ProxyPannelloGioco proxyPannelloTris) {
		super();
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
		if(nomeGioco.equalsIgnoreCase("Tris")){
		proxyPannelloTris.setPannelloTris(new PannelloGiocoOnlineTris(this,simbolo,icona,ID));
		}
		if(nomeGioco.equalsIgnoreCase("Forza4")){
			proxyPannelloTris.setPannelloTris(new PannelloGiocoForza4(this, simbolo,ID));
		}
	}
	
	
	public String getNomeGioco() {
		return nomeGioco;
	}

	public void setNomeGioco(String nomeGioco) {
		this.nomeGioco = nomeGioco;
	}

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
