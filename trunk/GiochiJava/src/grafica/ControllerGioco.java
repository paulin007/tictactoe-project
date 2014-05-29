/**
 * Questa classe ha la responsabilità di gestire le richieste effettuate dall'utente,
 * attraverso l'interfaccia grafica
 * @author Giacomo
 */
package grafica;
import trisGui.PannelloGiocoTris;
import trisGui.SituazioneTurno;
import forza4Gui.PannelloGiocoForza4;

public class ControllerGioco {

	private ProxyPannelloGioco proxyPannelloTris;
	private String nomeGioco = "Tris";
	
	public ControllerGioco(ProxyPannelloGioco proxyPannelloTris) {
		super();
		this.proxyPannelloTris = proxyPannelloTris;
	}

	/**
	 * Questo metodo permette di impostare il pannello contente la lista di giocatori
	 */
	public void setPannelloGiocatori(){
		proxyPannelloTris.setPannelloGioco(new PannelloGiocatori(this));
	}

	/**
	 * Questo metodo permette di impostare il pannelo di gioco online
	 * @param simbolo
	 * @param icona
	 */
	public void setPannelloGiocoOnline(String simbolo,String icona,String ID){
		if(nomeGioco.equalsIgnoreCase("Tris")){
			proxyPannelloTris.setPannelloGioco(new PannelloGiocoTris(new SituazioneTurno(simbolo, icona, ID)));
		}
		if(nomeGioco.equalsIgnoreCase("Forza4")){
			proxyPannelloTris.setPannelloGioco(new PannelloGiocoForza4(new SituazioneTurno(simbolo, "", ID)));
		}
	}
	
	public void setPannelloStatistiche(){
		proxyPannelloTris.setPannelloGioco(new PannelloStatistica());
	}
	
	public String getNomeGioco() {
		return nomeGioco;
	}

	public void setNomeGioco(String nomeGioco) {
		this.nomeGioco = nomeGioco;
	}
}
