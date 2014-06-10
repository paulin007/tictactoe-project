package rete;

/**
 * Interfaccia Client
 * 
 * @author Andrea Gallo
 *
 */
public interface IClient {
	
	/** 
	 * Metodo per mandare un messaggio ad un server
	 * @param message Messaggio da mandare al server
	 * @return Stringa di risposta dal server
	 */

	public String send(String message);
	
}
