package computerIntelligenza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import tris.Casella;
import tris.TabellaTris;

public class DifficoltàDifficile implements Difficoltà {
	private static String simboloPC = "c";
	HashMap<ArrayList<Casella>, Integer> schema = new HashMap<>();
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int mossa = -1;
		for (int i = 0; i < tabellaTris.getCaselle().size()-2; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+1);
			if(casella1.occupataDaGiocatore()&&casella2.occupataDaGiocatore()){
				mossa = i+2;
				break;
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
		tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
		return mossa;
	}
	private void creaSchema(){
		
	}
}
