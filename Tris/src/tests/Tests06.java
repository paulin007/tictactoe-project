package tests;

import tris.Simbolo;
import tris.TabellaTris;
import tris.vincita.AlgoritmoTris;
/**
 * Questo test verifica la vittoria da parte del giocatore
 * @author Dario
 *
 */
public class Tests06 {
	
	public static void main(String[] args) {
		
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(1).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(2).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(3).setSimbolo(Simbolo.simboloG2);
		
		tabellaTris.getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(4).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(8).setSimbolo(Simbolo.simboloG1);
		
		
		AlgoritmoTris verificaVincita = new AlgoritmoTris();
		
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
}
