package computerIntelligenza;

import tris.TabellaTris;

public class DifficoltàMedia implements Difficoltà {

	private static String simboloPC = "c";
	
	@Override
	public int generaMossa(TabellaTris tabellaTris) {
		int mossa = -1;
		for (int i = 0; i < tabellaTris.getCaselle().size()-2; i++) {
			if(tabellaTris.getCaselle().get(i).isVuota()&&tabellaTris.getCaselle().get(i+1).isVuota()){
				tabellaTris.getCaselle().get(i).setSimbolo(simboloPC);
				mossa = i;
				break;
			}
		}
		return mossa;
	}
}
