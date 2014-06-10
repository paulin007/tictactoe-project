package managers;

/**
 * Classe la cui responsabilita  a quella di
 * gestire i turni di gioco
 * @author Santo Amedeo
 *
 */
public class TurnManager implements ITurnManager {

	private boolean myTurn;
	private boolean connected;
	
	/* (non-Javadoc)
	 * @see trisGUI.ITurnManager#setMyTurn(boolean)
	 */
	@Override
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}
	
	/* (non-Javadoc)
	 * @see trisGUI.ITurnManager#isMyTurn()
	 */
	@Override
	public boolean isMyTurn() {
		return myTurn;
	}
	
	@Override
	public void setConnected(boolean connected){
		this.connected = connected;
	}
	
	@Override
	public boolean isConnected() {
		return connected;
	}
	
}
