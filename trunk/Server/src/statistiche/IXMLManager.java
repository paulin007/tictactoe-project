package statistiche;

public interface IXMLManager {
	/**
	 * Restituisce gli achievements di un giocatore dato
	 * 
	 * @param player Il giocatore di cui si vuole avere l'elenco statistiche
	 * @param game Il gioco a cui ci si riferisci
	 * @return una stringa contenente tutte le informazioni
	 */
	public String getStatistic(String player, String game);
	
	/**
	 * Inserisce una nuova statistica per un dato giocatore ed un dato gioco
	 * 
	 * @param player Il giocatore che ha ottenuto il risultato
	 * @param score Un punteggio del tipo V vittoria, S sconfitta, P pareggio
	 * @param game Il gioco di cui si tratta
	 */
	public void newStatistic(String player, String score, String game);

}
