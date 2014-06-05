package tris.computerIntelligenza;

import tris.TabellaTris;
/**
 * Inteerfaccia per i componenti che descrivono i livelli di difficoltà 
 * in gioco Offline (cioè contro il PC)
 */
public interface Difficolta {
	/**
	 * Questo metodo permette di generare un mossa da parte del PC
	 * @param tabellaTris
	 */
	public int generaMossa(TabellaTris tabellaTris);
}
