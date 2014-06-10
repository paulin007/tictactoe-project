package server;

import java.util.HashMap;

import servizi.IService;
import servizi.UpdateService;
import servizi.ConnectService;
import servizi.MoveService;
import servizi.NewMatchService;
import servizi.StatisticsService;
/**
 * Questa classe contiene una mappa in modo tale da associare ad una
 * Stringa un nuovo {@link IService}
 * @author santo
 *
 */
public class ServicesMap {

	private static HashMap<String, IService> mappa = new HashMap<>();
	private static final String NUOVA_PARTITA = "nuova partita";
	private static final String	COLLEGATI = "collegati a";
	private static final String UPDATE = "update";
	private static final String MOSSA = "mossa";
	private static final String STATISTICHE = "statistiche";

	/**
	 * Carica la mappa dai servizi gestiti dal server
	 */
	public static void loadServices() {
		loadHashMap(NUOVA_PARTITA, new NewMatchService());
		loadHashMap(COLLEGATI, new ConnectService());
		loadHashMap(MOSSA, new MoveService());
		loadHashMap(UPDATE, new UpdateService());
		loadHashMap(STATISTICHE, new StatisticsService());
		
	}

	private static void loadHashMap(String nomeServizio, IService servizio){
		mappa.put(nomeServizio, servizio);	
	}
	
	public static HashMap<String, IService> getMappa() {
		return mappa;
	}
	
}
