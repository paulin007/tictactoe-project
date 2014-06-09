package statistiche;

public interface IXMLManager {
	/**
	 * Restituisce gli achievements di un giocatore dato
	 * 
	 * @param giocatore
	 * @param gioco
	 * @return
	 */
	public String richiediStatistica(String giocatore, String gioco);
	
	/**
	 * Inserisce un nuova o modifica achievement di un giocatore
	 * 
	 * @param giocatore
	 * @param esito
	 * @param gioco
	 */
	public void nuovaStatistica(String giocatore, String esito, String gioco);

}
