package tests;

import tris.Simbolo;
import tris.TabellaTris;
import vincita.AlgoritmoTris;
/**
 * Questo test verifica la condizione di pareggio
 * @author Dario
 *
 */
public class Tests05 {

	public static void main(String[] args) {
		
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(0).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(2).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(5).setSimbolo(Simbolo.simboloG2);
		
		tabellaTris.getCaselle().get(3).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(4).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(8).setSimbolo(Simbolo.simboloG1);
		
		
		AlgoritmoTris verificaVincita = new AlgoritmoTris();
		
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
}
