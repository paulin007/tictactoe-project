package computerIntelligenza;

import java.util.Random;

import tris.Casella;
import tris.TabellaTris;

public class DifficoltàNonImplementata implements Difficoltà {

	private static String simboloPC = "c";
	/**
	 * Si cerca di mettere la mossa nella casella successiva a quella del giocatore
	 */
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int i = 0;
		int mossa = 1;
		for (i = 0; i < tabellaTris.getCaselle().size(); i++) {
			Casella casella = tabellaTris.getCaselle().get(i);
			if(casella.occupataDaGiocatore()){
				if(i!=8){
					if(tabellaTris.getCaselle().get(i+1).isVuota()){
					mossa = i+1;
					break;
					}
				}else{
					boolean finito = false;
					Random random = new Random();
					int numero = random.nextInt(7);
					mossa = numero;
					while(finito){
						if(tabellaTris.getCaselle().get(numero).isVuota()){
							finito = true;
						}
					}
				}
			}
		}
		tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
		return mossa;
	}
}
