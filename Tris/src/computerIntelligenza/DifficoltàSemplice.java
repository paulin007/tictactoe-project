/**
 * Questa classe ha la responsabilità di gestire la generazione di mosse da parte del
 * PC, in modo causale
 * @author Giacomo
 */
package computerIntelligenza;

import java.util.Random;

import tris.Simbolo;
import tris.TabellaTris;

public class DifficoltàSemplice implements Difficoltà {
	
	private static String simboloPC = "c";
	
	public int generaMossa(TabellaTris tabellaTris) {
		Random random = new Random();
		boolean finito = false;
		int k = 0;
		int numero = -1; 
		
		while(!finito&& k<9){
			k++;
			numero = random.nextInt(9);
			if(tabellaTris.getCaselle().get(numero).isVuota()){
				tabellaTris.getCaselle().get(numero).setSimbolo(Simbolo.simboloG2);
				finito = true;
			}
		}
		return numero;
	}
	
	public int generaMossaNew(TabellaTris tabellaTris){
		
		int numero = (int)(Math.random()*9);
			
			if(tabellaTris.getCaselle().get(numero).isVuota()){
				tabellaTris.getCaselle().get(numero).setSimbolo(Simbolo.simboloG2);
				
			}
			else generaMossaNew(tabellaTris);
		
		return numero;
	}
}
