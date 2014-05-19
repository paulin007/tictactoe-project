package tris.computerIntelligenza;

import tris.Mossa;
import tris.Simbolo;
import tris.TabellaTris;
/**
 * questa classe ha la responsabilità di gestire la generazione di mosse da parte del PC, in modo che, 
 * se il giocatore è nella condizione di vincere, il PC cerca di diffendersi,
 * altrimenti genera una mossa in modo casuale
 */
public class DifficoltàMedia implements Difficoltà {
	
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int mossa = 0;
		if(Mossa.possibileScacco(tabellaTris)){
				mossa = Mossa.getMossa();
				tabellaTris.getCaselle().get(mossa).setSimbolo(Simbolo.simboloG2);
				}else{
					Mossa.mossaCasuale(tabellaTris);
				}
		
		return mossa;
	}
	
}
