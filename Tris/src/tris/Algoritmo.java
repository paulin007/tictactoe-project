/**
 * Questa interfaccia astrae sul concetto di algoritmo, presente in un gioco
 */
package tris;

public interface Algoritmo {
	/**
	 * Questo metodo è in grado di poter inviare un comando e ritornare una stringa,
	 * che permette di ritorno un valore generato dall'algoritmo
	 * @param mossa
	 * @return
	 */
	public String execute(String mossa);

}
