package tris.computerIntelligenza;

import tris.Mossa;
import tris.Simbolo;
import tris.TabellaTris;

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
