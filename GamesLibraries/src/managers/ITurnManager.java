package managers;

public interface ITurnManager {

	public abstract void setMyTurn(boolean myTurn);

	public abstract boolean isMyTurn();

	public abstract void setConnected(boolean connected);
	
	public abstract boolean isConnected();
	
}