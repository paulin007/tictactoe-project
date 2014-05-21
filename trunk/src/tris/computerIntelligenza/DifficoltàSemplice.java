/**
 * Questa classe ha la responsabilità di gestire la generazione di mosse da parte del
 * PC, in modo causale
 * @author Giacomo
 */
package tris.computerIntelligenza;

import tris.Mossa;
import tris.Simbolo;
import tris.TabellaTris;

public class DifficoltàSemplice implements Difficoltà {
	
	public int generaMossa(TabellaTris tabellaTris) {
		Mossa.mossaCasuale(tabellaTris);
		tabellaTris.getCaselle().get(Mossa.getMossa()).setSimbolo(Simbolo.simboloG2);
		return Mossa.getMossa();
	}
	
}
