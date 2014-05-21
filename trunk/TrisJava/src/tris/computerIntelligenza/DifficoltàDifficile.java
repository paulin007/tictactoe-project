/**
 * Questa classe ha la reponsabilità di gestire la creazione di una massa, con un livello di difficoltà
 * difficile
 * @author Giacomo
 */
package tris.computerIntelligenza;

import tris.Mossa;
import tris.Simbolo;
import tris.TabellaTris;

public class DifficoltàDifficile implements Difficoltà  {
	
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		Mossa.mossaCasuale(tabellaTris);

		if(Mossa.possibileScacco(tabellaTris)){
			tabellaTris.getCaselle().get(Mossa.getMossa()).setSimbolo(Simbolo.simboloG2);
		}else{
		
			mosseVerticali(tabellaTris);
			mosseDiagonali(tabellaTris);
			mosseOrizzontali(tabellaTris);
			tabellaTris.getCaselle().get(Mossa.getMossa()).setSimbolo(Simbolo.simboloG2);
		}
		return Mossa.getMossa();
	}
	
	/*
	 *  i metodi mosseVerticali/orizzontali/diagonali verificano che se due
	 *  caselle sono occupate dal pc, allora se la terza casella Ã¨ libera la occupa per vincere
	 */
	
	
	private void mosseVerticali(TabellaTris tabellaTris){
		Mossa.mosseVerticali(tabellaTris);
	}
	
	private void mosseDiagonali(TabellaTris tabellaTris){
		Mossa.mosseDiagonali(tabellaTris);		
	}
	
	private void mosseOrizzontali(TabellaTris tabellaTris){
		Mossa.mosseOrizzontali(tabellaTris);
	}
}