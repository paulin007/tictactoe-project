/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import rete.Client;
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
	
	public void setPannelloCheckBox(){
		pannelloCheckBox = new PannelloCheckBox(this);
		proxyPannelloTris.setPannelloTris(pannelloCheckBox);
	}
	
	public void setPannelloGiocatori(){
		pannelloGiocatori = new PannelloGiocatori(this);
		proxyPannelloTris.setPannelloTris(pannelloGiocatori);
	}
	
	public void setPannelloGioco(){
		PannelloGioco pannelloGioco = new PannelloGioco(this);
		proxyPannelloTris.setPannelloTris(pannelloGioco);
	}
	
	public void setPannelloGiocoOnline(){
		pannelloGiocoOnline = new PannelloGiocoOnline(this);
		proxyPannelloTris.setPannelloTris(pannelloGiocoOnline);
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
