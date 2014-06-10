package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerWeb;
/**
 * Un'astrazione sul concetto di Servizio effettuto dal {@link ServerWeb}
 */
public interface IService {

	/**
	 * Effettua il servizio richiesto restituendo una stringa
	 * @param s StringTokenizer contenente i parametri da utilizzare nel servizio
	 * @param matches ArrayList di Partite con tutte le informazioni sulle partite trattate
	 * @return una stringa contenente tutte le informazioni aggiornate sulla partita
	 */
	public abstract String handleService(StringTokenizer s, ArrayList<Partita> matches);
	
}
