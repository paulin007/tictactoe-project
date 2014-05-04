package computerIntelligenza;

import tris.Casella;
import tris.TabellaTris;

public class DifficoltàDifficile implements Difficoltà {
	private static String simboloPC = "c";
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int mossa = -1;
		for (int i = 0; i < tabellaTris.getCaselle().size()-2; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+1);
			Casella casella3 = tabellaTris.getCaselle().get(i+2);
			if(casella1.occupataDaGiocatore()&&casella2.occupataDaGiocatore()){
				mossa = i+2;
				break;
			}else{
				if(casella1.occupataDaComputer()&&casella2.occupataDaComputer()){
					if(casella3.isVuota()){
						mossa = casellaTerza(casella1, casella2);
					}
				}
				if(casella1.occupataDaComputer()&&casella3.occupataDaComputer()){
					mossa = casellaInMezzo(casella1, casella3);
				}
			}
		}
		tabellaTris.getCaselle().get(mossa).setSimbolo(simboloPC);
		return mossa;
	}
	
	private int casellaTerza(Casella casella1,Casella casella2){
		return casella1.getIDcasella()+2;
	}
	private int casellaInMezzo(Casella casella1,Casella casella3){
		return casella1.getIDcasella()+1;
	}
	
}
