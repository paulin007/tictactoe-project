package server;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 *Interfaccia per i componenti che descrivono la logica di funzionamento del server
 */
public interface IServizio {

	/**
	 * Dati un token e un arrayList di Partita, effettua il servizio richiesto e 
	 * fornisce una stringa che contiene la risposta 
	 * @param s
	 * @param partite
	 * @return
	 */
	public abstract String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite);
	
}
