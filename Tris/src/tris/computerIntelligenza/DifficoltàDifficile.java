/**
 * Questa classe ha la reponsabilità di gestire la creazione di una massa, con un livello di difficoltà
 * difficile
 * @author Giacomo
 */
package tris.computerIntelligenza;

import java.util.Random;

import tris.Casella;
import tris.Simbolo;
import tris.TabellaTris;

public class DifficoltàDifficile implements Difficoltà  {
	private static String simboloPC = "c";
	private int mossa;
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		Random random = new Random();
		boolean finito = false;
		int k = 0;
		while(!finito&& k<9){
			k++;
			mossa = random.nextInt(9);
			if(tabellaTris.getCaselle().get(mossa).isVuota()){
				finito = true;
				System.out.println("Attacco casuale"+mossa);
			}
		}

		if(tabellaTris.possibileScacco()){
			mossa = tabellaTris.getMossa();
			
		}
		
		mosseVerticali(tabellaTris);
		mosseDiagonali(tabellaTris);
		mosseOrizzontali(tabellaTris);
		
		
			
		tabellaTris.getCaselle().get(mossa).setSimbolo(Simbolo.simboloG2);
		return mossa;
	}
	
	/*
	 *  i metodi mosseVerticali/orizzontali/diagonali verificano che se due
	 *  caselle sono occupate dal pc, allora se la terza casella Ã¨ libera la occupa per vincere
	 */
	
	
	private void mosseVerticali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i+6);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = i+6;
				System.out.println("Attacco verticale"+mossa);
				break;
			}
		}
		for (int i = 3; i < 6; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i-3);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa =  i-3;
				System.out.println("Attacco verticale"+mossa);
				break;
			}
		}
		
	}
	private void mosseDiagonali(TabellaTris tabellaTris){
		Casella casella0 = tabellaTris.getCaselle().get(0);
		Casella casella2 = tabellaTris.getCaselle().get(2);
		Casella casella4 = tabellaTris.getCaselle().get(4);
		Casella casella6 = tabellaTris.getCaselle().get(6);
		Casella casella8 = tabellaTris.getCaselle().get(8);
		
		if(casella0.possibileMossa(casella4, casella8)){
			mossa = 8;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella4.possibileMossa(casella8, casella0)){
			mossa = 0;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella2.possibileMossa(casella4, casella6)){
			mossa = 6;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella4.possibileMossa(casella6, casella2)){
			mossa = 2;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella0.possibileMossa(casella8, casella4)){
			mossa = 4;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella2.possibileMossa(casella6, casella4)){
			mossa = 4;
			System.out.println("Attacco diagonale"+mossa);
		}
		
	}
	private void mosseOrizzontali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(0+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(2+3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 2+3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(1+3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 1+3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		
	}
}