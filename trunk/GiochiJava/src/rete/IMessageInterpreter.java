package rete;

import java.util.ArrayList;

public interface IMessageInterpreter {

	/**
	 * Interpreta il messaggio ricevuto dal server
	 */
	public abstract void interpret(String message);

	public abstract String getServiceRequest();

	public abstract String getMatchStatus();

	public abstract String getMatchID();

	public abstract String getLastPlayer();

	public abstract ArrayList<String> getBoxes();

}