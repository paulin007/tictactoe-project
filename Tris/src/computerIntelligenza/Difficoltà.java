package computerIntelligenza;

import tris.TabellaTris;

public interface Difficoltà {
	/**
	 * Questo metodo permette di generare un mossa da parte del PC
	 * @param tabellaTris
	 */
	public int generaMossa(TabellaTris tabellaTris);
}
