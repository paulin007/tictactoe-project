package servizi;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.Partita;
import server.ServerWeb;
/**
 * Un'astrazione sul concetto di Servizio effettuto dal {@link ServerWeb}
 */
public interface IServizio {

	/**
	 * Effettua il servizio richiesto restituendo una stringa
	 * @param s
	 * @param partite
	 * @return
	 */
	public abstract String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite);
	
}
