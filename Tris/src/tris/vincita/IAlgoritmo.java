package tris.vincita;

import java.util.ArrayList;

import tris.Casella;

/**
 * Un'astrazione sull'algoritmo di giochi
 * basati su logica a {@link Casella}
 * @author Santo Amedeo
 *
 */

public interface IAlgoritmo {
	
	/**
	 * Ritorna la stringa contenente il vincitore
	 * @param caselle
	 * @return
	 */
	public String stabilisciVincitore(ArrayList<Casella> caselle);
	
}
