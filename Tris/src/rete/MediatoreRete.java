/**
 * Questa classe astrae sul concetto di invio e ricezione di messaggi dalla rete, che servono
 * per interagire tra i dispositivi
 */
package rete;

public interface MediatoreRete {
	/**
	 * Questo metodo peremtte di ricevere un pacchetto attraverso la classe {@link Client}
	 */
	public void ricevi(Client client);
	/**
	 * Questo metodo permette di recuperare l'ultimo messaggio rievuto
	 * @return
	 */
	public String getMessaggio();
	/**
	 * Questo messaggio permette di inviare un pacchetto di rete
	 * @param messaggio
	 */
	public void invia (Client client,String messaggio);
}
