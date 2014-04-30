/**
 * Questa classe ha la responsabilità di gestire la generazione di mosse da parte del
 * PC, in modo causale
 * @author Giacomo
 */
package computerIntelligenza;

import java.util.Random;

import tris.TabellaTris;

public class DifficoltàCasuale implements Difficoltà {
	
	private static String simboloPC = "c";
	
	public void generaMossa(TabellaTris tabellaTris) {
		Random random = new Random();
		boolean finito = false;
		int k = 0;
		while(!finito&&k<9){
			k++;
			if(tabellaTris.getCaselle().get(random.nextInt(9)).casellaVuota()){
				tabellaTris.getCaselle().get(random.nextInt(9)).setSimbolo(simboloPC);
				finito = true;
			}
		}
	}
}
