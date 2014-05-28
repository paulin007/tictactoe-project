package paulin.tchonin.trisandroid1;


/**
 * Un'astrazione sulla gestione delle partite
 * con il server
 *
 */
public interface IMatchManager {
	
	public String createNewMatch(String player1, String player2);
	
	public String connectToMatch(String player1, String player2);
	
	public String requestUpdate(int matchId);
	
}
