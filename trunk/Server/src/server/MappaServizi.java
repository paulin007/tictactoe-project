package server;

import java.util.HashMap;

import servizi.IServizio;
import servizi.ServizioAggiornamento;
import servizi.ServizioCollegamento;
import servizi.ServizioInviaMossa;
import servizi.ServizioNuovaPartita;
import servizi.ServizioStatistiche;
/**
 * Questa classe contiene una mappa in modo tale da associare ad una
 * Stringa un nuovo {@link IServizio}
 * @author santo
 *
 */
public class MappaServizi {

	private static HashMap<String, IServizio> mappa = new HashMap<>();
	private static final String NUOVA_PARTITA = "nuova partita";
	private static final String	COLLEGATI = "collegati a";
	private static final String UPDATE = "update";
	private static final String MOSSA = "mossa";
	private static final String STATISTICHE = "statistiche";

	/**
	 * Carica la mappa dai servizi gestiti dal server
	 */
	public static void caricaServizi() {
		caricaHashMap(NUOVA_PARTITA.toLowerCase(), new ServizioNuovaPartita());
		caricaHashMap(COLLEGATI.toLowerCase(), new ServizioCollegamento());
		caricaHashMap(MOSSA.toLowerCase(), new ServizioInviaMossa());
		caricaHashMap(UPDATE.toLowerCase(), new ServizioAggiornamento());
		caricaHashMap(STATISTICHE.toLowerCase(), new ServizioStatistiche());
		
	}

	private static void caricaHashMap(String nomeServizio, IServizio servizio){
		mappa.put(nomeServizio, servizio);	
	}
	
	public static HashMap<String, IServizio> getMappa() {
		return mappa;
	}
	
}
