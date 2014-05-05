package computerIntelligenza;

import java.util.Random;

import tris.Casella;
import tris.TabellaTris;

public class DifficoltàDifficile implements Difficoltà {
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
			}
		}
		if(!tabellaTris.getCaselle().get(mossa).isVuota()){
			
		}
			if(possibileScacco(tabellaTris)){
				mossa = difenditi();
			}
			mosseVerticali(tabellaTris);
			mosseDiagonali(tabellaTris);
			mosseOrizzontali(tabellaTris);
			
			tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
			return mossa;
	}
	
	
	
	private void mosseVerticali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i+6);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = i+6;
			}
		}
		for (int i = 3; i < 6; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i-3);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa =  i-3;
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
		}
		if(casella4.possibileMossa(casella8, casella0)){
			mossa = 0;
		}
		if(casella2.possibileMossa(casella4, casella6)){
			mossa = 6;
		}
		if(casella4.possibileMossa(casella6, casella2)){
			mossa = 2;
		}
		if(casella0.possibileMossa(casella8, casella4)){
			mossa = 4;
		}
		if(casella2.possibileMossa(casella6, casella4)){
			mossa = 4;
		}
	}
	private void mosseOrizzontali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(0+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(2+3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 2+3*i;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 3*i;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(1+3*i);
			if(casella1.possibileMossa(casella2, casella3)){
				mossa = 1+3*i;
			}
		}
	}
	private boolean possibileScacco(TabellaTris tabellaTris){
		boolean possibileScacco = false;
		for (int i = 0; i < 3; i++) {
			Casella casellaA = tabellaTris.getCaselle().get(0+3*i);
			Casella casellaB = tabellaTris.getCaselle().get(1+3*i);
			if(casellaA.casellaConsecutivaG(casellaB)){
				possibileScacco = true;
				mossa = 2+3*i;
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casellaA = tabellaTris.getCaselle().get(1+3*i);
			Casella casellaB = tabellaTris.getCaselle().get(2+3*i);
			if(casellaA.casellaConsecutivaG(casellaB)){
				possibileScacco = true;
				mossa = 3*i;
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casellaA = tabellaTris.getCaselle().get(i);
			Casella casellaB = tabellaTris.getCaselle().get(i+3);
			if(casellaA.casellaConsecutivaG(casellaB)){
				possibileScacco = true;
				mossa = i+6;
				break;
			}
		}
		return possibileScacco;
	}
	private int difenditi(){
		return mossa;
	}
}
