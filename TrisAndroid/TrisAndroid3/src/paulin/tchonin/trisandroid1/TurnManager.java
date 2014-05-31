package paulin.tchonin.trisandroid1;
/**
 * Classe la cui responsabilità è quella di
 * gestire i turni di gioco
 * @author Santo Amedeo
 *
 */
public class TurnManager {

	private static boolean myTurn;
	
	public static void setMyTurn(boolean myTurn) {
		TurnManager.myTurn = myTurn;
	}
	
	public static boolean isMyTurn() {
		return myTurn;
	}
	
}
