package computerIntelligenza;

import java.util.Random;

import tris.TabellaTris;

public class DifficoltàMedia implements Difficoltà {

	private static String simboloPC = "c";
	
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int mossa = 0;
		if(tabellaTris.possibileScacco()){
				mossa = tabellaTris.getMossa();
				tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
				}else{
					Random random = new Random();
					boolean finito = false;
					int k = 0;
					int numero = -1; 
					
					while(!finito&& k<9){
						k++;
						mossa = random.nextInt(9);
						if(tabellaTris.getCaselle().get(mossa).isVuota()){
							tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
							finito = true;
						}
					}
				}
		
		return mossa;
	}
}
