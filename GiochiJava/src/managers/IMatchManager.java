package managers;

import java.util.Observer;

import rete.InterpreteMessaggio;

/**
 * Un'astrazione sulla gestione delle partite
 * con il server
 *
 */
public interface IMatchManager {
	
	public void createNewMatch(String player1, String player2);
	
	public void connectToMatch(String player1, String player2);
	
	public void sendMove(int location);
	
	public void requestUpdate();
	
	public void endMatch();
	
	public void addObserver(Observer observer);		//TODO va veramente bene cosi?
	
	public InterpreteMessaggio getInterprete();
	
}
